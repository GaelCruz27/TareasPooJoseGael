package usuarios;

import usuarios.utils.Rol;

public class Usuario {
    private String id;
    private String nombre;
    private String apellidos;
    private String curp;
    private String rfc;
    private String direccion;
    private String sucursal;
    private String contrasenia;
    private Rol rol;

    public Usuario(String id, String nombre, String apellidos, String curp, String rfc, String direccion, String sucursal, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.rfc = rfc;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String mostrarDatos() {
        return String.format("ID: %s | Nombre: %s | Apellidos: %s | CURP: %s | RFC: %s | Dirección: %s | Sucursal: %s", getId(), getNombre(), getApellidos(), getCurp(), getRfc(), getDireccion(), getSucursal());
    }
}