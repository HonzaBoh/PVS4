package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mousing extends JFrame implements MouseListener {
    JLabel label;
    Mousing(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLayout(null);

        label = new JLabel();
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.setBounds(0,this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        this.add(label);
        label.addMouseListener(this);
    }

    public static void main(String[] args) {
        new Mousing().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setBackground(Color.blue);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        label.setBackground(Color.blue);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        label.setBackground(Color.green);
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        label.setBackground(Color.green);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setBackground(Color.red);
    }
}
