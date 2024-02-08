package threads.fileReading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MultiReadingFinal extends Thread{
    static Queue<String> filePaths = new LinkedList<>();
    static LinkedList<MultiReadingFinal> workers = new LinkedList<>();
//    Queue<MultiReadingFinal> synced = Collections.synchronizedCollection(workers);

    final static int THREAD_COUNT = 8;

//    static ArrayList<String> filePaths = new ArrayList<>();

    @Override
    public void run() {
        doStuff();
    }

    void doStuff(){
        try {
            String fileName = filePaths.poll();
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            int[] array = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                array[i] = Integer.parseInt(lines.get(i));
            }
            Arrays.sort(array);
            System.out.println("Sorted array: " + this.getName() + " from " + fileName);
//            workers.add(this);// jsem ready na dalsi ukol
        } catch (IOException e) {
            System.out.println(":(");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            filePaths.add("seq"+i+".txt");
        }

//        MultiReadingFinal[] mfs = new MultiReadingFinal[50];
//        //priprava vlaken
//        for (int i = 0; i < mfs.length; i++) {
//            mfs[i] = new MultiReadingFinal();
//        }
//
//
//        long start = System.currentTimeMillis();
//        //jednotliva spousteni
//        for (int i = 0; i < mfs.length; i++) {
//            mfs[i].start();
//        }
//
//        for (int i = 0; i < mfs.length; i++) {
//            mfs[i].join();
//        }
//        long stop = System.currentTimeMillis();
//        System.out.println("Sorting took " + (stop-start));

        //singleThread
//        long start = System.currentTimeMillis();
//        MultiReadingFinal singleOne = new MultiReadingFinal();
//        while (!filePaths.isEmpty()){
//            singleOne.doStuff();
//        }
//        long stop = System.currentTimeMillis();
//        System.out.println("Sorting took " + (stop-start));


        for (int i = 0; i < THREAD_COUNT; i++) {
            workers.add(new MultiReadingFinal());
        }

        while (!filePaths.isEmpty()){
            for (MultiReadingFinal mf : workers){
                if (!mf.isAlive()){
                    mf.start();
                }
            }
        }

    }
}
