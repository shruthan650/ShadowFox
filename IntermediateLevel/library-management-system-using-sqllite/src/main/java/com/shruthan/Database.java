package com.shruthan;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database {

    // Database path
    private static final String DB_URL = "jdbc:sqlite:library.db";

    // Helper method for connections
    private static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL);

        Statement stmt = conn.createStatement();
        stmt.execute("PRAGMA foreign_keys = ON");

        return conn;
    }

    // Add Book
    static void addBook(String title,
                        String author,
                        String genre,
                        String publicationDate,
                        String isbn,
                        boolean available) throws SQLException {

        String query =
                "INSERT INTO books (title, author, genre, publication_date, isbn, available) VALUES (?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(query)
        ) {

            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.setString(4, publicationDate);
            stmt.setString(5, isbn);
            stmt.setBoolean(6, available);

            stmt.executeUpdate();
        }
    }

    // Add Borrower
    static void addBorrower(String name,
                            String email,
                            String phone,
                            String address) throws SQLException {

        String query =
                "INSERT INTO borrowers(name, email, phone, address) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(query)
        ) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, address);

            stmt.executeUpdate();
        }
    }

    // Add Checkout
    static void addCheckout(String bookID,
                            String borrowerID,
                            String checkoutDate,
                            String dueDate,
                            String returnDate) throws SQLException {

        String query =
                "INSERT INTO checkouts(book_id, borrower_id, checkout_date, due_date, return_date) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement(query)
        ) {

            stmt.setInt(1, Integer.parseInt(bookID));
            stmt.setInt(2, Integer.parseInt(borrowerID));
            stmt.setString(3, checkoutDate);
            stmt.setString(4, dueDate);
            stmt.setString(5, returnDate);

            stmt.executeUpdate();

            // Mark book unavailable
            PreparedStatement updateStmt =
                    conn.prepareStatement(
                            "UPDATE books SET available = 0 WHERE id = ?");

            updateStmt.setInt(1, Integer.parseInt(bookID));
            updateStmt.executeUpdate();
        }
    }

    // Create Database
    static void createDatabase() {

        try (
                Connection conn = getConnection();
                Statement stmt = conn.createStatement()
        ) {

            String createBooksTable =
                    "CREATE TABLE IF NOT EXISTS books (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "title TEXT NOT NULL, " +
                            "author TEXT NOT NULL, " +
                            "genre TEXT, " +
                            "publication_date TEXT, " +
                            "isbn TEXT, " +
                            "available INTEGER DEFAULT 1" +
                            ")";

            stmt.executeUpdate(createBooksTable);

            String createBorrowersTable =
                    "CREATE TABLE IF NOT EXISTS borrowers (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL, " +
                            "email TEXT UNIQUE NOT NULL, " +
                            "phone TEXT, " +
                            "address TEXT" +
                            ")";

            stmt.executeUpdate(createBorrowersTable);

            String createCheckoutsTable =
                    "CREATE TABLE IF NOT EXISTS checkouts (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "book_id INTEGER NOT NULL, " +
                            "borrower_id INTEGER NOT NULL, " +
                            "checkout_date TEXT NOT NULL, " +
                            "due_date TEXT NOT NULL, " +
                            "return_date TEXT, " +
                            "FOREIGN KEY (book_id) REFERENCES books(id), " +
                            "FOREIGN KEY (borrower_id) REFERENCES borrowers(id)" +
                            ")";

            stmt.executeUpdate(createCheckoutsTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Entry
static void delete(String tableName,
                   String id) throws SQLException {

    // Check empty ID
    if (id == null || id.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "ID field cannot be empty");
    }

    // Allow only valid tables
    if (!tableName.equals("books") &&
        !tableName.equals("borrowers") &&
        !tableName.equals("checkouts")) {

        throw new IllegalArgumentException(
                "Invalid table name");
    }

    String query =
            "DELETE FROM " + tableName + " WHERE id = ?";

    try (
            Connection conn = getConnection();
            PreparedStatement stmt =
                    conn.prepareStatement(query)
    ) {

        stmt.setInt(1, Integer.parseInt(id));
        stmt.executeUpdate();
    }
}

    // Refresh Tables
    static void refreshTables(DefaultTableModel bookModel,
                              DefaultTableModel borrowerModel,
                              DefaultTableModel checkoutModel) {

        bookModel.setRowCount(0);
        borrowerModel.setRowCount(0);
        checkoutModel.setRowCount(0);

        try (
                Connection conn = getConnection();

                PreparedStatement booksStmt =
                        conn.prepareStatement(
                                "SELECT * FROM books");

                PreparedStatement borrowersStmt =
                        conn.prepareStatement(
                                "SELECT * FROM borrowers");

                PreparedStatement checkoutsStmt =
                        conn.prepareStatement(
                                "SELECT * FROM checkouts");

                ResultSet bookResults =
                        booksStmt.executeQuery();

                ResultSet borrowerResults =
                        borrowersStmt.executeQuery();

                ResultSet checkoutResults =
                        checkoutsStmt.executeQuery()
        ) {

            while (bookResults.next()) {

                Object[] row = {
                        bookResults.getInt("id"),
                        bookResults.getString("title"),
                        bookResults.getString("author"),
                        bookResults.getString("genre"),
                        bookResults.getString("publication_date"),
                        bookResults.getString("isbn"),
                        bookResults.getBoolean("available")
                };

                bookModel.addRow(row);
            }

            while (borrowerResults.next()) {

                Object[] row = {
                        borrowerResults.getInt("id"),
                        borrowerResults.getString("name"),
                        borrowerResults.getString("email"),
                        borrowerResults.getString("phone"),
                        borrowerResults.getString("address")
                };

                borrowerModel.addRow(row);
            }

            while (checkoutResults.next()) {

                Object[] row = {
                        checkoutResults.getInt("id"),
                        checkoutResults.getInt("book_id"),
                        checkoutResults.getInt("borrower_id"),
                        checkoutResults.getString("checkout_date"),
                        checkoutResults.getString("due_date"),
                        checkoutResults.getString("return_date")
                };

                checkoutModel.addRow(row);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }
}