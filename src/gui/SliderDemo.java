package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class SliderDemo extends JFrame implements ChangeListener {

    JPanel panel;
    JLabel label;
    JSlider slider;
    SliderDemo(){
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0,100,50);

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);

        slider.setPaintLabels(true);

        slider.setOrientation(SwingConstants.VERTICAL);

        panel.add(slider);
        panel.add(label);
        this.add(panel);
        this.setSize(420, 420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SliderDemo().setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
