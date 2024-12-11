package exepciones;

public class FondosInsuficientes extends Exception {
    public FondosInsuficientes(String mensaje) {
        super(mensaje);
    }
}