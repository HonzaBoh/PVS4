package threads;

import java.util.Arrays;

public class Basics{

    public static void main(String[] args) {
        FirstThread thread = new FirstThread();
        thread.start();
//        thread.nic();
        IThread myThread = new IThread();
        Thread basicThread = new Thread(myThread);
        basicThread.start();
        System.out.println("Happy ending :)");
    }

} class FirstThread extends Thread{

    @Override
    public void run() {
        int[] somehting = new int[(int) (Math.random()*1000)];
        for (int i = 0; i < somehting.length; i++) {
            somehting[i] = (int)(Math.random() * 10000 ) ;
        }
        Arrays.sort(somehting);
        System.out.println("Array (dedicnost)");
        System.out.println("(dedicnost):" + Arrays.toString(somehting));
    }

} class IThread implements Runnable{


    @Override
    public void run() {
        int[] somehting = new int[(int) (Math.random()*1000)];
        for (int i = 0; i < somehting.length; i++) {
            somehting[i] = (int)(Math.random() * 10000 ) ;
        }
        Arrays.sort(somehting);
        System.out.println("Array (rozhrani)");
        System.out.println("(rozhrani):" + Arrays.toString(somehting));
    }
}
