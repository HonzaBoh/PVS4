package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checking extends JFrame {

    Checking() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        JTextField textField = new JTextField("Text to be printed out");
        JCheckBox checkBox = new JCheckBox();

        JButton button = new JButton();
        button.setText("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    System.err.println(textField.getText());
                } else {
                    System.out.println(textField.getText());
                }
            }
        });

        checkBox.setText("Print out in red color");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Consolas", Font.PLAIN, 35));

        textField.setFont(new Font("Consolas", Font.PLAIN, 35));
        this.add(textField);
        this.add(button);
        this.add(checkBox);
        this.pack();
    }

    public static void main(String[] args) {
        new Checking().setVisible(true);
    }
}
