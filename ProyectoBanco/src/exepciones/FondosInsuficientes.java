package exepciones;

public class FondosInsuficientes extends Exception {
    public FondosInsuficientes(String message) {
        super(message);
    }
}