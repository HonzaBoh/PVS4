package streaming;

import java.io.*;

public class Example {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Movies.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Exception? " + e);
        }

    }
}
