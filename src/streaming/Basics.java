package streaming;

import java.io.*;
import java.util.Scanner;

public class Basics {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(sc.nextLine());
//        }
//        Scanner sc = new Scanner("hello world,_here is some text!");
//        sc.useDelimiter("_");
//        while(sc.hasNext()){
//            System.out.println(sc.next());
//        }
        FileInputStream fis = new FileInputStream("text.txt");
        InputStreamReader reader = new InputStreamReader(fis);
        System.out.println("Soubor zakodovan v: " +reader.getEncoding());
        int character;
        while ((character = reader.read()) != -1){
            System.out.println("ready? " + reader.ready());
            System.out.print((char) character);
            System.out.println();
        }

    }
}
