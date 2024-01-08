package gui.hangman;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JSlider difficultySlider;
    JLabel difficultyLabel;

    MainWindow(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(480,480);
        JButton startButton = new JButton("Start");
        JButton addButton = new JButton("Add secret");
        this.setLayout(new GridLayout(2,2));


        difficultySlider = new JSlider(1,5,3);


        difficultyLabel = new JLabel("TMP");


        difficultyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        difficultyLabel.setVerticalAlignment(SwingConstants.CENTER);

        difficultyLabel.setFont(new Font("Consolas", Font.BOLD, 24));

        difficultySlider.setPaintTicks(true);
        difficultySlider.setMinorTickSpacing(1);
        difficultySlider.setPaintTrack(true);
        difficultySlider.setMajorTickSpacing(2);
        difficultySlider.setPaintLabels(true);

        difficultySlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
//                System.out.println("moved");
                difficultyLabel.setText("Difficulty: " + difficultySlider.getValue());
            }
        });

        difficultyLabel.setText("Difficulty: " + difficultySlider.getValue());

//        startButton.setBackground(Color.BLUE);
//        startButton.setOpaque(true);
    startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameWindow(difficultySlider.getValue()).setVisible(true);
                System.out.println("Difficulty set to: " + difficultySlider.getValue());
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 08.01.2024 secret insert
            }
        });
    
        this.add(difficultySlider);
        this.add(startButton);
        this.add(difficultyLabel);
        this.add(addButton);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
//        System.out.println(UIManager.getSystemLookAndFeelClassName());
        new MainWindow().setVisible(true);
    }
}
