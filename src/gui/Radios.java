package gui;

import javax.swing.*;
import java.awt.*;

public class Radios extends JFrame {
    Radios(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JRadioButton mc = new JRadioButton("McDonald's");
        JRadioButton kfc = new JRadioButton("KFC");
        JRadioButton bk = new JRadioButton("Burger king");

        ButtonGroup group = new ButtonGroup();
        group.add(mc);
        group.add(kfc);
        group.add(bk);


        this.add(mc);
        this.add(kfc);
        this.add(bk);

        this.pack();
    }

    public static void main(String[] args) {
        new Radios().setVisible(true);
    }
}
