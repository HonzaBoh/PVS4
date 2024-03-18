package streaming;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializeMultiples {

    public static final String SERIALIZE_PATH = "movies.ser";

    static ArrayList<Movies> readMovies(String filePath) {
        ArrayList<Movies> movies = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] arg = line.split(";");
                movies.add(
                        new Movies(arg[0],
                            Integer.parseInt(arg[1]),
                            Double.parseDouble(arg[2]))
                );
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return movies;
    }

    static void serializeMovies(ArrayList<Movies> movies) {
        try {
            FileOutputStream fileOut = new FileOutputStream(SERIALIZE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            //varianta1
            out.writeObject(movies);
            out.close();
            fileOut.close();

            // TODO: 18.03.2024 Append
//            out.writeObject(movies);
//            out.close();
//            fileOut.close();
            System.out.println("Serialized");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static ArrayList<Movies> deserializeMovies(String serPath) {
        ArrayList<Movies> deserialized = null;
        try{
            FileInputStream fileIn = new FileInputStream(serPath);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            deserialized = (ArrayList<Movies>) in.readObject();

            in.close();
            fileIn.close();
            System.out.println("Deserialized");
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        return deserialized;
    }

    public static void main(String[] args) {
       ArrayList<Movies> movies = readMovies("ComparableMovies.txt");
        System.out.println(movies);
        serializeMovies(movies);
        ArrayList<Movies> desMovies = deserializeMovies(SERIALIZE_PATH);
        System.out.println(desMovies);
    }

}

class Movies implements Serializable {
    String name;
    int year;
    double rating;

    public Movies(String name, int year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
