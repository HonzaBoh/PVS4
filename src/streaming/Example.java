package streaming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Example {

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"), 10);

        for (int i = 0; i < 10000; i++) {
            bufferedWriter.write("Line#" + (1+i) + "\n");
        }

    }
}
