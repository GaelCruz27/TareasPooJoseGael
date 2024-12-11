package banco;

import Tarjetas.Credito;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

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
        String Cargo;

        if (rol == Rol.GERENTE) {
            Cargo = "G";
        } else if (rol == Rol.EJECUTIVO) {
            Cargo = "E";
        } else {
            Cargo = "C";
        }

        Random random = new Random();
        int numeroRandom = random.nextInt(100);

        return String.format("%s-%s%d%d%02d", Cargo, nom, anio, mes, numeroRandom);
    }

    public String generarCurp() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String vocales = "AEIOU";
        String numeros = "0123456789";
        Random random = new Random();

        return String.valueOf(letras.charAt(random.nextInt(letras.length()))) +
                vocales.charAt(random.nextInt(vocales.length())) +

                letras.charAt(random.nextInt(letras.length())) +

                letras.charAt(random.nextInt(letras.length())) +

                String.format("%02d", random.nextInt(100)) +
                String.format("%02d", 1 + random.nextInt(12)) +
                String.format("%02d", 1 + random.nextInt(28)) +

                (random.nextBoolean() ? "H" : "M") +

                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +
                letras.charAt(random.nextInt(letras.length())) +

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

        rfc.append(String.format("%02d", random.nextInt(100)));
        rfc.append(String.format("%02d", 1 + random.nextInt(12)));
        rfc.append(String.format("%02d", 1 + random.nextInt(28)));

        for (int i = 0; i < 3; i++) {
            if (random.nextBoolean()) {
                rfc.append(letras.charAt(random.nextInt(letras.length())));
            } else {
                rfc.append(numeros.charAt(random.nextInt(numeros.length())));
            }
        }

        return rfc.toString();
    }

    private String generarNumeroUnico(String prefijo, int longitud, Function<Cliente, String> campo) {
        Random random = new Random();

        while (true) {
            StringBuilder sb = new StringBuilder(prefijo);
            for (int i = 0; i < longitud - prefijo.length(); i++) {
                sb.append(random.nextInt(10));
            }
            final String numeroUnico = sb.toString();

            if (listaClientes.stream().noneMatch(cliente -> campo.apply(cliente).equals(numeroUnico))) {
                return numeroUnico;
            }
        }
    }

    public String generarNumeroDeCuenta() {
        return generarNumeroUnico("7", 20, Cliente::getNumeroCuenta);
    }

    public String generarNumeroDeTarjetaDedito() {
        return generarNumeroUnico("4257", 16, Cliente::getNumeroCuenta);
    }

    public String generarNumeroDeTarjetaDCredito() {
        return generarNumeroUnico("5742", 16, Cliente::getNumeroCuenta);
    }

    public String generarClaveInterbancaria() {
        return generarNumeroUnico("", 18, Cliente::getClave);
    }

    public void mostrarGerentes() {
        if (this.listaGerentes.isEmpty()) {
            System.out.println("¡¡SIN GERENTES EN SISTEMA!!");
        } else {
            for (Gerente gerente : this.listaGerentes) {
                System.out.println(gerente.mostrarDatos());
            }
        }
    }

    public void mostrarEjecutivos() {
        if (this.listaEjecutivos.isEmpty()) {
            System.out.println("EL BANCO NO CUENTA CON EJECUTIVOS REGISTRADOS");
        } else {
            for (Ejecutivo ejecutivo : this.listaEjecutivos) {
                System.out.println(ejecutivo.mostrarDatos());
            }
        }
    }

    public void mostrarClientes() {
        if (this.listaClientes.isEmpty()) {
            System.out.println("BANCO SIN CLIENTES");
        } else {
            for (Cliente cliente : this.listaClientes) {
                System.out.println(cliente.mostrarDatos());
            }
        }
    }

    public String solicitarTarjetaCredito(Cliente cliente) {
        if (cliente.getTarjetaDebito().getSaldo() >= 30000) {
            if (this.solicitudesTarjetaCredito.contains(cliente)) {
                return "Una solicitud de tarjeta esta en proceso.";
            }

            this.solicitudesTarjetaCredito.add(cliente);

            return "Tu solicitud Registrada. Espera tu confimacion";
        } else {
            return "El saldo de tu tarjeta de débito es insuficiente. Mínimo necesario de 30,000.";
        }
    }

    public void verSolicitudesPendientes() {
        if (this.solicitudesTarjetaCredito.isEmpty()) {
            System.out.println("Sin solicitudes de tarjeta de crédito pendientes en este momento.");
        } else {
            for (Cliente cliente : this.solicitudesTarjetaCredito) {
                System.out.println("ID: "+ cliente.getId() + " Cliente: " + cliente.getNombre() + " " + cliente.getApellidos() + " | Saldo disponible: " + cliente.getTarjetaDebito().getSaldo());
            }
        }
    }

    public String procesarSolicitudTarjeta(Cliente cliente, boolean aprobar) {
        if (!this.solicitudesTarjetaCredito.contains(cliente)) {
            return "Cliente sin solicitudes de tarjeta de crédito pendientes.";
        }

        if (aprobar) {
            String numeroTarjeta = generarNumeroDeTarjetaDCredito();
            String titular = cliente.getNombre() + " " + cliente.getApellidos();
            Credito credito = new Credito(titular, numeroTarjeta);
            cliente.setTarjetaCredito(credito);
            this.solicitudesTarjetaCredito.remove(cliente);
            return "¡FELICIADES! TU solicitud ha sido aprobada .";
        } else {
            this.solicitudesTarjetaCredito.remove(cliente);
            return "La solicitud rechazada .";
        }
    }
}
