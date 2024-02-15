package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordInputGUI extends JFrame {
    JTextField input;
    JLabel countdown;
    int actualCountdown;

    PasswordInputGUI(){
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(350,300);
        input = new JTextField("password here..");
        input.setFont(new Font("Consolas", Font.BOLD, 32));
        actualCountdown = 20;

        countdown = new JLabel("");
        countdown.setVerticalAlignment(SwingConstants.CENTER);
        countdown.setHorizontalAlignment(SwingConstants.CENTER);
        countdown.setFont(new Font("Consolas", Font.BOLD, 42));

        this.add(countdown);
        this.add(input);
        Timer timer;
        timer = new Timer(1000,null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayRemaining();
                if (actualCountdown < 0){
                    timer.stop();
                }
            }
        });
        timer.start();
    }

    void displayRemaining(){
        countdown.setText(String.valueOf(actualCountdown));
        actualCountdown--;
    }

    public static void main(String[] args) {
        new PasswordInputGUI().setVisible(true);
    }
}
