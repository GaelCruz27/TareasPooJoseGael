public abstract class Seguro {
    protected String nombreTitular;
    protected double valorAsegurado;

    public Seguro(String nombreTitular, double valorAsegurado) {
        this.nombreTitular = nombreTitular;
        this.valorAsegurado = valorAsegurado;
    }


    public abstract double calcularPrima();


    public String detallesSeguro() {
        return "Seguro a nombre de: " + nombreTitular +
                "\nValor asegurado: $" + valorAsegurado +
                "\nPrima anual: $" + calcularPrima();
    }


    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(double valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }
}