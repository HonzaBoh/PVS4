package threads.fileReading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MultiReadingSimple extends Thread{
    String fileToRead;

    public MultiReadingSimple(String fileToRead) {
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
        MultiReadingSimple reading = new MultiReadingSimple("nic");
        long start = System.currentTimeMillis();
        reading.doStuff("seq0.txt");
        reading.doStuff("seq1.txt");
//        reading.doStuff("seq2.txt");
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Multithreaded:");
        start = System.currentTimeMillis();

        MultiReadingSimple read1 = new MultiReadingSimple("seq0.txt");
        MultiReadingSimple read2 = new MultiReadingSimple("seq1.txt");
        read1.start();
        read2.start();
        read1.join();
        read2.join();
        System.out.println(System.currentTimeMillis() - start);
    }
}
