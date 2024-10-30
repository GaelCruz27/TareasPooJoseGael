public class SeguroVida extends Seguro {
    private int edadTitular;
    private static final double VALOR_BASE = 400;
    private static final double PORCENTAJE_VALOR = 0.015;
    private static final double RECARGO_MAYOR = 0.25;

    public SeguroVida(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double primaBase = VALOR_BASE + (valorAsegurado * PORCENTAJE_VALOR);


        if (edadTitular > 60) {
            primaBase += primaBase * RECARGO_MAYOR;
        }

        return primaBase;
    }

    @Override
    public String detallesSeguro() {
        return "SEGURO DE VIDA\n" +
                super.detallesSeguro() +
                "\nEdad del titular: " + edadTitular + " años" +
                (edadTitular > 60 ? "\nSe aplica recargo por edad avanzada" : "");
    }

    public int getEdadTitular() {
        return edadTitular;
    }

    public void setEdadTitular(int edadTitular) {
        this.edadTitular = edadTitular;
    }
}