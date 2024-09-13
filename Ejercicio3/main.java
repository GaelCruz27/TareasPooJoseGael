package Ejercicio3;

public class main {
    public static void calcular(String[] args) {
        CalculadoraImpuestos calc= new CalculadoraImpuestos();

        System.out.println("Impuestos (solo ingresos): " + calc.calcImp(1000));

        System.out.println("Impuestos (ingresos + porcentajeImpuestos): " + calc.calcImp(1000, 15));

        System.out.println("Impuestos (dividendos + porcentajeImpuestos + exención): " + calc.calcImp(1000.0, 15.0, 100.0));
    }
}

