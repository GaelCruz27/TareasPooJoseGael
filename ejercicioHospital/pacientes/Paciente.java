package ejercicioHospital.pacientes;

public class Paciente {

    public int id;
    public String nombre;
    public String apellidos;
    public String edad;
    public String fechaNacimiento;
    private String telefono;
    public String tupoSangre;
    public char sexo;

    public Paciente(int id, String nombre, String apellidos, String edad, String fechaNacimiento, String telefono, String tupoSangre, char sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tupoSangre = tupoSangre;
        this.sexo = sexo;
    }


}