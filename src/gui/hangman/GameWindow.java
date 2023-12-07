package gui.hangman;

import gui.ProgressBar;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    JProgressBar progressBar;
    JButton submitButton;
    JTextField inputField;
    SecretLabel label;

    GameWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        init();
    }

    void init(){
        this.setLayout(new BorderLayout());
        progressBar = new JProgressBar(0,10);
        progressBar.setValue(10);
        progressBar.setForeground(Color.red);
        progressBar.setBackground(Color.black);
        progressBar.setPreferredSize(new Dimension(500,100));
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("MV Boli", Font.BOLD, 36));

        label = new SecretLabel();
        this.add(label, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.blue);
        inputPanel.setPreferredSize(new Dimension(500, 150));
        this.add(inputPanel, BorderLayout.SOUTH);

        //input text:
        inputField = new JTextField("TMP");
        inputField.setFont(new Font("MV Boli", Font.PLAIN, 32 ));

        //button setting
        submitButton = new JButton("Guess");
        submitButton.setFont(new Font("MV Boli", Font.PLAIN, 32 ));

        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        this.add(progressBar, BorderLayout.NORTH);
//        this.pack();
    }

    public static void main(String[] args) {
        new GameWindow().setVisible(true);
    }
}
