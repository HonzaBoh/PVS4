package gui.hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JSlider difficultySlider;
    JLabel difficultyLabel;
    JPanel sliderPanel;

    MainWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(480,480);
        JButton startButton = new JButton("Start");
        this.setLayout(new GridLayout(1,2));
        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(2,1));

        difficultySlider = new JSlider(1,5,3);

        this.add(sliderPanel);
        this.add(startButton);

        difficultyLabel = new JLabel("TMP");
        sliderPanel.add(difficultySlider);
        sliderPanel.add(difficultyLabel);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWindow(42).setVisible(true);
            }
        });

        this.add(startButton);
    }

    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }
}
