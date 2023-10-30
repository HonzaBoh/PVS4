package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Labeling extends JFrame {
    public Labeling() {
//        this.setSize(640, 480);
        this.setTitle("Labels");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel();
        label.setText("Graphical design is my passion");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(128, 0, 255));
        label.setOpaque(true);
        label.setBackground(new Color(0x00FF00));
        ImageIcon img = new ImageIcon("img.jpg");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIcon(img);
        Border border = BorderFactory.createLineBorder(Color.red, 3);
        label.setBorder(border);
//        label.setBounds(100,200,700,500);
//        this.setLayout(null);
        this.add(label);
        this.pack();
    }

    public static void main(String[] args) {
        new Labeling().setVisible(true);
    }
}
