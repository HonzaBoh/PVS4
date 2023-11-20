package gui;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JFrame {
    JProgressBar bar;
    ProgressBar(){
        bar = new JProgressBar(0, 500);
        bar.setBounds(0,0, 420, 50);
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);

        this.add(bar);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 420);
        this.setLayout(null);

    }

    void fill(){
        int counter = bar.getMaximum();
        while (counter >= 0){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            counter--;
        }
        bar.setString("Finished!");
    }
    public static void main(String[] args) {
        ProgressBar PBar = new ProgressBar();
        PBar.setVisible(true);
        PBar.fill();
    }
}
