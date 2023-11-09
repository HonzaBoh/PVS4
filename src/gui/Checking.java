package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checking extends JFrame {

    Checking() {
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JTextField textField = new JTextField("Text to be printed out!");
        JCheckBox checkBox = new JCheckBox();
        JButton button = new JButton("Submit");
        textField.setFont(new Font("Consolas", Font.PLAIN, 32));
        checkBox.setText("Print out in red");
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 32));
        checkBox.setFocusable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()){
                    System.out.println(RED + textField.getText() +RESET);
                } else {
                    System.out.println(GREEN + textField.getText() +RESET);
                }
            }
        });

        this.add(textField);
        this.add(button);
        this.add(checkBox);
        this.pack();
    }

    public static void main(String[] args) {
        new Checking().setVisible(true);
    }
}
