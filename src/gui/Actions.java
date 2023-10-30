package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions extends JFrame implements  ActionListener{
    JButton button, anotherButton, showButton;
    JLabel label;

    Actions(){
        this.setTitle("Akce");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        button = new JButton();
        anotherButton = new JButton("Another");
        anotherButton.setEnabled(false);

        button.addActionListener(this);
        anotherButton.addActionListener(this);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                if (e.getSource() == button){
////                    System.out.println("Button pressed");
////                }
////            }
//        });
        this.setLayout(null);
        button.setText("Press me");
        button.setBounds(200,100,100,50);
        anotherButton.setBounds(350, 100, 100, 50);
        button.setFocusable(false);
        button.setBackground(Color.CYAN);
        button.setBorder(BorderFactory.createEtchedBorder());
        showButton = new JButton("Show");
        label = new JLabel("Shown text");
        showButton.setBounds(200, 200, 100, 50);
        label.setBounds(350, 200,100,50);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setForeground(Color.black);
        showButton.addActionListener(this);
        this.add(label);
        this.add(showButton);
        this.add(button);
        this.add(anotherButton);
    }


    public static void main(String[] args) {
        new Actions().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println("Button pressed");
            button.setEnabled(false);
            anotherButton.setEnabled(true);
        }
        if (e.getSource() == anotherButton){
            System.out.println("Another button pressed");
            button.setEnabled(true);
            anotherButton.setEnabled(false);
        }
        if (e.getSource() == showButton){
            if (label.getForeground().equals(Color.black)){
                showButton.setText("Hide");
                label.setForeground(Color.white);
            } else{
                label.setForeground(Color.black);
                showButton.setText("Show");
            }
        }
    }
}
