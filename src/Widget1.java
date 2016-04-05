import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Widget1 extends JPanel {
    JTextField text = new JTextField(10);
    JComboBox<String> box = new JComboBox<>();
    JButton button = new JButton("Click");
    Copy copying = new Copy();

    Widget1() {

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        button.setPreferredSize(new Dimension(100, 20));
        button.addActionListener(copying);
        add(button);
        add(text);
        add(box);
    }

    public class Copy implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            for (int i = 0; i < box.getItemCount(); i++) {
                if (0 == text.getText().compareTo(box.getItemAt(i))) {
                    JOptionPane.showMessageDialog(null, "This item already exists");
                    return;
                }
            }
            box.addItem(text.getText());
            box.setSelectedIndex(0);
        }
    }
}