import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ComponentsShift extends Thread {

    Container[] newWidgets;

    ComponentsShift(Container[] widgets) {
        newWidgets = widgets;
    }

    public void run() {
        do {
            if (!Thread.interrupted()) {
                for (Container widgetWindow : newWidgets) {
                    Component[] allComponents = widgetWindow.getComponents();
                    widgetWindow.removeAll();
                    for (int current = 0, next = 1; next < allComponents.length; current++, next++) {
                        Component temp = allComponents[current];
                        allComponents[current] = allComponents[next];
                        allComponents[next] = temp;
                    }
                    for (Component oneComponent : allComponents) {
                        widgetWindow.add(oneComponent);
                    }
                    widgetWindow.validate();
                }
            } else return;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}


public class Main {
    static ComponentsShift shifter;

    public static void main(String[] args) {
        JMenuBar menuBar = new JMenuBar();

        JMenuItem startItem = new JMenuItem("Start");
        JMenuItem stopItem = new JMenuItem("Stop");

        menuBar.add(startItem);
        menuBar.add(stopItem);

        JFrame window = new JFrame("Widgets by Ilya");
        window.setSize(540, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Widget1 widget1 = new Widget1();
        Widget2 widget2 = new Widget2();
        Widget3 widget3 = new Widget3();
        Widget4 widget4 = new Widget4();
        Widget5 widget5 = new Widget5();
        Box mainBox = Box.createVerticalBox();
        window.setContentPane(mainBox);


        window.setJMenuBar(menuBar);

        mainBox.add(widget1, Box.createHorizontalStrut(12));
        mainBox.add(widget2, Box.createHorizontalStrut(12));
        mainBox.add(widget3, Box.createHorizontalStrut(12));
        mainBox.add(widget4, Box.createHorizontalStrut(12));
        mainBox.add(widget5, Box.createHorizontalStrut(12));

        window.setVisible(true);

        startItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startItem.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                startItem.setBackground(Color.white);
            }
        });
        stopItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                stopItem.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                stopItem.setBackground(Color.white);
            }
        });
        startItem.addActionListener(e -> {

            Container[] widgets = {widget1, widget2, widget3, widget4, widget5};
            shifter = new ComponentsShift(widgets);
            shifter.start();
        });

        stopItem.addActionListener(e -> shifter.interrupt());
    }
}
