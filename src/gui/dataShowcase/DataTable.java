package gui.dataShowcase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataTable extends JFrame {
    ArrayList<Record> data;
    DefaultTableModel model;

    public DataTable(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data = new ArrayList<>();
        this.setLayout(new BorderLayout());
        SortMenu menu = new SortMenu();
        this.add(menu, BorderLayout.NORTH);

        String[] column = {"Name", "Release year", "Rating", "Duration"};
        model = new DefaultTableModel(column, 0);
        JTable table = new JTable(model);
        table.setEnabled(false);
        JScrollPane sp = new JScrollPane(table);

        this.add(sp, BorderLayout.CENTER);
        this.setSize(500, 600);
        this.setResizable(false);
    }

    void clearTable() {
        model.setRowCount(0);
    }

    /**
     * nacte data ze souboru do listu
     */
    void loadData(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String[] attributes;
            for (String line : lines){
                attributes = line.split(";");
                data.add(new Record(attributes[0], Integer.parseInt(attributes[1]), Integer.parseInt(attributes[3]), Double.parseDouble(attributes[2])));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("loaded " + data.size() + " records");
    }

    /**
     * Do tabulky vlozi to, co je prave v listu ve stejnem poradi
     */
    void showData() {
        clearTable();
        for(Record r : data){
            model.addRow(r.returnAsTableRow());
        }
    }

    public static void main(String[] args) {
        DataTable table = new DataTable("Vizualizace dat");
        table.loadData("Movies.txt");
        table.showData();
        table.setVisible(true);
    }
}
