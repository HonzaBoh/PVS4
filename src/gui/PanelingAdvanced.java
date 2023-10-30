package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelingAdvanced extends JFrame {
    JButton button;
    PanelingAdvanced(){
        this.setSize(750, 750);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        this.add(redPanel, BorderLayout.NORTH);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        this.add(bluePanel, BorderLayout.EAST);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        this.add(greenPanel, BorderLayout.WEST);


        JPanel yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.yellow);
        this.add(yellowPanel, BorderLayout.SOUTH);

        bluePanel.setPreferredSize(new Dimension(100, 100));
        greenPanel.setPreferredSize(new Dimension(100, 100));
        yellowPanel.setPreferredSize(new Dimension(100, 100));
        redPanel.setPreferredSize(new Dimension(100, 100));

        button = new JButton("Rotate!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color tmp = yellowPanel.getBackground();
                yellowPanel.setBackground(bluePanel.getBackground());
                bluePanel.setBackground(redPanel.getBackground());
                redPanel.setBackground(greenPanel.getBackground());
                greenPanel.setBackground(tmp);
            }
        });
        this.add(button, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new PanelingAdvanced().setVisible(true);
    }
}
