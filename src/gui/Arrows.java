package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Arrows extends JFrame implements KeyListener {
    JLabel label;
    final static int VELOCITY = 10;
    Arrows(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.addKeyListener(this);
        label = new JLabel();
        label.setBounds(0,0,100,100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        this.add(label);
    }

    public static void main(String[] args) {
        new Arrows().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JLabel footprint = new JLabel();
        footprint.setBounds(label.getX(), label.getY(), 100,100);
        footprint.setBackground(Color.red);
        footprint.setOpaque(true);


        switch (e.getKeyChar()){
            case 'a': label.setLocation(label.getX()-VELOCITY, label.getY());
                break;
            case 'w': label.setLocation(label.getX(), label.getY()-VELOCITY);
                break;
            case 's': label.setLocation(label.getX(), label.getY()+VELOCITY);
                break;
            case 'd': label.setLocation(label.getX()+VELOCITY, label.getY());
                break;
        }
        this.add(footprint);
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("Zmackunto: " + e.getKeyChar());
//        System.out.println("Zmackunto: " + e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("Zmackunto: " + e.getKeyChar());
//        System.out.println("Zmackunto: " + e.getKeyCode());
    }
}
