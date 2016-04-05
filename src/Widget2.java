import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Widget2 extends JPanel {
    JTextField text = new JTextField(10);
    JButton changeButton = new JButton("Change");
    JButton swapButton = new JButton("Swap");
    String temp;


    Widget2() {
        setLayout(new FlowLayout());

        add(text);

        changeButton.setPreferredSize(new Dimension(100, 20));
        add(changeButton);

        swapButton.setPreferredSize(new Dimension(150, 20));
        add(swapButton);


        changeButton.addActionListener(new Change());
        swapButton.addActionListener(new Swap());
    }

    public class Change implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent action) {
            swapButton.setText(text.getText());
        }
    }

    public class Swap implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent action) {
            temp = changeButton.getText();
            changeButton.setText(swapButton.getText());
            swapButton.setText(temp);
        }
    }
}