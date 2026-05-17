package com.shruthan;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    private static final String DB_URL =
            "jdbc:sqlite:library.db";

    @BeforeEach
void setup() {

    File db = new File("library.db");

    if (db.exists()) {
        db.delete();
    }

    Database.createDatabase();
}

    // =========================
    // CREATE DATABASE TEST
    // =========================

    @Test
    void testDatabaseCreation() {

        assertDoesNotThrow(() -> {
            Database.createDatabase();
        });
    }

    // =========================
    // ADD BOOK TEST
    // =========================

    @Test
    void testAddBook() {

        assertDoesNotThrow(() -> {

            Database.addBook(
                    "Java",
                    "James Gosling",
                    "Programming",
                    "2026-05-16",
                    "123456789",
                    true
            );
        });
    }

    // =========================
    // ADD BORROWER TEST
    // =========================

    @Test
    void testAddBorrower() {

        assertDoesNotThrow(() -> {

            Database.addBorrower(
                    "Shruthan",
                    "shruthan@gmail.com",
                    "9876543210",
                    "Bangalore"
            );
        });
    }

    // =========================
    // ADD CHECKOUT TEST
    // =========================

    @Test
    void testAddCheckout() {

        assertDoesNotThrow(() -> {

            Database.addBook(
                    "Python",
                    "Guido",
                    "Programming",
                    "2026-05-16",
                    "987654321",
                    true
            );

            Database.addBorrower(
                    "Keerthan",
                    "keerthan@gmail.com",
                    "999999999",
                    "Mysore"
            );

            Database.addCheckout(
                    "1",
                    "1",
                    "2026-05-16",
                    "2026-05-20",
                    ""
            );
        });
    }

    // =========================
    // DELETE TEST
    // =========================

   @Test
void testDeleteBook() {

    assertDoesNotThrow(() -> {

        Database.addBook(
                "DSA",
                "Author",
                "CS",
                "2026-05-17",
                "9999",
                true
        );

        Database.delete("books", "1");
    });
}

    // =========================
    // EMPTY DELETE ID TEST
    // =========================

    @Test
    void testDeleteEmptyID() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,

                () -> {
                    Database.delete("books", "");
                });

        assertEquals(
                "ID field cannot be empty",
                ex.getMessage()
        );
    }

    // =========================
    // INVALID TABLE TEST
    // =========================

    @Test
    void testInvalidTableDelete() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,

                () -> {
                    Database.delete("hackers", "1");
                });

        assertEquals(
                "Invalid table name",
                ex.getMessage()
        );
    }

    // =========================
    // SQL INJECTION TEST
    // =========================

    @Test
    void testSQLInjectionProtection() {

        Exception ex = assertThrows(
                IllegalArgumentException.class,

                () -> {
                    Database.delete(
                            "books; DROP TABLE books;",
                            "1"
                    );
                });

        assertEquals(
                "Invalid table name",
                ex.getMessage()
        );
    }

    // =========================
    // FOREIGN KEY TEST
    // =========================

    @Test
    void testForeignKeyConstraint() {

        assertThrows(Exception.class, () -> {

            Database.addCheckout(
                    "999",
                    "999",
                    "2026-05-16",
                    "2026-05-20",
                    ""
            );
        });
    }

    // =========================
    // BOOK AVAILABILITY TEST
    // =========================

    @Test
    void testBookAvailabilityUpdate() {

        assertDoesNotThrow(() -> {

            Database.addBook(
                    "C++",
                    "Bjarne",
                    "Programming",
                    "2026-05-16",
                    "11111",
                    true
            );

            Database.addBorrower(
                    "Ram",
                    "ram@gmail.com",
                    "99999999",
                    "Delhi"
            );

            Database.addCheckout(
                    "1",
                    "1",
                    "2026-05-16",
                    "2026-05-20",
                    ""
            );

            Connection conn =
                    DriverManager.getConnection(DB_URL);

            PreparedStatement stmt =
                    conn.prepareStatement(
                            "SELECT available FROM books WHERE id = 1"
                    );

            ResultSet rs = stmt.executeQuery();

            boolean available =
                    rs.getBoolean("available");

            assertFalse(available);

            rs.close();
            stmt.close();
            conn.close();
        });
    }
}