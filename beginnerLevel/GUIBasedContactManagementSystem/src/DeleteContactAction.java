import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DeleteContactAction {

    public DeleteContactAction(
            JButton deleteButton,
            JTable table,
            DefaultTableModel model,
            List<ContactStructure> contacts,
            JFrame frame,
            JTextField nameField,
            JTextField phoneField,
            JTextField emailField
    ) {

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1 && selectedRow < contacts.size()) {
                contacts.remove(selectedRow);
                model.removeRow(selectedRow);
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
            else {
                JOptionPane.showMessageDialog(frame, "Please select a row first");
            }
        });
    }
}