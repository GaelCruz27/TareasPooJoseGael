package Ejercicio3;

public class CalculadoraImpuestos {
    
        public double calcImp(int ingresos) {
            return ingresos + 0.15;
        }
    
        public double calcImp(int ingresos, double porcentajeImpuestos) {
            return ingresos * (porcentajeImpuestos / 100);
        }
    
        public double calcImp(double dividendos, double porcentajeImpuestos, double exencion) {
            double impuestos = dividendos * (porcentajeImpuestos / 100);
            if (impuestos > exencion) {
                return impuestos - exencion;
            } else {
                return 0;
            }
        }
}
