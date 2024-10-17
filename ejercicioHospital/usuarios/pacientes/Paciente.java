package ejercicioHospital.usuarios.pacientes;

import ejercicioHospital.usuarios.Usuario;
import ejercicioHospital.usuarios.utils.Rol;

import java.time.LocalDate;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;


    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String tipoSangre, char sexo, String telefono, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.PACIENTE);
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.telefono = telefono;
    }


    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }


    public String mostrarDatos() {
        String datos = String.format("Id: %s,Nombre: %s,Apellido: %s,Fecha Nacimiento: %s,Tipo sangre: %s,Sexo: %s,Telefono: %s", id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono);
        return datos;
    }

}