package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorTickerTimer extends JFrame {
    JTextField[] colors;
    JLabel colorDisplay;

    ColorTickerTimer(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ColorTicker");
        this.setLocationRelativeTo(null);

        this.setLayout(new FlowLayout());
        colors = new JTextField[3];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new JTextField("0");
            colors[i].setPreferredSize(new Dimension(100,70));
            colors[i].setFont(new Font("Consolas", Font.PLAIN, 28));
            colors[i].setHorizontalAlignment(SwingConstants.CENTER);
            this.add(colors[i]);
        }

        colorDisplay = new JLabel(" ");
        colorDisplay.setOpaque(true);
        colorDisplay.setBackground(Color.black);
        colorDisplay.setPreferredSize(new Dimension(200, 140));
        colorDisplay.setBorder(BorderFactory.createLineBorder(Color.black,3));
        this.add(colorDisplay);
        JButton tester = new JButton("PLACEHOLDER");
        this.add(tester);
        tester.addActionListener(new ActionListener() {// <--- je pro tlacitko
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener coloring = new ActionListener() { //<---- je pro vybarvovani
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setColor();
                    }
                };
                Timer timer = new Timer(10, coloring);
                timer.start();
            }
        });
        this.pack();
    }



    void setColor(){
        colorDisplay.setBackground(new Color(
                Integer.parseInt(colors[0].getText()),
                Integer.parseInt(colors[1].getText()),
                Integer.parseInt(colors[2].getText())));
    }

    public static void main(String[] args) {
        new ColorTickerTimer().setVisible(true);
    }

}
