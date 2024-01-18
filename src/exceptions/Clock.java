package exceptions;

public abstract class Clock {
    int timeElapsed = 0;

    public void tick(){
        timeElapsed++;
    }

    abstract void printTime();

}
class DigiClock extends Clock{

    @Override
    void printTime() {
        System.out.println();
    }

    public static void main(String[] args) {
        DigiClock digiClock = new DigiClock();
        for (int i = 0; i < 100; i++) {
            digiClock.tick();
        }

        digiClock.printTime();
    }
}
