package streaming;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        reader.close();

        //writing:
        OutputStream out = new FileOutputStream("streamOutput.txt");
        char a = 'a';
        out.write(a);
        out.write(50);
        String hello = "hello to streaming world";
//        out.write(hello);
        byte[] helloByteForm = hello.getBytes();
//        String creative = new String(new byte[]{50,52,'a'}, StandardCharsets.UTF_8);
//        out.write(helloByteForm);
        PrintWriter pw = new PrintWriter(out);
        pw.println("neew line");
        pw.println(helloByteForm);
        pw.close();
        out.close();
    }
}
