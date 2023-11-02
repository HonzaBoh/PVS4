package gui;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    Grid(){
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1, 2,2));

        for (int i = 0; i < 3; i++) {
            JButton button = new JButton(String.valueOf(i+1));
            button.setPreferredSize(new Dimension(50,50));
            this.add(button);
        }
//        this.add(new JButton("10"));
    }

    public static void main(String[] args) {
        new Grid().setVisible(true);
    }

}
