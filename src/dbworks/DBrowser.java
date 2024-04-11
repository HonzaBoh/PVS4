package dbworks;

import javax.swing.*;
import java.awt.*;

public class DBrowser extends JFrame {
    JRadioButton readButton, editButton;
    JPanel radios;
    JLabel codeLabel, nameLabel, headLabel, popLabel, modeLabel;
    JTextField codeField, nameField, headField, popField;
    JButton previous, next;

    DBrowser(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 700);
        this.setTitle("DB browse");
        this.setLayout(new GridLayout(6,2));
        initializeComponents();//!!

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
    }

    void initializeComponents(){
        codeLabel = new InfoLabel("Code");
        codeField = new DataField("TBD");
        nameLabel = new InfoLabel("Name");
        nameField = new DataField("TBD");
        headLabel = new InfoLabel("Head");
        headField = new DataField("TBD");
        popLabel = new InfoLabel("Population");
        popField  = new DataField("TBD");
        modeLabel = new InfoLabel("Mode");
        radios = new JPanel();
        radios.setBackground(Color.BLUE);
        readButton = new JRadioButton("Read");
        editButton = new JRadioButton("Edit");
        radios.setLayout(new GridLayout(1,2));

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
        previous = new JButton("Previous");
    }

    public static void main(String[] args) {
        new DBrowser().setVisible(true);
    }
} class InfoLabel extends JLabel{
    public InfoLabel(String text){
        super(text);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setOpaque(true);
        this.setBackground(new Color(0xfcf8dc));
    }
} class DataField extends JTextField{
    public DataField(String text) {
        super(text);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setEnabled(false);
    }
}
