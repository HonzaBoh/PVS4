package exceptions;

import gui.Task;

import javax.swing.*;

public class Test {

    static String pass = "";
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                pass = JOptionPane.showInputDialog("Zadej...");
            }
        };
        Thread run = new Thread(r);
        run.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            if (pass.equals("secret")){
                break;
            }
            System.out.println(10-i);
        }
        if (pass.equals("secret")){
            System.out.println("Heslo OK");
        } else {
            System.out.println("Heslo neni OK");
        }
        System.exit(0);
    }
}
