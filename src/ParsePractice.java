import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParsePractice {

    static ArrayList<Point> loadPointsEasy(){
        ArrayList<Point> points = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("easy.txt"));
            for (String line : lines){
                if (!line.startsWith("Z")){
                    String[] arguments = line.split(" ");
                    points.add(new Point(Integer.parseInt(arguments[0]),
                            Integer.parseInt(arguments[1]),
                            Integer.parseInt(arguments[2])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return points;
    }

    static ArrayList<Point> loadPointsMedium(){
        ArrayList<Point> points = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("medium.txt"));
            boolean commentFlag = false;
            for (String line : lines){
                String[] arguments = line.split(" ");
                if (line.startsWith("Z")){
                    commentFlag = true;
                }
                if (arguments.length == 3 && !commentFlag){
                    points.add(new Point(Integer.parseInt(arguments[0]),
                            Integer.parseInt(arguments[1]),
                            Integer.parseInt(arguments[2])));
                }
                if (line.endsWith("K")){
                    commentFlag = false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return points;
    }

    static void loadPointsHardRecursive(){
        // vsechna cisla, co nejsou v komentarich
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("hard.txt"));
            while (scanner.hasNext()){ //dokud v souboru neco je
                String token = scanner.next();
                if (token.equals("Z")){
                    //rekurzivni skip commentu
                    skipComment(scanner);
                } else {
                    numbers.add(Integer.parseInt(token));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(numbers);
    }


    private static void skipComment(Scanner scanner){
        while (scanner.hasNext()){
            String token = scanner.next();
            if (token.equals("K")){
                return;
            } else if(token.equals("Z")){
                skipComment(scanner);
            }
        }
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ArrayList<Point> points;

        points = loadPointsEasy();
        System.out.println(points);

        points = loadPointsMedium();
        System.out.println(points);
        System.out.println("----");

        loadPointsHardRecursive();
    }
}
class Point{
    int x,y,z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}