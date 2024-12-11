package menus;

import Tarjetas.Tarjeta;
import banco.Banco;
import usuarios.cliente.Cliente;
import Tarjetas.Debito;
import Tarjetas.Credito;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);
    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n Bienvenido! " + clienteEnSesion.getNombre() + " ==");
        System.out.println("Que deseas realizar hoy? ");

        System.out.println("1. Consulta de información.");
        System.out.println("2. Abrir tarjeta de débito.");
        System.out.println("3. Abrir tarjeta de crédito.");
        System.out.println("4. Cerrar sesión.");

        try {
            System.out.println("Opcion no valida .");
            return scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Dato erroneo");
            return 0;
        }
    }

    public boolean procesarDatos(int opcionCliente, Banco banco, Cliente clienteEnSesion) {
       switch (opcionCliente) {
           case 1:
               System.out.println("\n== Información Personal ==");
               System.out.println("\n" + clienteEnSesion.mostrarDatos());
               break;
           case 2:

               System.out.println("\n== Tarjeta de Débito de"+clienteEnSesion.getNombre()+" ==");
               boolean opcion = true;
               while (opcion) {
                   System.out.println(clienteEnSesion.getTarjetaDebito().mostrarDatosTarjeta());

                   System.out.println("\n1. Deposito de efectivo.");
                   System.out.println("2. Retiro de efectivo.");
                   System.out.println("3. Realizar una compra.");
                   System.out.println("4. Volver al menu principal.");

                   try {
                       System.out.print("Selecciona una opción: ");
                       int op = scanner.nextInt();

                       switch (op) {
                           case 1:
                               depositar(clienteEnSesion);
                               break;
                           case 2:
                               retirar(clienteEnSesion);
                               break;
                           case 3:
                               comparDebito(clienteEnSesion);
                               break;
                           case 4:
                               opcion = false;
                               break;
                           default:
                               System.out.println("Opción no valida");
                               break;
                       }
                   } catch (IllegalArgumentException e) {
                       System.out.println("Dato erroneo");
                   }
               }
               break;
           case 3:
               System.out.println("\n== Tarjeta De Crédito de "+clienteEnSesion.getNombre()+" ==");
               boolean opcionC = true;
               while (opcionC) {
                   if (clienteEnSesion.getTarjetaCredito() != null) {
                       System.out.println(clienteEnSesion.getTarjetaCredito().mostrarDatosTarjeta());

                       System.out.println("\n1. Realizar una compra");
                       System.out.println("2. Pago de Tarjeta de Credito");
                       System.out.println("3. Salir");

                       try {
                           System.out.print("Selecciona una opción: ");
                           int opc = scanner.nextInt();

                           switch (opc) {
                               case 1:
                                   comprarCredito(clienteEnSesion);
                                   break;
                               case 2:
                                   abonarADeuda(clienteEnSesion);
                               case 3:
                                   opcionC = false;
                                   break;
                               default:
                                   System.out.println("Opción no valida");
                                   break;
                           }
                       } catch (IllegalArgumentException e) {
                           System.out.println("Dato erroneo");
                       }
                   } else {
                       System.out.println("\nNo cuentas con una tarjeta de crédito asociada");
                       try {
                           System.out.print("\n¿Deseas solicitar tarjeta de credito?: ");
                           System.out.println("1. Si");
                           System.out.println("2. No");
                           int op = scanner.nextInt();

                           switch (op) {
                               case 1:
                                   System.out.println(banco.solicitarTarjetaCredito(clienteEnSesion));
                                   break;
                               case 2:
                                   break;
                               default:
                                   System.out.println("Opción no valida");
                           }
                       } catch (IllegalArgumentException e){
                           System.out.println("Dato erroneo");
                       }
                       opcionC = false;
                   }
               }
               break;
           case 4:
               System.out.println("Saliendo...");
               return false;
           default:
               System.out.println("Opcion no valida, intentelo de nuevo.");
       }
        return true;
    }

    public void depositar(Cliente clienteEnSesion) {
        try {
            System.out.print("\nIngrese el monto a depositar: ");
            double deposito = scanner.nextDouble();

            clienteEnSesion.getTarjetaDebito().setSaldo(clienteEnSesion.getTarjetaDebito().getSaldo() + deposito);
            System.out.println("Deposito exitoso");
        } catch (IllegalArgumentException e) {
            System.out.println("Dato erroneo");
        }
    }

    public void retirar(Cliente clienteEnSession) {
        while (true) {
            if (clienteEnSession.getTarjetaDebito().getSaldo() == 0) {
                System.out.println("Saldo insuficiente en la tarjeta");
                return;
            } else {
                try {
                    System.out.print("\nIngrese el monto a retirar (mínimo de 100 pesos): ");
                    double retiro = scanner.nextDouble();

                    if (retiro < 100) {
                        System.out.println("El retiro debe ser minimo de 100 pesos");
                    } else {
                        if (clienteEnSession.getTarjetaDebito().getSaldo() >= retiro) {
                            clienteEnSession.getTarjetaDebito().setSaldo(clienteEnSession.getTarjetaDebito().getSaldo() - retiro);
                            System.out.println("Retiro exitoso");
                            return;
                        } else {
                            System.out.println("El monto del retiro es mayor a tu saldo");
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("TDato erroneo");
                }
            }
        }
    }

    public  void comparDebito(Cliente clienteEnSesion) {
        while (true) {
            if (clienteEnSesion.getTarjetaDebito().getSaldo() == 0) {
                System.out.println("Saldo insufuciente en la tarjeta");
                return;
            } else {
                try {
                    System.out.print("\nMonto a comprar: ");
                    double compra = scanner.nextDouble();

                    if (clienteEnSesion.getTarjetaDebito().getSaldo() >= compra) {
                        clienteEnSesion.getTarjetaDebito().compra(compra);
                        System.out.println("Compra realizada con exito");
                        return;
                    } else {
                        System.out.println("No cuentas con el saldo suficiente para realizar la compra");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Saldo insuficiente");
                }
            }
        }
    }

    public void comprarCredito(Cliente clienteEnSesion) {
        while (true) {
            if (clienteEnSesion.getTarjetaCredito().getLimiteDeCredito() == 0) {
                System.out.println("Tarjeta sobrejirada");
            } else {
                try {
                    System.out.print("\nIngrese el monto de la compra: ");
                    double compra = scanner.nextDouble();

                    if (clienteEnSesion.getTarjetaCredito().getLimiteDeCredito() >= compra) {
                        clienteEnSesion.getTarjetaCredito().limiteDeCredito(compra);
                        System.out.println("Compra realizada con exito");
                        return;
                    } else {
                        System.out.println("No cuentas con el saldo suficiente para realizar la compra");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Saldo insuficiente");
                }
            }
        }
    }

    public void abonarADeuda(Cliente clienteEnSesion) {
        while (true) {
            try {
                System.out.print("\nCuanto deseas abonar a credito?: ");
                double abonar = scanner.nextDouble();

                if (clienteEnSesion.getTarjetaCredito().getDeudaCredito() <= abonar) {
                    clienteEnSesion.getTarjetaCredito().abonarADeuda(abonar);
                    System.out.println("Abono exitoso");
                    return;
                } else {
                    System.out.println("El abono es mayor a la deuda existente");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Dato erroneo");
            }
        }
    }
}
