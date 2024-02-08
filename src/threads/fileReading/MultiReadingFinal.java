package threads.fileReading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MultiReadingFinal extends Thread{
    Queue<String> something = new LinkedList<>();

    static ArrayList<String> filePaths = new ArrayList<>();

    static Integer counter = 0;

    @Override
    public void run() {

    }

    void doStuff(String fileName){
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int[] array = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                array[i] = Integer.parseInt(lines.get(i));
            }
            Arrays.sort(array);

            System.out.println("Sorted array: " + this.getName() + " from " + fileName);
        } catch (IOException e) {
            System.out.println(":(");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            filePaths.add("seq"+i+".txt");
        }

        MultiReadingFinal[] mfs = new MultiReadingFinal[50];
        //priprava vlaken
        for (int i = 0; i < mfs.length; i++) {
            mfs[i] = new MultiReadingFinal();
        }

        //jednotliva spousteni
        for (int i = 0; i < mfs.length; i++) {
            mfs[i].start();
        }


    }
}
