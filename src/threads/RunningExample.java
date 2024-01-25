package threads;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunningExample extends Thread{

    static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");

    public static void main(String[] args) {
        RunningExample re = new RunningExample();
        re.setDaemon(true);
        re.start();
        String input  = JOptionPane.showInputDialog("Neco zadej...");
        System.out.println("Zadls': " + input);
//        System.exit(1);
    }

    @Override
    public void run() {
        for(;;){ //== while(true)
            try {
                Thread.sleep(3000);
                System.out.println(timeFormat.format(Calendar.getInstance().getTime()));
            } catch (InterruptedException sad) {
                System.out.println("Thread died :(");
            }
        }
    }
}
