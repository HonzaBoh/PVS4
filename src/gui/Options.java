package gui;

import javax.swing.*;

public class Options {
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null, "Some useless info", "Title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Some useless info", "Title", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Some useless info", "Title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "Some useless info", "Title", JOptionPane.QUESTION_MESSAGE);

        int answer = JOptionPane.showConfirmDialog(null, "Uzavrena otazka", "originalni titulek", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println("Odpoved: " + answer);
        if (answer == JOptionPane.YES_OPTION){
            System.out.println("Agreed");
        }

//        String input  = JOptionPane.showInputDialog("Otevrena otazka");
    }
}
