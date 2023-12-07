package gui.hangman;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class SecretLabel extends JLabel {

    List<String> words;
    String secret;
    String text;

    SecretLabel(){
        loadWords("secrets.txt");
        Random random = new Random();
        secret = words.get(random.nextInt(words.size()));
        System.out.println("secret is : " + secret);

        text = " ";
        for (int i = 0; i < secret.length(); i++) {
            text += "___ ";
        }
        this.setText(text);

        this.setBackground(new Color(0xD9B9EC));
        this.setOpaque(true);
        this.setFont(new Font("MV Boli", Font.BOLD, 64));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    void loadWords(String path){
        try {
            words = Files.readAllLines(Paths.get(path));
        } catch (IOException e){
            System.out.println(":/");
        }
    }

}
