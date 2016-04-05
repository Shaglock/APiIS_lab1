import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Widget4 extends JPanel {
    JTextField textField = new JTextField(10);
    JButton changeButton = new JButton("Change");
    JCheckBox checkBox1 = new JCheckBox("1");
    JCheckBox checkBox2 = new JCheckBox("2");
    JCheckBox checkBox3 = new JCheckBox("3");


    Widget4() {
        setLayout(new FlowLayout());

        add(textField);


        changeButton.setPreferredSize(new Dimension(100, 20));
        add(changeButton);

        add(textField);
        add(changeButton);
        add(checkBox1);
        add(checkBox2);
        add(checkBox3);


        changeButton.addActionListener(new Check());
    }


    public class Check implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (textField.getText().equals("1"))
                checkBox1.setSelected(!checkBox1.isSelected());
            else if (textField.getText().equals("2"))
                checkBox2.setSelected(!checkBox2.isSelected());
            else if (textField.getText().equals("3"))
                checkBox3.setSelected(!checkBox3.isSelected());
            else JOptionPane.showMessageDialog(null, "Тhere is no such checkBox");
        }
    }
}