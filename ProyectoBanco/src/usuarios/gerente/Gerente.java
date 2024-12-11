package usuarios.gerente;

import usuarios.Usuario;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.utils.Rol;

import java.util.ArrayList;

public class Gerente extends Usuario {
    private double salario;

    public Gerente(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, double salario) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.GERENTE);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + String.format(" | Salario: %s", getSalario());
    }

}
