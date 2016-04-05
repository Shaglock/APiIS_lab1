import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Widget5 extends JPanel {
    int rowSize = 1;
    JTextField text = new JTextField(10);
    DefaultTableModel model = new DefaultTableModel(rowSize, 2);
    JTable table = new JTable(model);
    JButton add = new JButton("add");
    JButton MoveTo2Button = new JButton("Move to 2");
    JButton MoveTo1Button = new JButton("Move to 1");

    public Widget5() {
        add.addActionListener(actionEvent -> {
            table.setValueAt(text.getText(), rowSize - 1, 0);
            text.setText("");
            model.addRow(new Object[]{"", ""});
            rowSize++;
        });

        MoveTo2Button.addActionListener(actionEvent -> {
            int[] selectedRows = table.getSelectedRows();
            for (int selectedRow : selectedRows) {
                if (table.getValueAt(selectedRow, 0) != "") {
                    table.setValueAt(table.getValueAt(selectedRow, 0), selectedRow, 1);
                    table.setValueAt("", selectedRow, 0);
                }
            }

        });

        MoveTo1Button.addActionListener(actionEvent -> {
            int[] selectedRows = table.getSelectedRows();
            for (int selectedRow : selectedRows) {
                if (table.getValueAt(selectedRow, 1) != "") {
                    table.setValueAt(table.getValueAt(selectedRow, 1), selectedRow, 0);
                    table.setValueAt("", selectedRow, 1);
                }
            }

        });
        add(text);
        add(add);
        add(MoveTo1Button);
        add(MoveTo2Button);
        add(table);
    }


}