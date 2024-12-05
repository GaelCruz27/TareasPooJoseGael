import banco.Banco;
import menu.MenuPrincipal;
import usuarios.utils.JsonManager;

public class Main {

    public static void main(String[] args) {

        String filePath = "banco.json";
        Banco banco = JsonManager.cargarBancoDesdeJson(filePath);

        MenuPrincipal menuAcceso = new MenuPrincipal(banco);
        menuAcceso.iniciarSesion();

        JsonManager.guardarBancoEnJson(banco, filePath);

    }

}