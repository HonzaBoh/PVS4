package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Texting extends JFrame {

    Texting(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        JTextField textField = new JTextField("TMP");
        JButton button = new JButton("Press");
        this.setSize(300,300);
//        textField.setPreferredSize(new Dimension(200,50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
            }
        });
        textField.setBackground(Color.pink);
        textField.setOpaque(true);
        textField.setForeground(Color.pink);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Consolas", Font.BOLD, 16));
        JButton hide = new JButton("Hide/reveal");
        textField.setEditable(false);
        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setBackground(Color.blue);
            }
        });


        this.add(textField);
        this.add(button);
        this.add(hide);
//        this.pack();
    }
    public static void main(String[] args) {
        new Texting().setVisible(true);
    }
}
