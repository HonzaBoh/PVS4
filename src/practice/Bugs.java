package practice;

import java.awt.*;

public class Bugs {
    int legs,eyes;
    Color color;


    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Bugs(int legs, int eyes, Color color) {
        this.legs = legs;
        this.eyes = eyes;
        this.color = color;
    }

    void bite(){
        System.out.println("...big ouch");
    }

}
