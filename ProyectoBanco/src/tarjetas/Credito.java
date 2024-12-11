package tarjetas;

public class Credito extends Wallet{
    private double limiteCredito;
    private double deudaCredito;

    public Credito(String titular, String numeroTarjeta) {
        super(titular, numeroTarjeta);
        this.limiteCredito = 100000.0;
        this.deudaCredito = 0.0;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getDeudaCredito() {
        return deudaCredito;
    }

    public void setDeudaCredito(double deudaCredito) {
        this.deudaCredito = deudaCredito;
    }

    public void limiteDeCredito(double gasto) {
        setLimiteDeCredito(limiteDeCredito - gasto);
        setDeudaCredito(deudaCredito + gasto);
    }

    public void abonoADeuda(double abono) {
        setLimiteDeCredito(limiteDeCredito + abono);
        setDeudaCredito(deudaCredito - abono);
    }

    @Override
    public String mostrarDatosTarjeta() {
        return super.mostrarDatosTarjeta() + String.format(" | Limite de crédito: %s | Deuda: %s", getLimiteDeCredito(), getDeudaCredito());
    }
}
