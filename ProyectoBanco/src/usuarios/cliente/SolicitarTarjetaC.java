package usuarios.cliente;

public class SolicitudTarjetaCredito {
    private Cliente cliente;
    private String analisis;

    public SolicitudTarjetaCredito(Cliente cliente) {
        this.cliente = cliente;
        this.analisis = "procesando";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}