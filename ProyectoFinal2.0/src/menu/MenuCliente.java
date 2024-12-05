package menu;

import tarjetas.Tarjeta;
import banco.Banco;
import usuarios.cliente.Cliente;
import tarjetas.Debito;
import tarjetas.Credito;

import java.util.Scanner;

public class MenuCliente {
    public Scanner scanner = new Scanner(System.in);
    public int mostrarMenu(Cliente clienteEnSesion) {
        System.out.println("\n== Bienvenido " + clienteEnSesion.getNombre() + " ==\n");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Tarjeta de debito.");
        System.out.println("3. Tarjeta de credito.");
        System.out.println("4. Salir.");

        try {
            System.out.print("Seleccione una opción: ");
            return scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de dato no solicitado");
            return 0;
        }
    }

    public boolean procesarDatos(int opcionCliente, Banco banco, Cliente clienteEnSesion) {
       switch (opcionCliente) {
           case 1:
               System.out.println("\n== Mi Información ==\n");
               System.out.println("\n" + clienteEnSesion.mostrarDatos());
               break;
           case 2:
               System.out.println("\n== Tarjeta De Débido ==\n");
               boolean opcion = true;
               while (opcion) {
                   System.out.println(clienteEnSesion.getTarjetaDebito().mostrarDatosTarjeta());

                   System.out.println("\n1. Depositar");
                   System.out.println("2. Retirar");
                   System.out.println("3. Comprar");
                   System.out.println("4. Salir");

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
                               System.out.println("No existe esa opcion");
                               break;
                       }
                   } catch (IllegalArgumentException e) {
                       System.out.println("Tipo de dato no solicitado");
                   }
               }
               break;
           case 3:
               System.out.println("\n== Tarjeta De Crédito ==\n");
               boolean opcionC = true;
               while (opcionC) {
                   if (clienteEnSesion.getTarjetaCredito() != null) {
                       System.out.println(clienteEnSesion.getTarjetaCredito().mostrarDatosTarjeta());

                       System.out.println("\n1. Comprar");
                       System.out.println("2. Abonar a deuda");
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
                                   System.out.println("No existe esa opción");
                                   break;
                           }
                       } catch (IllegalArgumentException e) {
                           System.out.println("Tipo de dato no soolicitado");
                       }
                   } else {
                       System.out.println("\nNo tienes una tarjeta de crédito asociada");
                       try {
                           System.out.print("\nSolicitar tarjeta de credito? (1 - Para sí, 2 - Para no): ");
                           int op = scanner.nextInt();

                           switch (op) {
                               case 1:
                                   System.out.println(banco.solicitarTarjetaCredito(clienteEnSesion));
                                   break;
                               case 2:
                                   break;
                               default:
                                   System.out.println("La opción no existe");
                           }
                       } catch (IllegalArgumentException e){
                           System.out.println("Tipo de dato no solicitado");
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
            System.out.println("Tipo de dato no solicitado");
        }
    }

    public void retirar(Cliente clienteEnSession) {
        while (true) {
            if (clienteEnSession.getTarjetaDebito().getSaldo() == 0) {
                System.out.println("No tienes saldo en tu tarjeta");
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
                    System.out.println("Tipo de dato no solicitado");
                }
            }
        }
    }

    public  void comparDebito(Cliente clienteEnSesion) {
        while (true) {
            if (clienteEnSesion.getTarjetaDebito().getSaldo() == 0) {
                System.out.println("No tienes saldo en tu tarjeta");
                return;
            } else {
                try {
                    System.out.print("\nIngrese el monto de la compra: ");
                    double compra = scanner.nextDouble();

                    if (clienteEnSesion.getTarjetaDebito().getSaldo() >= compra) {
                        clienteEnSesion.getTarjetaDebito().compra(compra);
                        System.out.println("Compra exitosa");
                        return;
                    } else {
                        System.out.println("El monto de la compra exede el saldo de la tarjeta");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de dato no solicitado");
                }
            }
        }
    }

    public void comprarCredito(Cliente clienteEnSesion) {
        while (true) {
            if (clienteEnSesion.getTarjetaCredito().getLimiteDeCredito() == 0) {
                System.out.println("No tienes más credito en tu tarjeta");
            } else {
                try {
                    System.out.print("\nIngrese el monto de la compra: ");
                    double compra = scanner.nextDouble();

                    if (clienteEnSesion.getTarjetaCredito().getLimiteDeCredito() >= compra) {
                        clienteEnSesion.getTarjetaCredito().limiteDeCredito(compra);
                        System.out.println("Compra exitosa");
                        return;
                    } else {
                        System.out.println("El monto de la compra exede el limite de crédito");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de dato no solicitado");
                }
            }
        }
    }

    public void abonarADeuda(Cliente clienteEnSesion) {
        while (true) {
            try {
                System.out.print("\nIngrese el monto a abonar: ");
                double abonar = scanner.nextDouble();

                if (clienteEnSesion.getTarjetaCredito().getDeudaCredito() <= abonar) {
                    clienteEnSesion.getTarjetaCredito().abonarADeuda(abonar);
                    System.out.println("Abono a deuda exitoso");
                    return;
                } else {
                    System.out.println("El abono es mayor a la deuda existente");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de dato no solicitado");
            }
        }
    }
}