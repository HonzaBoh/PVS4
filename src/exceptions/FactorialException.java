package exceptions;

public class FactorialException extends Exception{
    public FactorialException() {
        super("Takhle faktorial spocitat nejde");
    }
}
