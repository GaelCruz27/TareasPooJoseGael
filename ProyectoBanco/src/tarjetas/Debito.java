package Tarjetas;
import exepciones.FondosInsuficientes;

public class Debito extends Tarjeta {
    private double saldoDebito;

    public Debito(String titular, String numeroTarjeta, double saldoDebito) {
        super(titular, numeroTarjeta);
        this.saldoDebito = saldoDebito;
    }

    public void retirar(double monto) throws FondosInsuficientes {
        if (monto > saldoDebito) {
            throw new FondosInsuficientes("Saldo insuficiente para el retiro.");
        }
        saldoDebito -= monto;
    }

    public double getSaldo() {return saldoDebito;}

    public void setSaldo(double saldo) {this.saldoDebito = saldo;}

    public void compra(double compra) {
        setSaldo(getSaldo()-compra);
    }

    @Override
    public String mostrarDatosTarjeta() {
        return super.mostrarDatosTarjeta() + String.format(" | Saldo: %s", getSaldo());
    }
}