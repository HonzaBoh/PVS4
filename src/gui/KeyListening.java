package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListening extends JFrame implements KeyListener {

    MySpecialLabel keyCode, keyPressed;
    KeyListening(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setLayout(new GridLayout(4,1));
        MySpecialLabel keyDesc = new MySpecialLabel("Key pressed:");
         keyPressed = new MySpecialLabel("TMP");
        MySpecialLabel keyCodeDesc = new MySpecialLabel("Key pressed code:");
         keyCode = new MySpecialLabel("TMP");
        this.add(keyDesc);
        this.add(keyPressed);
        this.add(keyCodeDesc);
        this.add(keyCode);
        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        new KeyListening().setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("character:" + e.getKeyChar());
//        System.out.println("code:" + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
       }

    @Override
    public void keyReleased(KeyEvent e) {
        keyCode.setText(e.getKeyCode()+"");
        keyPressed.setText(e.getKeyChar()+"");
    }
}
class MySpecialLabel extends JLabel{
    MySpecialLabel(String text){
        this.setText(text);
        this.setHorizontalAlignment(CENTER);
        this.setVerticalAlignment(CENTER);
        this.setFont(new Font("Consolas", Font.PLAIN, 22));
        this.setBackground(new Color(0xEFEDAE));
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
    }
}