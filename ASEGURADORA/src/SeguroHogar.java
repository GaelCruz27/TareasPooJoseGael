public class SeguroHogar extends Seguro {
    private boolean zonaRiesgo;
    private static final double VALOR_BASE = 500;
    private static final double PORCENTAJE_VALOR = 0.02;
    private static final double RECARGO_ZONA_RIESGO = 0.20;

    public SeguroHogar(String nombreTitular, double valorAsegurado, boolean zonaRiesgo) {
        super(nombreTitular, valorAsegurado);
        this.zonaRiesgo = zonaRiesgo;
    }

    @Override
    public double calcularPrima() {
        double primaBase = VALOR_BASE + (valorAsegurado * PORCENTAJE_VALOR);


        if (zonaRiesgo) {
            primaBase += primaBase * RECARGO_ZONA_RIESGO;
        }

        return primaBase;
    }

    @Override
    public String detallesSeguro() {
        return "SEGURO DE HOGAR\n" +
                super.detallesSeguro() +
                "\nZona de riesgo: " + (zonaRiesgo ? "Sí" : "No") +
                (zonaRiesgo ? "\nSe aplica recargo por zona de riesgo" : "");
    }

    public boolean isZonaRiesgo() {
        return zonaRiesgo;
    }

    public void setZonaRiesgo(boolean zonaRiesgo) {
        this.zonaRiesgo = zonaRiesgo;
    }
}