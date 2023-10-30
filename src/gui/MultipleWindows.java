package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleWindows extends JFrame {

    MultipleWindows(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(null);
        JButton button = new JButton("Hit me");
        button.setBounds(80,80, 200, 200);
        button.setFont(new Font("Consolas", Font.BOLD, 24));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Task().setVisible(true);
            }
        });
        this.add(button);
    }

    public static void main(String[] args) {
        new MultipleWindows().setVisible(true);
    }
}
