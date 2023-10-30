package gui;

import javax.swing.*;
import java.awt.*;

public class Flowing extends JFrame {
    Flowing(){
        this.setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));
        panel.setPreferredSize(new Dimension(250,250));
        this.add(panel);
        for (int i = 0; i < 9; i++) {
            panel.add(new JButton(String.valueOf(i+1)));
        }
    }

    public static void main(String[] args) {
        new Flowing().setVisible(true);
    }
}
