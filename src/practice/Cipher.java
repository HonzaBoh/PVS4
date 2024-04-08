package practice;

public interface Cipher {

    String encrypt(String text, int key);

    String decrypt(String text, int key);
}
