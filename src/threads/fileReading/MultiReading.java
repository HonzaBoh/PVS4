package threads.fileReading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MultiReading extends Thread{
    String fileToRead;

    public MultiReading(String fileToRead) {
        this.fileToRead = fileToRead;
    }

    @Override
    public void run() {
        doStuff(fileToRead);
    }

    void doStuff(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int[] array = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                array[i] = Integer.parseInt(lines.get(i));
            }
            Arrays.sort(array);
            System.out.println("Sorted array: " + this.getName());
        } catch (IOException e) {
            System.out.println(":(");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiReading singleRead = new MultiReading("nic");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            singleRead.doStuff("seq"+i+".txt");
        }
        System.out.println("Single thread: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        MultiReading[] workers = new MultiReading[10];
        for (int i = 0; i < 10; i++) {
            workers[i] = new MultiReading("seq"+i+".txt");
            workers[i].start();
        }

        for (int i = 0; i < workers.length; i++) {
            workers[i].join();
        }
        System.out.println("Multi thread: " + (System.currentTimeMillis() - start));

    }
}
