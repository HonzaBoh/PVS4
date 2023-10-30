package gui;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    Grid(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(3,3, 4,5));

        for (int i = 0; i < 9; i++) {
            this.add(new JButton(String.valueOf(i+1)));
        }
        this.add(new JButton("10"));
        this.add(new JButton("11"));
//        this.add(new JButton("12"));
    }

    public static void main(String[] args) {
        new Grid().setVisible(true);
    }

}
