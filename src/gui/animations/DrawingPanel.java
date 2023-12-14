package gui.animations;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawingPanel extends JPanel {
    private long startTime = System.currentTimeMillis();

    DrawingPanel(){
        this.setPreferredSize(new Dimension(600,480));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        final int GRASS_SIZE = 30;
        g2.setColor(Color.GREEN);
        g2.fillRect(0, this.getHeight() - GRASS_SIZE, this.getWidth(), GRASS_SIZE);
        g2.translate(0, getHeight() - GRASS_SIZE);
        drawTractor(g2);
    }

    private void drawTractor(Graphics2D g2){
        //kola
        final double R1 = 150;
        final double R2 = 100;
        final double D = 350;

        //kabina
        final double L = 20;
        final double W = 300;
        final double H = 400;

        //motor
        final double MW = 300;
        final double MH = 200;

        //zacatek
        double U = R2 / 2;


        long currTime = System.currentTimeMillis();
        long elapsed = currTime - startTime;

        g2.translate(elapsed/10.0,0);

        g2.setColor(Color.RED);
        g2.fill(new Rectangle2D.Double(L, -U - H, W, H));
        g2.fill(new Rectangle2D.Double(L+W, -U - MH, MW, MH));

        drawWheels(R1, R2, D, g2);
    }

    private void drawWheels(double R1, double R2, double D, Graphics2D g2){
        g2.translate(R1, -R1);
        drawWheel(R1, g2);
        g2.translate(D, R1-R2);
        drawWheel(R2, g2);
    }

    private void drawWheel(double r, Graphics2D g2){
        double rDisk = 0.8 * r; // polomer disku
        final double rLev = 20; //polomer oje
        final double rWh = 5;
        final double dil = 45;

        g2.setColor(Color.BLACK);
        g2.fill(new Ellipse2D.Double(-r, -r, 2*r, 2*r));

        g2.setColor(Color.GRAY);
        g2.fill(new Ellipse2D.Double(-rDisk, -rDisk, 2*rDisk, 2*rDisk));

        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(-rLev, -rLev, 2*rLev, 2*rLev));

        AffineTransform oldTr = g2.getTransform();
        long currTime = System.currentTimeMillis();
        long elapsed = currTime - startTime;

        //otacky ze sekundu
        final double RotateSec = Math.PI;

        g2.rotate(Math.toRadians(45) + RotateSec*elapsed / 1000.0);
        for (int i = 0; i < 4; i++) {
            g2.translate(dil, 0);
            g2.fill(new Ellipse2D.Double(-rWh, -rWh, 2*rWh, 2*rWh));
            g2.translate(-dil, 0);
            g2.rotate(Math.toRadians(90));
        }
        g2.setTransform(oldTr);
    }

}
