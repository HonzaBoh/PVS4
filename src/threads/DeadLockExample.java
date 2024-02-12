package threads;

import java.util.ArrayList;

public class DeadLockExample {
    static final ArrayList<String> secrets = new ArrayList<>();
    static final ArrayList<String> gossips = new ArrayList<>();


    static Runnable readerSecrets = new Runnable() {
        @Override
        public void run() {
            synchronized (secrets) {
                for (String secret : secrets) {
                    System.out.println(secret);
                }
            }

            synchronized (gossips){
                for (String gossip : gossips) {
                    System.out.println(gossip);
                }
            }
        }
    };
    static Runnable gossipReader = new Runnable() {
        @Override
        public void run() {

            synchronized (gossips){
                for (String gossip : gossips) {
                    System.out.println(gossip);
                }
            }

            synchronized (secrets) {
                for (String secret : secrets) {
                    System.out.println(secret);
                }
            }
        }
    };

    public static void main(String[] args) {
        Thread t1 = new Thread(gossipReader);
        Thread t2 = new Thread(readerSecrets);
        t1.start();
        t2.start();

        System.out.println("Happy ending :)");
    }
}
