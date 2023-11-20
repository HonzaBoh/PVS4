package gui.dataShowcase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortMenu extends JPanel {
    /**
     * Nejdulezitejsi!
     * Tomuto tlacitku pridat posluchac, zadny defaultne nema
     */
    public JButton outputButton;

    JRadioButton name, release, rating, duration;

    public SortMenu() {
        this.setLayout(new FlowLayout());
        name = new JRadioButton("Name");
        release = new JRadioButton("Release");
        rating = new JRadioButton("Rating");
        duration = new JRadioButton("Duration");

        ButtonGroup sortButtons = new ButtonGroup();
        sortButtons.add(name);
        sortButtons.add(release);
        sortButtons.add(rating);
        sortButtons.add(duration);

        JLabel label = new JLabel("Sort by: ");

        outputButton = new JButton("Sort!");


        this.add(label);
        this.add(name);
        this.add(release);
        this.add(rating);
        this.add(duration);

        this.add(outputButton);
    }

}
