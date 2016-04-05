import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Widget3 extends JPanel {
    JTextField text = new JTextField(10);
    JButton changeButton = new JButton("Change");
    ButtonGroup group = new ButtonGroup();
    JRadioButton radioButton1 = new JRadioButton("1");
    JRadioButton radioButton2 = new JRadioButton("2");
    JRadioButton radioButton3 = new JRadioButton("3");
    JPanel buttonPanel = new JPanel();

    Widget3() {
        setLayout(new FlowLayout());

        add(text);

        changeButton.setPreferredSize(new Dimension(100, 20));
        add(changeButton);

        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        buttonPanel.add(radioButton1);
        buttonPanel.add(radioButton2);
        buttonPanel.add(radioButton3);

        add(buttonPanel, BorderLayout.SOUTH);

        changeButton.addActionListener(new Check());
    }


    public class Check implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (text.getText().equals("1"))
                radioButton1.setSelected(true);
            else if (text.getText().equals("2"))
                radioButton2.setSelected(true);
            else if (text.getText().equals("3"))
                radioButton3.setSelected(true);
            else JOptionPane.showMessageDialog(null, "There is no such radio button.");
        }
    }
}