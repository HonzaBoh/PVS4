package threads;

public class Waiters {
    static int a = 0;
    static int b = 0;


    public static void main(String[] args) {
        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(3000);
                    a = 5;
                }catch (InterruptedException e){

                }
            }
        });


        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                    b = 10;
                }catch (InterruptedException e){

                }
            }
        });
        aThread.start();
        bThread.start();

        try {
            bThread.join();//important!
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println("happy ending");
    }
}
