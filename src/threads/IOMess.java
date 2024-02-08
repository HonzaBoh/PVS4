package threads;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

public class IOMess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scanInput = "";
        Runnable miniThread = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(LocalDateTime.now());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread clock = new Thread(miniThread);

        clock.setDaemon(true);//skonci, pokud skonci main
        clock.start();
        StringBuilder stringBuilder = new StringBuilder();
        while (!scanInput.equals("konec")){
            scanInput = sc.nextLine();
            stringBuilder.append(scanInput);
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
//        clock.interrupt();
        System.out.println("Happy ending?");
    }
}
