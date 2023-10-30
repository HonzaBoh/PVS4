package gui;

import javax.swing.*;
import java.awt.*;

public class Paneling extends JFrame {
    public Paneling(){
        this.setSize(750, 750);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel redPanel = new JPanel();
        redPanel.setBackground(new Color(0xFF0000));
        redPanel.setBounds(0,0, 250, 250);
        this.add(redPanel);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0x0000FF));
        bluePanel.setBounds(250,0, 250, 250);
        this.add(bluePanel);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(new Color(0x00FF00));
        greenPanel.setBounds(0,250, 500, 250);
        this.add(greenPanel);
        JLabel something = new JLabel("Some text");
        greenPanel.add(something);
    }

    public static void main(String[] args) {
        new Paneling().setVisible(true);
    }
}
