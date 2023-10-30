package exceptions;

public class Main {

    static int factorial(int a) throws FactorialException {
        if(a < 0) throw new FactorialException();
        if (a < 2) return 1;
        return a * factorial( a- 1);
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            System.out.println(factorial(-3));
        } catch (FactorialException e) {
            e.printStackTrace();
        }

        long start = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
        }
        long stop = System.nanoTime();
        long dur = stop - start;
    }
}