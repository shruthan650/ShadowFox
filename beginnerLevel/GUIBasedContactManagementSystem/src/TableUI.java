import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.*;

public class TableUI {
    JFrame frame;
    JTable table;
    DefaultTableModel model;
    JPanel panel;

    JTextField nameField;
    JTextField phoneField;
    JTextField emailField;

    JButton addButton;
    JButton updateButton;
    JButton deleteButton;

    List<ContactStructure> contacts;
    ExceptionHandler handler;

    public TableUI() {
        contacts = new ArrayList<>();
        handler = new ExceptionHandler();
        initializeComponents();
        setupTable();
        setupPanel();
        setupFrame();
        setupActions();
    }

    void initializeComponents() {
        frame = new JFrame("Contact Management System");
        panel = new JPanel();
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        emailField = new JTextField(15);
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
    }

    void setupTable() {
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Phone");
        model.addColumn("Email");
        table = new JTable(model);
    }

    void setupPanel() {
        panel.add(new JLabel("Name"));
        panel.add(nameField);

        panel.add(new JLabel("Phone"));
        panel.add(phoneField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
    }

    void setupFrame() {
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);

        frame.setSize(900, 500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void setupActions() {
        new AddContactAction(addButton, model, contacts, handler, nameField, phoneField, emailField, frame);

        new DeleteContactAction(deleteButton, table, model, contacts, frame, nameField, phoneField, emailField);

        new UpdateContactAction(updateButton, table, model, contacts, handler, frame, nameField, phoneField, emailField);

        new TableSelectionAction(table, model, nameField, phoneField, emailField);
    }
}