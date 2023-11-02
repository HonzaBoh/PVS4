package gui;

import javax.swing.*;
import java.awt.*;

public class Flowing extends JFrame {
    Flowing(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 30,30));


        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setPreferredSize(new Dimension(250, 250));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0,0));
        this.add(panel);

        for (int i = 0; i < 9; i++) {
            panel.add(new JButton(String.valueOf(i+1)));
        }
    }

    public static void main(String[] args) {
        new Flowing().setVisible(true);
    }
}
