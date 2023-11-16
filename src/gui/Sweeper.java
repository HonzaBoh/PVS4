package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Sweeper extends JFrame {
    final int DIM = 10;


    Sweeper(){
        this.setSize(720, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel infoPanel = new JPanel();
        JPanel sweepArea = new JPanel();
        infoPanel.setBackground(Color.magenta);
        sweepArea.setBackground(Color.red);

        //----INFO PANEL
        JLabel scoreLabel = new JLabel("Score: TBD");
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Consolas", Font.PLAIN, 18));

        JButton revealButton = new JButton("REVEAL");
        revealButton.setHorizontalAlignment(SwingConstants.CENTER);
        revealButton.setFont(new Font("Consolas", Font.PLAIN, 18));

        infoPanel.setLayout(new GridLayout(1,2));
        infoPanel.add(scoreLabel);
        infoPanel.add(revealButton);

        //---SWEEP AREA
        sweepArea.setLayout(new GridLayout(DIM, DIM, 1,1));

        for (int i = 0; i < DIM*DIM; i++) {
            PossibleBomb button = new PossibleBomb("?");
            sweepArea.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setEnabled(false);
                }
            });
        }

        this.setLayout(new BorderLayout());
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(sweepArea, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Sweeper().setVisible(true);
    }
}
class PossibleBomb extends JButton{

    int scoreValue;

    PossibleBomb(String text){
        this.setText(text);
        this.setOpaque(true);
        this.setBackground(new Color(0xFDC669));
        this.setHorizontalAlignment(CENTER);
        this.setFont(new Font("Consolas", Font.BOLD, 22));
        this.setFocusable(false);

//        Random random = new Random();
//        scoreValue = (int)(Math.random()*200);
    }

}
