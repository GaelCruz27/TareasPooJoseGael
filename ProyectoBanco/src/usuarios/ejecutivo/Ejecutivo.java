package usuarios.ejecutivo;

import usuarios.Usuario;
import usuarios.utils.Rol;

public class Ejecutivo extends Usuario {
    private double salario;

    public Ejecutivo(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, double salario) {
        super(id, nombre, apellidos, curp, rfc, direccion, sucursal, contrasenia, Rol.EJECUTIVO);
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
