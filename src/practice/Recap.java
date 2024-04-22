package practice;

import java.io.File;
import java.util.Arrays;

public class Recap {

    static void tree(File file) {

        if (file.isFile()) {
            System.out.println("F: " + file.getName());
        } else {
            File[] files = file.listFiles();
            System.out.println("D: " + file.getName());
            for (File f : files){
                tree(f);
            }
        }
    }

    public static void main(String[] args) {
        File f = new File("src");
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.length());
        System.out.println(f.getAbsolutePath());
        System.out.println("Je soubor: " + f.isFile());
        System.out.println("Je adresar: " + f.isDirectory());
        System.out.println("Obsah slozky: " + Arrays.toString(f.listFiles()));
        tree(new File("src"));
    }
}
