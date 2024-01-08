package gui.browser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends JFrame implements ActionListener{

    /**
     * Staticka promenna, budeme s ni pracovat i v jinych tridach
     */
    static List<Person> personData = new ArrayList<>();

    JButton tableView, dataView, dataLoad;
    JLabel status;

    MainMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        tableView = new JButton("Table");
        dataView = new JButton("Data");

        dataView.setEnabled(false); // nejsou zadna data k zobrazeni
        tableView.setEnabled(false);

        status = new JLabel("There are no data loaded!");
        status.setFont(new Font("MV Boli", Font.BOLD, 21));

        dataLoad = new JButton("Load persons");
        dataLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    List<String> lines = Files.readAllLines(Paths.get("persons_x4.txt"));

                    String[] attributes;
                    for (String line : lines){
                        attributes = line.split(";");
                        personData.add(new Person(attributes[0], attributes[1], Integer.parseInt(attributes[2]),
                                Integer.parseInt(attributes[3]), attributes[4]));
                    }

                }catch (IOException ioe){
                    System.err.println(":(");
                }

                status.setText(personData.size() + " records loaded! You can now view the dataset!");
                tableView.setEnabled(true);
                dataView.setEnabled(true);
                dataLoad.setEnabled(false);
                pack();
            }
        });

        tableView.addActionListener(this);
        dataView.addActionListener(this);

        this.add(dataLoad);
        this.add(status);
        this.add(tableView);
        this.add(dataView);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tableView)
            new TableMenu().setVisible(true);
        if(e.getSource() == dataView)
            new CardMenu().setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        MainMenu loader = new MainMenu();
//        MainMenu.personData.add(new Person("Larry","Hydinger",46,225228,"icon.png"));
        loader.setVisible(true);
    }
}
