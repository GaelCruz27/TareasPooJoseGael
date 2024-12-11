package menus;

import banco.Banco;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuAcceso MenuAcceso{
    Banco banco;
    Scanner sc = new Scanner(System.in);

    public MenuAcceso(Banco banco) {
        this.banco = banco;
    }
    public void inicioSesion(){
        int NumIntentos=3;
        int intentos=0;

        while(intentos<NumIntentos){
            System.out.println("\n --MENU DE ACCESO--");

            System.out.println("\nIngresa tu USUARIO: ");
            String usuario = sc.nextLine();

            System.out.println("\nIngresa tu CONTRASENIA: ");
            String contrasenia = sc.nextLine();

            Usuario usuarioSesion=banco.validarInicioSesion(usuario, contrasenia);

            if

        }
    }
}