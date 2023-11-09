package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.transaction.xa.Xid;
import java.awt.*;

public class SliderDemo extends JFrame {

    JPanel panel;
    JLabel label;
    JSlider slider;
    SliderDemo() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(420, 420);
        label = new JLabel();
        panel = new JPanel();
        slider = new JSlider(0,100,50);

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
        label.setText(slider.getValue() + " vol");
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 15));
        slider.setOrientation(SwingConstants.VERTICAL);

        panel.add(slider);
        panel.add(label);
        this.add(panel);
    }

    public static void main(String[] args) {
        new SliderDemo().setVisible(true);
    }


}
