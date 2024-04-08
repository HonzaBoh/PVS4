package practice;

import java.awt.*;

public class Spider extends Bugs{
    boolean webSpinner;

    public Spider(int legs, int eyes, Color color, boolean webSpinner) {
        super(legs, eyes, color);
        this.webSpinner = webSpinner;
    }

    @Override
    void bite() {
        super.bite();
        System.out.println("venomous ouch");
    }

    public static void main(String[] args) {
        Spider s = new Spider(8,6,Color.black, true);
        s.bite();
        Bugs b = new Spider(8,3,Color.magenta,false);
        b.bite();
    }
}
