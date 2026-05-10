import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UpdateContactAction {

    public UpdateContactAction(
            JButton updateButton,
            JTable table,
            DefaultTableModel model,
            List<ContactStructure> contacts,
            ExceptionHandler handler,
            JFrame frame,
            JTextField nameField,
            JTextField phoneField,
            JTextField emailField
    ) {
        updateButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1 && selectedRow < contacts.size()) {
                try {
                    String updatedName = nameField.getText();
                    String updatedPhone = phoneField.getText();
                    String updatedEmail = emailField.getText();

                    handler.phoneHandler(updatedPhone, contacts);
                    handler.emailHandler(updatedEmail, contacts);

                    for (int i = 0; i < contacts.size(); i++) {
                        if (i != selectedRow) {
                            if (contacts.get(i).getPhoneNumber().equals(updatedPhone)) {
                                throw new IllegalArgumentException("Phone Number Already Exists");
                            }

                            if (contacts.get(i).getEmailAddress().equalsIgnoreCase(updatedEmail)) {
                                throw new IllegalArgumentException("Email Already Exists");
                            }
                        }
                    }

                    ContactStructure currentContact = contacts.get(selectedRow);

                    currentContact.setName(updatedName);
                    currentContact.setPhoneNumber(updatedPhone);
                    currentContact.setEmailAddress(updatedEmail);

                    model.setValueAt(updatedName, selectedRow, 0);
                    model.setValueAt(updatedPhone, selectedRow, 1);
                    model.setValueAt(updatedEmail, selectedRow, 2);

                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                }

                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                } 
            }

            else JOptionPane.showMessageDialog(frame, "Please select a row first");
        });
    }
}