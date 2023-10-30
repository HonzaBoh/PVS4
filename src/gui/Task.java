package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task extends JFrame {


    Task(){
        JLabel okLabel = new JLabel("OK?");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel loginPane = new JPanel();
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        loginPane.setLayout(new GridLayout(5,1));
        this.add(loginPane, BorderLayout.CENTER);
        JLabel loginLabel = new JLabel("Login");

        loginLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPane.add(loginLabel);

        JTextField loginField = new JTextField("username");
        loginField.setFont(new Font("Consolas", Font.PLAIN, 18));
        loginPane.add(loginField);

        JLabel psswdLabel = new JLabel("Password");
        psswdLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
        psswdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPane.add(psswdLabel);

        JTextField passwordField = new JTextField("");
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 18));
        passwordField.setBackground(Color.black);
        passwordField.setForeground(Color.black);
        passwordField.setOpaque(true);
        loginPane.add(passwordField);
        this.setResizable(false);
        JButton checkButton = new JButton("Check");
        JButton showButton = new JButton("Show");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(checkButton);
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getText().equals("heslo")){
                    okLabel.setBackground(Color.green);
                    okLabel.setText("OK!");
                } else {
                    okLabel.setBackground(Color.red);
                    okLabel.setText("OK...not");
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordField.setForeground(Color.white);
            }
        });
        buttonPanel.add(showButton);
        loginPane.add(buttonPanel);

        this.add(okLabel, BorderLayout.SOUTH);
        okLabel.setHorizontalAlignment(SwingConstants.CENTER);
        okLabel.setVerticalAlignment(SwingConstants.CENTER);
        okLabel.setOpaque(true);
        okLabel.setFont(new Font("Consolas", Font.PLAIN, 36));

    }

    public static void main(String[] args) {
        new Task().setVisible(true);
    }
}
