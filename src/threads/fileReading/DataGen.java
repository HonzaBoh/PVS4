package threads.fileReading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class DataGen {

    static void generate(String baseName, int quantity, int amountOfLines, int min, int max) throws IOException {
        Random r = new Random();
        for (int i = 0; i <quantity; i++) {
            PrintWriter pw = new PrintWriter(new FileWriter(baseName + i + ".txt"));
            for (int j = 0; j < amountOfLines; j++) {
                pw.println(r.nextInt(min, max));
            }
            pw.close();
        }
    }

    public static void main(String[] args) throws IOException {
        generate("seq", 50, 2000000, -42000, 42000);
    }
}
