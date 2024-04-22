package dbworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DBrowser extends JFrame {
    JRadioButton readButton, editButton;
    JPanel radios;
    JLabel codeLabel, nameLabel, headLabel, popLabel, modeLabel;
    JTextField codeField, nameField, headField, popField;
    JButton previous, next, last, first, edit, delete;
    Connection connection;
    ResultSet results;
    Statement st;


    DBrowser(Connection connection) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 700);
        this.setTitle("DB browse");
        this.setLayout(new GridLayout(8, 2));
        initializeComponents();//!!

        if (connection == null) {

            String USERNAME = "pvs";
            String PASSWORD = "prg";
            String JDBC_URL = "jdbc:mysql://10.1.12.17:3306/world";
            try {
                this.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.connection = connection;
        }


        this.add(codeLabel);
        this.add(codeField);
        this.add(nameLabel);
        this.add(nameField);
        this.add(headLabel);
        this.add(headField);
        this.add(popLabel);
        this.add(popField);
        this.add(modeLabel);
        this.add(radios);
        this.add(previous);
        this.add(next);
        this.add(first);
        this.add(last);
        this.add(delete);
        this.add(edit);

        initializeValues();//klicove, zapne cteni z DB
    }

    void delete(){
        try {
            results.deleteRow();

            st.close();
            results.close();
            initializeValues();
            JOptionPane.showMessageDialog(this, "Record deleted");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void next() {
        try {
            if (results.next()) {
                codeField.setText(results.getString("Code"));
                nameField.setText(results.getString("Name"));
                headField.setText(results.getString("HeadOfState"));
                popField.setText(String.valueOf(results.getInt("Population")));
            } else {
                results.previous();
                JOptionPane.showMessageDialog(this, "End of list");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void previous() {
        try {
            if (results.previous()) {
                codeField.setText(results.getString("Code"));
                nameField.setText(results.getString("Name"));
                headField.setText(results.getString("HeadOfState"));
                popField.setText(String.valueOf(results.getInt("Population")));
            } else {
                results.next();
                JOptionPane.showMessageDialog(this, "Start of list");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void first() {
        try {
            results.first();
            codeField.setText(results.getString("Code"));
            nameField.setText(results.getString("Name"));
            headField.setText(results.getString("HeadOfState"));
            popField.setText(String.valueOf(results.getInt("Population")));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void last(){
        try {
            results.last();
            codeField.setText(results.getString("Code"));
            nameField.setText(results.getString("Name"));
            headField.setText(results.getString("HeadOfState"));
            popField.setText(String.valueOf(results.getInt("Population")));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }


    void initializeValues() {
        try {
            String query = "SELECT Code, Name, Population, HeadOfState FROM country";
            st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            results = st.executeQuery(query);

            results.next();//scrollni na prvni
            codeField.setText(results.getString("Code"));
            nameField.setText(results.getString("Name"));
            headField.setText(results.getString("HeadOfState"));
            popField.setText(String.valueOf(results.getInt("Population")));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    void initializeComponents() {
        codeLabel = new InfoLabel("Code");
        codeField = new DataField("TBD");
        nameLabel = new InfoLabel("Name");
        nameField = new DataField("TBD");
        headLabel = new InfoLabel("Head");
        headField = new DataField("TBD");
        popLabel = new InfoLabel("Population");
        popField = new DataField("TBD");
        modeLabel = new InfoLabel("Mode");
        radios = new JPanel();
        radios.setBackground(Color.BLUE);
        readButton = new JRadioButton("Read");
        editButton = new JRadioButton("Edit");
        radios.setLayout(new GridLayout(1, 2));

        ButtonGroup group = new ButtonGroup();
        group.add(editButton);
        group.add(readButton);
        radios.add(readButton);
        radios.add(editButton);
        editButton.setFocusable(false);
        readButton.setFocusable(false);

        editButton.setHorizontalAlignment(SwingConstants.CENTER);
        readButton.setHorizontalAlignment(SwingConstants.CENTER);

        next = new JButton("Next");
        next.addActionListener(e -> next());

        previous = new JButton("Previous");
        previous.addActionListener(e -> previous());

        last = new JButton("Last");
        last.addActionListener(e -> last());
        first = new JButton("First");
        first.addActionListener(e -> first());
        edit = new JButton("Update");
        delete = new JButton("Delete");
        delete.addActionListener(e -> delete());
    }

    public static void main(String[] args) {
        new DBrowser(null).setVisible(true);
    }
}

class InfoLabel extends JLabel {
    public InfoLabel(String text) {
        super(text);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setOpaque(true);
        this.setBackground(new Color(0xfcf8dc));
    }
}

class DataField extends JTextField {
    public DataField(String text) {
        super(text);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setEnabled(false);
    }
}
