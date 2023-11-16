package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GridTask extends JFrame {

    GridTask(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 640);

        this.setLayout(null);

        JPanel content = new JPanel();
//        content.setBackground(Color.red);//vizual
        content.setBounds(50, 50, 500, 500);

        content.setLayout(new BorderLayout());
        JLabel gridBelow = new JLabel("Grid below");
        gridBelow.setFont(new Font("Consolas", Font.BOLD, 24));
        gridBelow.setBackground(Color.red);
        gridBelow.setOpaque(true);
        gridBelow.setHorizontalAlignment(SwingConstants.CENTER);
        content.add(gridBelow, BorderLayout.NORTH);

        JPanel numberPanel = new JPanel();
        numberPanel.setBackground(Color.green);//vizual
        content.add(numberPanel, BorderLayout.CENTER);

//        numberPanel.add(new OwnLabel("TXT"));

        numberPanel.setLayout(new GridLayout(3,3,1,1));
        for (int i = 0; i < 9; i++) {
            numberPanel.add(new OwnLabel(String.valueOf(i+1)));
        }

        this.add(content);
    }
    public static void main(String[] args) {
        new GridTask().setVisible(true);
    }
}
class OwnLabel extends JLabel{
    OwnLabel(String text){
        this.setText(text);
        this.setBackground(Color.blue);
        this.setOpaque(true);
        this.setVerticalAlignment(CENTER);
        this.setHorizontalAlignment(CENTER);
        this.setForeground(Color.magenta);
        this.setFont(new Font("Consolas", Font.BOLD, 18));
        Border border = BorderFactory.createLineBorder(Color.black, 3);
        this.setBorder(border);
    }
}