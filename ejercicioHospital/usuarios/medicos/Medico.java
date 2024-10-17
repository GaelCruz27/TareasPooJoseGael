package ejercicioHospital.usuarios.medicos;


import ejercicioHospital.usuarios.Usuario;
import ejercicioHospital.usuarios.utils.Rol;
import java.time.LocalDate;

public class Medico extends Usuario {

    private String rfc;

    //constructor
    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc,String contrasenia ) {

        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.MEDICO);
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
    }



    public String getRfc() {
        return rfc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String mostrarDatos() {
        String datos = String.format("Id: %s, nombre: %s, apellidos: %s, fecha de nacimiento: %s, telefono: %s, rfc: %s",
                id,
                nombre,
                apellidos,
                fechaNacimiento,
                telefono,
                rfc);
        return datos;
    }
}