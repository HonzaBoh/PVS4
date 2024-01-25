package threads;

public class Concurrency extends Thread{
    public static int amount = 0;

    public static void main(String[] args) {
        Concurrency c = new Concurrency();
        c.start();
        //cekam...
        while (c.isAlive()){
            System.out.println("Waiting...");
        }

        System.out.println(amount);
        amount++;
        System.out.println(amount);
    }

    @Override
    public void run() {
        amount++;
    }
}
