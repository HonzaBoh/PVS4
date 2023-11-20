package gui.dataShowcase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class TableTest extends JFrame {
    public TableTest(){
        super("Table example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] column = {"Sloupec1","Sloupec2","Sloupec3","Sloupec4"};
        DefaultTableModel model = new DefaultTableModel(column,0);
        JTable table = new JTable(model);
        table.setEnabled(false);//Do tabulky nebude mozne nic psat
        JScrollPane sp = new JScrollPane(table);//diky tomuto do tabulky lze dat tunu dat a scrollovat
        model.addRow(new String[]{"A", "B", "C", "D"});


        this.add(sp);
        this.setSize(300,400);
    }

    public static void main(String[] args) {
        TableTest tt = new TableTest();
        tt.setVisible(true);
    }
}
