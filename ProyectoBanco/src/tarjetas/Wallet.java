package tarjetas;

import java.time.LocalDate;
import java.util.Random;

public class Wallet {
    private String titular;
    private String numeroTarjeta;
    private LocalDate fechaCreacion;
    private int cvv;
    private LocalDate fechaVencimiento;

    public Wallet(String titular, String numeroTarjeta) {
        this.titular = titular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCreacion = LocalDate.now();
        this.cvv = generarCvv;
        this.fechaVencimiento = fechaCreacion.plusYears(5);


        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
        }

        public String getNumeroTarjeta() {
            return numeroTarjeta;
        }

        public void setNumeroTarjeta(String numeroTarjeta) {
            this.numeroTarjeta = numeroTarjeta;
        }

        public LocalDate getFechaCreacion() {
            return fechaCreacion;
        }

        public void setFechaCreacion(LocalDate fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
        }

        public int getCvv() {
            return cvv;
        }

        public void setCvv(int cvv) {
            this.cvv = cvv;
        }

        public LocalDate getFechaVencimiento() {
            return fechaVencimiento;
        }

        public void setFechaVencimiento(LocalDate fechaVencimiento) {
            this.fechaVencimiento = fechaVencimiento;
        }

        public int generarCvv() {
            Random random = new Random();
            return 100 + random.nextInt(900);
        }

        public String mostrarDatosTarjeta() {
            return String.format("Titular:  %s | Numero Tarjeta: %s | Fecha Creacion: %s | CVV: %s | Fecha de Vencimiento: %s ", getTitular(), getNumeroTarjeta(), getFechaCreacion(), getCvv(), getFechaVencimiento());
        }
    }
}
