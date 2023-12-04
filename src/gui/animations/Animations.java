package gui.animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animations extends JFrame {
    Animations(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Canvas());
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Animations().setVisible(true);
    }
}
class Canvas extends JPanel implements ActionListener {
    final int WIDTH = 500;
    final int HEIGHT = 500;
    Image bouncingImage;
    Image backgroundImage;
    Timer timer;
    int x = 0;
    int y = 0;
    int xVelocity = 2;
    int yVelocity = 1;
    Canvas(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        bouncingImage = new ImageIcon("smallShip.png").getImage();
        backgroundImage = new ImageIcon("space.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);//nakresli pozadi

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(backgroundImage, 0, 0, null);
        g2d.drawImage(bouncingImage, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( x >= this.getWidth() - bouncingImage.getWidth(null) || x < 0){
            xVelocity *= -1;
        }
        x = x + xVelocity;

        if ( y >= this.getHeight() - bouncingImage.getHeight(null) || y < 0){
            yVelocity *= -1;
        }
        y += yVelocity;
        repaint();
    }
}
