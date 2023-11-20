package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableTest extends JFrame {

    TableTest() {
        this.setSize(300, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        String[] columns = {"Sloupec1", "Sloupec2", "Sloupec3", "Sloupec4"};

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);

        for (int i = 0; i < 30; i++) {
            model.addRow(new String[]{"A", "B", "C", "D"});
        }

        //smazani radku
        //model.setRowCount(0);

        table.setEnabled(false);
        table.setFont(new Font("MV Boli", Font.BOLD, 20));
        table.setBackground(Color.orange);
        table.setOpaque(true);
        table.setForeground(new Color(0x62EF5D));


        this.add(sp);
    }

    public static void main(String[] args) {
        new TableTest().setVisible(true);
    }

}