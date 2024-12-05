package usuarios.utils;

import banco.Banco;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonDeserializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class JsonManager {
    private static final Gson gson;

    static {
        // Configurar Gson para manejar subtipos con el campo "rol" y LocalDate
        gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // Registrar el adaptador
                .registerTypeAdapter(Usuario.class, (JsonDeserializer<Usuario>) (json, typeOfT, context) -> {
                    String rol = json.getAsJsonObject().get("rol").getAsString();

                    // Identificar el tipo de usuario según el valor de "rol"
                    Class<? extends Usuario> subtype = switch (rol) {
                        case "GERENTE" -> Gerente.class;
                        case "EJECUTIVO" -> Ejecutivo.class;
                        case "CLIENTE" -> Cliente.class;
                        default -> throw new JsonParseException("Rol desconocido: " + rol);
                    };

                    // Deserializar al tipo específico
                    return context.deserialize(json, subtype);
                })
                .setLenient() // Permite JSON con formato más flexible
                .setPrettyPrinting()
                .create();
    }

    // Guardar el estado del banco en un archivo JSON
    public static void guardarBancoEnJson(Banco banco, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(banco, writer); // Usa el objeto Gson configurado con los adaptadores
            System.out.println("Banco guardado correctamente en el archivo JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo JSON: " + e.getMessage());
        }
    }

    // Cargar el estado del banco desde un archivo JSON
    public static Banco cargarBancoDesdeJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Banco.class); // Usa el objeto Gson configurado con los adaptadores
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo JSON: " + e.getMessage());
            return new Banco(); // Retorna un banco vacío en caso de error
        } catch (JsonParseException e) {
            System.out.println("Error al parsear el archivo JSON: " + e.getMessage());
            return new Banco(); // Retorna un banco vacío en caso de error de formato
        }
    }
}