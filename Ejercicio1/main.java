package Ejercicio1;

public class main {
    
    public static void calcular(String[] args) {
        // Ejemplo con enteros
        Rectangulo rectInt = new Rectangulo(7, 13);
        System.out.println("Área (int): " + rectInt.calcularArea());
        System.out.println("Perímetro (int): " + rectInt.calcularPerimetro());

        // Ejemplo con doubles
        Rectangulo rectDouble = new Rectangulo(7.9, 15.3);
        System.out.println("Área (double): " + rectDouble.calcularArea());
        System.out.println("Perímetro (double): " + rectDouble.calcularPerimetro());
    }
    
}
