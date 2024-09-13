package Ejercicio2;

public class main {
    public static void calcular(String[] args) {
        empleado empleado = new empleado();

        
        System.out.println("Salario base: " + empleado.calcularSalario(1000));

       
        System.out.println("Salario base + bonificación: " + empleado.calcularSalario(1000, 200));

        
        System.out.println("Salario base + bonificación + horas extras: " + empleado.calcularSalario(1000, 200, 10));
    }
}