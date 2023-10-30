package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ExceptionPractice {
    public static void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int start, int end) {
        if (end <= start) return;
        int i = split(data, start, end);
        try {
            quickSort(data, start, i - 1);
            quickSort(data, i + 1, end);
        } catch (StackOverflowError er) {
            System.out.println("Can do no more :(");
        }
    }

    static int split(int[] data, int left, int right) {
        int pivot = data[right];
        while
        (true) {
            while ((pivot > data[left]) && (left < right))
                left++;
            if (left < right) {
                data[right] = data[left];
                right--;
            } else break;
            while ((pivot < data[right]) && (left < right))
                right--;
            if (left < right) {
                data[left] = data[right];
                left++;
            } else break;
        }
        data[left] = pivot;
        return (left);
    }

    static int[] toArray(List<String> lines) {
//        String textArray = Arrays.toString(lines.toArray());
        try {
            int[] array = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++) {
                try {
                    array[i] = Integer.parseInt(lines.get(i));
                } catch (NumberFormatException ne) {
                    System.out.println("Spatne parsovani");
                }
            }
            return array;
        } catch (NullPointerException e) {
            System.out.println("Ctes z listu, ktery neexistuje");
            return new int[0];
        }
    }

    static List<String> readFile(String fileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nenalezen");
        } catch (IOException e) {
            System.out.println("Chybna prace se souborem");
        }
        return lines;
    }

    static int countAverage(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        try {
        return sum / data.length;
        } catch (ArithmeticException zeroDivide){
            System.out.println("Fuj");
        }
        return 0;
    }

    static void replace(int[] array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej index v poli:");
        try {
            int index = sc.nextInt();
            System.out.println("Zadej cislo, ktere do pole chces vlozit:");
            try {
                array[index] = sc.nextInt();
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Neplatny index v poli");
            }
        } catch (InputMismatchException ie) {
            System.out.println("Nezadal jsi cislo!");
        }
//        sc.close();
    }


    public static void main(String[] args) {
        int[] first = toArray(readFile("seq"));
        int[] second = toArray(readFile("seq1.txt"));
        int[] third = toArray(readFile("seq2.txt"));
//        System.out.println(Arrays.toString(first));
//        System.out.println(Arrays.toString(second));
//        System.out.println(Arrays.toString(third));

        replace(first);
        replace(second);

        sort(second);
        sort(third);
//        System.out.println(Arrays.toString(third));

        countAverage(first);
        countAverage(second);
        System.out.println("Happy ending");
    }
}
