package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileGUI extends JFrame {

    FileGUI(){
        this.setSize(500,400 );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,1));
        MyLabel fileName = new MyLabel("TMP");
        MyLabel fileInfo = new MyLabel("TMP");
        MyLabel fileType = new MyLabel("TMP");
        JButton button = new JButton("Hit me");
        button.setFont(new Font("Consolas", Font.BOLD, 22));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               int answer = JOptionPane.showConfirmDialog(null, "Confirm below!",
//                        "Title - how original", JOptionPane.YES_NO_CANCEL_OPTION);
//                if (answer == JOptionPane.YES_OPTION){
//                    fileInfo.setText("Chose Yes");
//                } else if(answer == JOptionPane.NO_OPTION){
//                    fileInfo.setText("Chose no");
//                } else{
//                    fileInfo.setText("Nothing :(");
//                }

//                String result = JOptionPane.showInputDialog("Something original?");
//                fileInfo.setText(result);

                JFileChooser fileChooser = new JFileChooser();
                int response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION){
                    File f = fileChooser.getSelectedFile();
                    fileName.setText(f.getName());
                    fileInfo.setText((f.length()/1024) + " kb");
                    String type = f.getName().substring(f.getName().lastIndexOf("."));
                    fileType.setText(type);
                }
            }
        });
        this.add(button);
        this.add(fileName);
        this.add(fileType);
        this.add(fileInfo);
    }

    public static void main(String[] args) {
        new FileGUI().setVisible(true);
    }
}
class MyLabel extends JLabel {
    MyLabel(String text){
        this.setText(text);
        this.setBackground(Color.cyan);
        this.setForeground(Color.magenta);
        this.setOpaque(true);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
    }
}
