import java.io.*;
import java.util.Scanner;

public class GestorTareas {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int opcion=0;
    
            while(opcion!=3){
                System.out.println("***LIBRETA DE NOTAS***");
                System.out.println("1. AGREGAR TAREA");
                System.out.println("2. MOSTRAR LISTA TAREAS");
                System.out.println("3. TERMINAR");
                try{
                    opcion=sc.nextInt();
                    sc.nextLine();
                    switch(opcion){
                        case 1:
                            System.out.println("--INGRESA UNA TAREA--");
                            try (FileWriter writer = new FileWriter("ListaTareas.txt", true); BufferedWriter bw = new BufferedWriter(writer)){
                                System.out.print("INGRESE LA TAREA: ");
                                String tarea = sc.nextLine();
                                bw.write(tarea + "\n");
                            }catch (IOException e){
                                System.out.println("ERROR AL SOBREESCRIBIR EL ARCHIVO" + e.getMessage());
                            }
                            break;
    
                        case 2:
                            System.out.println("--LISTA TAREAS--");
                            try (BufferedReader read = new BufferedReader(new FileReader("ListaTareas.txt"))) {
                                String lectura;
                                while ((lectura = read.readLine()) != null) {
                                    System.out.println(lectura);
                                }
                            } catch (IOException e){
                                System.out.println("ERROR AL LEER EL ARCHIVO" + e.getMessage());
                            }
                            break;
    
                        case 3:
                            System.out.print("CERRANDO PROGRAMA . . .");
                            break;
    
                        default:
                            System.out.println("ERROR OPCION INVALIDA");
    
    
                    }
    
                }catch(Exception e){
                    System.out.println("Ingresa un numero por favor");
                    sc.nextLine();
    
                }
                System.out.println();
            }
    
            }
}
