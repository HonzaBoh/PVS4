package threads;

public class TougherConcurrency {

    public static void main(String[] args) {
        Multiplication table = new Multiplication();
        TableThread tt1 = new TableThread(table,5);
        TableThread tt2 = new TableThread(table,100);

        tt1.start();
        tt2.start();

        System.out.println("Happy ending?");
    }

} class Multiplication {
    synchronized void printTable(int n){
        for (int i = 1; i <= 5 ; i++) {
            System.out.println(i*n);
        }

    }

    void doSomething(){
        for (int i = 0; i < (int)(Math.random()*100); i++) {
            System.out.println(i);
        }
    }
} class TableThread extends Thread{
    Multiplication table;
    int number;

    TableThread(Multiplication table, int number){
        this.number = number;
        this.table = table;
    }
    @Override
    public void run() {
        System.out.println("Running: " + this.getName());
        table.printTable(number);
        try {
            Thread.sleep((int)(Math.random()*5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished: " + this.getName());

    }
}
