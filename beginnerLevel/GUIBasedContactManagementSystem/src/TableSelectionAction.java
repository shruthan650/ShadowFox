import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableSelectionAction {

    public TableSelectionAction(
            JTable table,
            DefaultTableModel model,
            JTextField nameField,
            JTextField phoneField,
            JTextField emailField
    ) {

        table.getSelectionModel().addListSelectionListener(e -> {
                    int selectedRow = table.getSelectedRow();

                    if (selectedRow != -1) {
                        nameField.setText(model.getValueAt(selectedRow, 0).toString());
                        phoneField.setText(model.getValueAt(selectedRow, 1).toString());
                        emailField.setText(model.getValueAt(selectedRow,2).toString());
                    }
                });
    }
}