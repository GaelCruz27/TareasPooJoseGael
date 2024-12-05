package banco;

import tarjetas.Credito;
import tarjetas.Tarjeta;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Banco {
    public ArrayList<Usuario> listaUsuarios;
    public ArrayList<Gerente> listaGerentes;
    public ArrayList<Ejecutivo> listaEjecutivos;
    public ArrayList<Cliente> listaClientes;
    public ArrayList<Cliente> solicitudesTarjetaCredito;

    public Banco() {
        this.listaUsuarios = new ArrayList<>();
        this.listaGerentes = new ArrayList<>();
        this.listaEjecutivos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.solicitudesTarjetaCredito = new ArrayList<>();
    }

    public Usuario validarInicioSesion(String idUsuario, String contrasenia) {
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().trim().equals(idUsuario.trim()) &&
                    usuario.getContrasenia().trim().equals(contrasenia.trim())) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarGerente(Gerente gerente) {
        this.listaUsuarios.add(gerente);
        this.listaGerentes.add(gerente);
    }

    public void registrarEjecutivo(Ejecutivo ejecutivo) {
        this.listaUsuarios.add(ejecutivo);
        this.listaEjecutivos.add(ejecutivo);
    }

    public void registrarCliente(Cliente cliente) {
        this.listaUsuarios.add(cliente);
        this.listaClientes.add(cliente);
    }

    public String generarIdUsuario(String nombre, Rol rol) {
        int mes = LocalDate.now().getMonthValue();
        int anio = LocalDate.now().getYear();
        String nom = nombre.substring(0, 3).toUpperCase();
        String inicial = "";

        if (rol == Rol.GERENTE) {
            inicial = "G";
        } else if (rol == Rol.EJECUTIVO) {
            inicial = "E";
        } else {
            inicial = "C";
        }

        Random random = new Random();
        int numeroRandom = random.nextInt(100);

        return String.format("%s-%s%d%d%02d", inicial, nom, anio, mes, numeroRandom);
    }

    public String generarCurp() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String vocales = "AEIOU";
        String numeros = "0123456789";
        Random random = new Random();

        return String.valueOf(letras.charAt(random.nextInt(letras.length()))) +
                vocales.charAt(random.nextInt(vocales.length())) +

                // Primera letra del segundo apellido
                letras.charAt(random.nextInt(letras.length())) +

                // Primera letra del primer nombre
                letras.charAt(random.nextInt(letras.length())) +

                // Fecha de nacimiento (Año-Mes-Día)
                String.format("%02d", random.nextInt(100)) + // Últimos 2 dígitos del año
                String.format("%02d", 1 + random.nextInt(12)) + // Mes
                String.format("%02d", 1 + random.nextInt(28)) + // Día

                // Sexo (H/M)
                (random.nextBoolean() ? "H" : "M") +

                // Entidad federativa (2 letras)
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

                // Primeras consonantes internas de los apellidos y nombre
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

                // Homoclave (2 letras y 1 número)
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +
                numeros.charAt(random.nextInt(numeros.length()));
    }

    public String generarRfc() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();

        StringBuilder rfc = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            rfc.append(letras.charAt(random.nextInt(letras.length())));
        }

        rfc.append(String.format("%02d", random.nextInt(100))); // Últimos 2 dígitos del año
        rfc.append(String.format("%02d", 1 + random.nextInt(12))); // Mes
        rfc.append(String.format("%02d", 1 + random.nextInt(28))); // Día

        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                rfc.append(letras.charAt(random.nextInt(letras.length())));
            } else {
                rfc.append(numeros.charAt(random.nextInt(numeros.length())));
            }
        }

        return rfc.toString();
    }

    public String generarNumeroDeCuenta() {
        boolean band = true;
        String numeroDeCuenta = "";
        String digitosIniciales = "7";
        Random random = new Random();
        while (band) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 19; i++) {
                sb.append(random.nextInt(10));
            }
            numeroDeCuenta = digitosIniciales + sb;
            band = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getNumeroCuenta().equals(numeroDeCuenta)) {
                    band = true;
                    break;
                }
            }
        }
        return numeroDeCuenta;
    }

    public String generarNumeroDeTarjetaDedito() {
        boolean band = true;
        String numeroDeTarjetaDebito = "";
        String digitosIniciales = "4257";
        Random random = new Random();
        while (band) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                sb.append(random.nextInt(10));
            }
            numeroDeTarjetaDebito = digitosIniciales + sb;
            band = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getNumeroCuenta().equals(numeroDeTarjetaDebito)) {
                    band = true;
                    break;
                }
            }
        }
        return numeroDeTarjetaDebito;
    }

    public String generarNumeroDeTarjetaDCredito() {
        boolean band = true;
        String numeroDeTarjetaCredito = "";
        String digitosIniciales = "5742";
        Random random = new Random();
        while (band) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                sb.append(random.nextInt(10));
            }
            numeroDeTarjetaCredito = digitosIniciales + sb;
            band = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getNumeroCuenta().equals(numeroDeTarjetaCredito)) {
                    band = true;
                    break;
                }
            }
        }
        return numeroDeTarjetaCredito;
    }

    public String generarClaveInterbancaria() {
        boolean band = true;
        String clave = "";
        Random random = new Random();
        while (band) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 18; i++) {
                sb.append(random.nextInt(10));
            }
            clave = sb.toString();
            band = false;
            for (Cliente cliente : listaClientes) {
                if (cliente.getClave().equals(clave)) {
                    band = true;
                    break;
                }
            }
        }
        return clave;
    }

    public void mostrarGerentes() {
        if (this.listaGerentes.isEmpty()) {
            System.out.println("No hay gerentes registrados");
        } else {
            for (Gerente gerente : this.listaGerentes) {
                System.out.println(gerente.mostrarDatos());
            }
        }
    }

    public void mostrarEjecutivos() {
        if (this.listaEjecutivos.isEmpty()) {
            System.out.println("No hay ejecutivos registrados");
        } else {
            for (Ejecutivo ejecutivo : this.listaEjecutivos) {
                System.out.println(ejecutivo.mostrarDatos());
            }
        }
    }

    public void mostrarClientes() {
        if (this.listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            for (Cliente cliente : this.listaClientes) {
                System.out.println(cliente.mostrarDatos());
            }
        }
    }

    public String solicitarTarjetaCredito(Cliente cliente) {
        if (cliente.getTarjetaDebito().getSaldo() >= 30000) {
            if (this.solicitudesTarjetaCredito.contains(cliente)) {
                return "Ya tienes una solicitud de tarjeta de crédito pendiente";
            }

            this.solicitudesTarjetaCredito.add(cliente);

            return "Solicitud de tarjeta de crédito registrada exitosamente.";
        } else {
            return "Saldo insuficiente en la tarjeta de débito. Necesitas al menos 30,000.";
        }
    }

    public void verSolicitudesPendientes() {
        if (this.solicitudesTarjetaCredito.isEmpty()) {
            System.out.println("No hay solicitudes pendientes");
        } else {
            for (Cliente cliente : this.solicitudesTarjetaCredito) {
                System.out.println("Id: "+ cliente.getId() + "Cliente: " + cliente.getNombre() + " " + cliente.getApellidos() + "  |  Saldo: " + cliente.getTarjetaDebito().getSaldo());
            }
        }
    }

    public String procesarSolicitudTarjeta(Cliente cliente, boolean aprobar) {
        if (!this.solicitudesTarjetaCredito.contains(cliente)) {
            return "El cliente no tiene una solicitud pendiente";
        }

        if (aprobar){
            String numeroTarjeta = generarNumeroDeTarjetaDCredito();
            String titular = cliente.getNombre() + " " + cliente.getApellidos();
            Credito credito = new Credito(titular, numeroTarjeta);
            cliente.setTarjetaCredito(credito);
            this.solicitudesTarjetaCredito.remove(cliente);
            return "Solicitud aprobada y asociada al cliente";
        } else {
            this.solicitudesTarjetaCredito.remove(cliente);
            return "Solicitud rechazada";
        }
    }

}