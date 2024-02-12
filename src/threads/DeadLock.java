package threads;

public class DeadLock {
    static Integer count = 10;

    static Runnable summation = new Runnable() {
        @Override
        public void run() {
            synchronized (count){
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count += 1;
                }
            }
        }
    };

    static Runnable subtraction = new Runnable() {
        @Override
        public void run() {
            synchronized (count){
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    count -= 1;
                }
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Thread subThread = new Thread(subtraction);
        Thread sumThread = new Thread(summation);

        sumThread.start();
        subThread.start();

        while (sumThread.isAlive() || subThread.isAlive()){
            System.out.println(count);
            Thread.sleep(300);
        }

    }
}
