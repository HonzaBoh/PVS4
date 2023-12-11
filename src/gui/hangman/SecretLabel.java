package gui.hangman;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class SecretLabel extends JLabel {

   public List<String> words;
   public String secret;
   public String text;
   HashSet<Character> guessed;

    SecretLabel(){
        guessed = new HashSet<>();
        loadWords("secrets.txt");
        Random random = new Random();
        secret = words.get(random.nextInt(words.size()));
        System.out.println("secret is : " + secret);

        reprint();
        this.setText(text);

        this.setBackground(new Color(0xD9B9EC));
        this.setOpaque(true);
        this.setFont(new Font("MV Boli", Font.BOLD, 64));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    void reprint(){
        text = "";
        for (int i = 0; i < secret.length(); i++) {
            if (guessed.contains(secret.charAt(i))){
                text += " " + secret.charAt(i);
            } else {
                text += " _";
            }
        }
        this.setText(text);
    }

    void loadWords(String path){
        try {
            words = Files.readAllLines(Paths.get(path));
        } catch (IOException e){
            System.out.println(":/");
        }
    }

}
