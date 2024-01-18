package gui.visuals;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class BubbleSortVisualization extends JFrame implements ActionListener {
    int[] array;
    JButton sortButton;
    JLabel[] labels;

    BubbleSortVisualization(int[] array) {
        this.array = array;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, array.length));
        labels = new JLabel[array.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel();
            this.add(labels[i]);
        }
        formatLabels();
        visualizeArray();
        sortButton = new JButton("Sort Array");
        sortButton.addActionListener(this);
        this.add(sortButton);
        this.pack();
    }

    void visualizeArray() {
        for (int i = 0; i < array.length; i++) {
            labels[i].setText(String.valueOf(array[i]));
            labels[i].paintImmediately(0, 0, getWidth(), getHeight());
        }
    }

    void highlight(Color color, int index) {
        labels[index].setBackground(color);
        labels[index].paintImmediately(0, 0, getWidth(), getHeight());

    }

    void sortSelf() {
        int i, j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length - i - 1; j++) {
                if (greaterThan(j, j+1)) {
                    swap(j, j + 1);
                }
                reset(j, j+1);
            }
        }
    }

    void selectSortSelf(){
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (greaterThan(j, min)){
                    min = j;

                }
                reset(j, min);
            }
            swap(i, min);
            reset(i, min);
        }
        System.out.println(Arrays.toString(array));
    }

    boolean greaterThan(int i, int j){
        highlight(Color.blue, i);
        highlight(Color.green, j);
        pause();
        return array[i] > array[j];
    }

    void reset(int i, int j){
        highlight(Color.white, i);
        highlight(Color.white, j);
        pause();
    }

    void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        visualizeArray();
        highlight(Color.blue, j);
        highlight(Color.green, i);
        pause();
    }

    void formatLabels() {
        Border border = BorderFactory.createLineBorder(Color.black, 2);
        for (JLabel label : labels) {
            label.setFont(new Font("MV Boli", Font.PLAIN, 42));
            label.setBorder(border);
            label.setOpaque(true);// bude se hodit :)
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.CENTER);
        }
    }

    void pause() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.err.println("Thread died :( yikes");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sortButton) {
            sortButton.setText("Sorting...");
            sortButton.setEnabled(false);
            sortButton.paintImmediately(0, 0, getWidth(), getHeight());
//            sortSelf();
           selectSortSelf();
            sortButton.setText("Sorted!");
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 6, 4, 2, 9, 11, 5, 10, 42, 7};
        BubbleSortVisualization visualization = new BubbleSortVisualization(array);
        visualization.setVisible(true);
    }

}
