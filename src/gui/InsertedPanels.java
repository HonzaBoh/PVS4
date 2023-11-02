package gui;

import javax.swing.*;
import java.awt.*;

public class InsertedPanels extends JFrame {
    InsertedPanels() {
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

        JPanel addingPanel = new JPanel();
        addingPanel.setBackground(Color.cyan);
        this.add(addingPanel, BorderLayout.CENTER);

        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(Color.orange);
        JPanel purplePanel = new JPanel();
        purplePanel.setBackground(Color.magenta);
        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.lightGray);
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(new Color(0x5B0202));

        orangePanel.setPreferredSize(new Dimension(50, 50));
        purplePanel.setPreferredSize(new Dimension(50, 50));
        grayPanel.setPreferredSize(new Dimension(50, 50));
        colorPanel.setPreferredSize(new Dimension(50, 50));

        addingPanel.setLayout(new BorderLayout());

        addingPanel.add(orangePanel, BorderLayout.NORTH);
        addingPanel.add(purplePanel, BorderLayout.SOUTH);
        addingPanel.add(colorPanel, BorderLayout.EAST);
        addingPanel.add(grayPanel, BorderLayout.WEST);
    }

    public static void main(String[] args) {
        new InsertedPanels().setVisible(true);
    }
}
