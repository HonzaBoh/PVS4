package gui;

import javax.swing.*;
import java.awt.*;

public class GridPanels extends JFrame {

    GridPanels(){
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

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++) {
            gridPanel.add(new JButton(String.valueOf(i+1)));
        }
        this.add(gridPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new GridPanels().setVisible(true);
    }
}
