package tarjetas;
import exepciones.FondosInsuficieites;
import java.time.LocalDate;

public class Debito extends tarjeta{
    private double saldoDebito;
    public Debito(String titular, String numeroTarjeta, double saldoDebito) {
        super(titular, numeroTarjeta);
        this.saldoDebito = saldoDebito;
    }
    public void retitar(double monto) thows FondosInsuficientes{
        if (monto>saldoDebito){
            throw new FondosInsuficientes("No se puede completar el retiro, SALDO INSUFICIENTE");
        }
        saldoDebito-=monto;
    }

    public double getSaldoDebito() {
        return saldoDebito;
    }

    public void setSaldoDebito(double saldoDebito) {
        this.saldoDebito = saldoDebito;
    }

    public void cargo(double cargo){
        setSaldoDebito(getSaldoDebito()-cargo);
    }

    @Override
    public String mostrarDatosTarjeta(){
        retur super.mostrarDatosTarjeta() + String.format(" | Saldo %s", getSaldoDebito());
    }
}