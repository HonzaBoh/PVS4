package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListening extends JFrame implements MouseListener {
    JPanel panel;
    MouseListening(){
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.yellow);

        this.setLayout(null);
        panel.setBounds(100,100, 75,100);
        this.add(panel);
        panel.addMouseListener(this);
    }

    public static void main(String[] args) {
        new MouseListening().setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        panel.setBackground(Color.blue);
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        panel.setBackground(Color.blue);
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
//        panel.setBackground(Color.green);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(Color.yellow);
    }
}
