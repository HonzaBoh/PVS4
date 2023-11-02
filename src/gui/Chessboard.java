package gui;

import javax.swing.*;
import java.awt.*;

public class Chessboard extends JFrame {

    final static int CHESS_DIMENSION = 7;
    Chessboard(){
        this.setSize(700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(CHESS_DIMENSION,CHESS_DIMENSION));

        JLabel[][] labels = new JLabel[CHESS_DIMENSION][CHESS_DIMENSION];
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                labels[i][j] = new JLabel(" ");
                labels[i][j].setOpaque(true);
                labels[i][j].setVerticalTextPosition(SwingConstants.CENTER);
                labels[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
                this.add(labels[i][j]);
                if ((i+j) % 2 == 1 ){
                    labels[i][j].setBackground(Color.white);
                } else {
                    labels[i][j].setBackground(Color.black);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Chessboard().setVisible(true);
    }
}
