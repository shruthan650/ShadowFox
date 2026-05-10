import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AddContactAction {

    public AddContactAction(
            JButton addButton,
            DefaultTableModel model,
            List<ContactStructure> contacts,
            ExceptionHandler handler,
            JTextField nameField,
            JTextField phoneField,
            JTextField emailField,
            JFrame frame
    ) {addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();

                handler.phoneHandler(phone, contacts);
                handler.emailHandler(email, contacts);

                ContactStructure contact = new ContactStructure();

                contact.setName(name);
                contact.setPhoneNumber(phone);
                contact.setEmailAddress(email);
                contacts.add(contact); 

                model.addRow(new Object[]{ name, phone, email });

                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }

            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });
    }
}