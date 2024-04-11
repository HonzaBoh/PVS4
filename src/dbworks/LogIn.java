package dbworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LogIn extends JFrame{
    private static final String JDBC_URL = "jdbc:mysql://10.1.12.17:3306/world";
    JTextField userField, passField;
    JLabel userLabel, passLabel;
    public LogIn(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize( 350 , 200);
        userLabel = new JLabel("Username:");
        passLabel = new JLabel("Password:");
        userField = new JTextField("*username*");
        passField = new JTextField("*password*");
        JPanel credentials = new JPanel();
        credentials.setLayout(new GridLayout(2,2));

        credentials.add(userLabel);
        credentials.add(userField);
        credentials.add(passLabel);
        credentials.add(passField);

        this.setLayout(new BorderLayout());
        this.add(credentials, BorderLayout.CENTER);
        JButton logIn = new JButton("Login");
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection =
                            DriverManager.getConnection(JDBC_URL, userField.getText(), passField.getText());
                    new DBrowser().setVisible(true);
                } catch (SQLException ex) {
                    System.out.println("SQL: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Wrong password...");
                }
            }
        });
        this.add(logIn, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new LogIn().setVisible(true);
    }
}
