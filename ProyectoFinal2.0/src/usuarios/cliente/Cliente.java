package usuarios.cliente;

import tarjetas.Credito;
import tarjetas.Debito;
import usuarios.Usuario;
import usuarios.utils.Rol;

public class Cliente extends Usuario {
    private String numeroCuenta;
    private Debito tarjetaDebito;
    private Credito tarjetaCredito;
    private String clave;

    public Cliente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, String numeroCuenta, Debito tarjetaDebito, String clave) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.CLIENTE);
        this.numeroCuenta = numeroCuenta;
        this.tarjetaDebito = tarjetaDebito;
        this.tarjetaCredito = null;
        this.clave = clave;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Debito getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void setTarjetaDebito(Debito tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }

    public void setTarjetaCredito(Credito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Credito getTarjetaCredito() {
        return tarjetaCredito;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format(" | Numero De Cuenta: %s | Clave: %s", getNumeroCuenta(), getClave());
    }

}