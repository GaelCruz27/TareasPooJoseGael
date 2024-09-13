public class Coche {
    private String marca;
    private String modelo;
    private int año;

    public Coche(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public void mostrarInformacion() {
        System.out.println("Marca:\t" + marca);
        System.out.println("Modelo:\t" + modelo);
        System.out.println("Año:\t" + año);
        System.out.println("Edad:\t" + calcularEdadDelCoche(2024) + " años");
        System.out.println(); // Salto de línea adicional para separar los coches
    }

    public int calcularEdadDelCoche(int añoActual) {
        return añoActual - año;
    }
}