package streaming;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeBasics {
    public static void main(String[] args) {
        Movie m = new Movie("The Gentlemen", Integer.MAX_VALUE, 9.5);
//        System.out.println(m.toString());
        //serializace:
        try{
            FileOutputStream fileOut = new FileOutputStream("mov.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(m);//hod objekt do souboru
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //deserializace:
        try {
          FileInputStream fileIn = new FileInputStream("mov.ser");

          ObjectInputStream in = new ObjectInputStream(fileIn);
//          Object des = in.readObject();
//          if (des instanceof Movie){
//              Movie deserialized = (Movie) des;
//          }
          Movie deserialized = (Movie) in.readObject();
          in.close();
          fileIn.close();
            System.out.println("Deserialization OK:");
            System.out.println(deserialized);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }

    }
} class Movie implements Serializable {
    private String name;
    private int year;
    private double release;

    public Movie(String name, int year, double release) {
        this.name = name;
        this.year = year;
        this.release = release;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", release=" + release +
                '}';
    }
}
