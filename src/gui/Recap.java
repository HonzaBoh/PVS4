package gui;

    import javax.swing.*;
    import java.awt.*;

    public class Recap extends JFrame {

        Recap(){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setSize(480, 480);
        this.setLayout(new BorderLayout());
        JLabel text = new JLabel("text");
        this.add(text, BorderLayout.NORTH);
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBackground(new Color(96, 171, 99));
        text.setOpaque(true);
        text.setForeground(new Color(0xFF0000));
//        text.setBounds(200, 100, 150, 100);
        this.add(new JLabel("Dalsi text"), BorderLayout.CENTER);
        JPanel somePanel = new JPanel();

        somePanel.setOpaque(true);
        somePanel.setBackground(Color.blue);
        somePanel.setPreferredSize(new Dimension(150, 200));
        this.add(somePanel, BorderLayout.EAST);
        JButton button = new JButton("Press me!");
        button.setBackground(Color.cyan);
        button.setOpaque(true);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        this.add(button, BorderLayout.SOUTH);
        button.setFocusable(false);
//        button.setEnabled(false);
//        button.addActionListener();
    }

    public static void main(String[] args) {
        new Recap().setVisible(true);
    }
}
