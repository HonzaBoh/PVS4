package gui.hangman;

import gui.ProgressBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        inputField.setHorizontalAlignment(SwingConstants.CENTER);

        //button setting
        submitButton = new JButton("Guess");
        submitButton.setFont(new Font("MV Boli", Font.PLAIN, 32 ));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 07.12.2023 Osetrit vstupy 
                makeAGuess(inputField.getText());
            }
        });

        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(inputField);
        inputPanel.add(submitButton);

        this.add(progressBar, BorderLayout.NORTH);
        this.pack();
        this.setSize(this.getWidth(), 700);
    }

    void makeAGuess(String guess){
        if (label.secret.contains(guess)){
            System.out.println("Guess!");
            label.guessed.add(guess);//pridam do mnoziny uhadnutych pismen
            // TODO: 07.12.2023  odhalovani pismen
        } else {
            progressBar.setValue( progressBar.getValue() - 1);
            if (progressBar.getValue() < 1){
                label.setText("GAME OVER!");
            }
        }
        // TODO: 07.12.2023 Ukoncit hru
    }
    public static void main(String[] args) {
        new GameWindow().setVisible(true);
    }
}
