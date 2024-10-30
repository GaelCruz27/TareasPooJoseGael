public class SeguroAuto extends Seguro {
    private int edadTitular;
    private static final double VALOR_BASE = 300;
    private static final double PORCENTAJE_VALOR = 0.05;
    private static final double RECARGO_JOVEN = 0.15;

    public SeguroAuto(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double primaBase = VALOR_BASE + (valorAsegurado * PORCENTAJE_VALOR);


        if (edadTitular < 25) {
            primaBase += primaBase * RECARGO_JOVEN;
        }

        return primaBase;
    }

    @Override
    public String detallesSeguro() {
        return "SEGURO DE AUTO\n" +
                super.detallesSeguro() +
                "\nEdad del titular: " + edadTitular + " años" +
                (edadTitular < 25 ? "\nSe aplica recargo por conductor joven" : "");
    }

    public int getEdadTitular() {
        return edadTitular;
    }

    public void setEdadTitular(int edadTitular) {
        this.edadTitular = edadTitular;
    }
}