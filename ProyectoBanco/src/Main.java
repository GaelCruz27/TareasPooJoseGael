import banco.Banco;
import menus.MenuAcceso;
import usuarios.utils.dieños.MostrarImagen;
import utils.JsonManager;

public class Main {

    public static void main(String[] args) {

        String filePath = "banco.json";
        Banco banco = JsonManager.cargarBancoDesdeJson(filePath);


        MenuAcceso menuAcceso = new MenuAcceso(banco);
        menuAcceso.iniciarSesion();

        JsonManager.guardarBancoEnJson(banco, filePath);

    }

}