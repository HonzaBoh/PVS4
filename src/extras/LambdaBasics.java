package extras;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaBasics {
    public static void main(String[] args) {
        Comparator<File> fileComparator = (o1, o2) -> (int) (o1.length() - o2.length());

        ChangeNumber number = n -> n*n;
        number.change(5);

        Operation addition = Double::sum;
        Operation difference = (a, b) -> a - b;
        Operation multiplication = (a, b) -> a * b;
        Operation division = (a, b) -> a / b;

        System.out.println(addition.operation(10,5));
        System.out.println(difference.operation(10,5));
        System.out.println(multiplication.operation(10,5));
        System.out.println(division.operation(10,5));

        Texting text = word -> System.out.println("Hello " + word);
        text.text("World");
        ZeroSum zeroSum = () -> System.out.println("nic");

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "children", 10.5));
        products.add(new Product(2, "potatoes", 15));
        products.add(new Product(3, "cage", 150.15));
        products.add(new Product(4, "whip", 350.15));
        products.add(new Product(5, "potato peeler", 900.25));

//        List<Product> cheapProducts = new ArrayList<>();
//        for (Product product : products){
//            if (product.price < 150.50){
//                cheapProducts.add(product);
//            }
//        }
        List<Product> cheapProducts = products.stream()
                .filter(product -> product.price < 150.50)
                .toList();
        System.out.println(cheapProducts);

        products.stream()
                .filter(product -> product.price > 200)
                .forEach(System.out::println);
    }
} interface ChangeNumber{
    int change(int n);
} interface Operation{
    double operation(double a, double b);
} interface Texting{
    void text(String word);
} interface ZeroSum{
    void nothing();

} class Product{
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " $" + price;
    }
}
