package gui.animations;

import javax.swing.*;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class BasicDrawing extends JFrame {

    BasicDrawing(){
        this.setTitle("Animace");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        DrawingPanel dp = new DrawingPanel();
        this.add(dp);
        this.pack();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                dp.repaint();
            }
        }, 0, 24);

    }

    public static void main(String[] args) {
        new BasicDrawing().setVisible(true);
    }
}
