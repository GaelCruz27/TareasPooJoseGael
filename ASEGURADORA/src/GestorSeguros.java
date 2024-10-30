public class GestorSeguros {
    public static void main(String[] args) {

        SeguroAuto seguroAuto1 = new SeguroAuto("Jose Gael", 35000.0, 19);
        SeguroAuto seguroAuto2 = new SeguroAuto("Nicole Serrano", 23000.0, 25);

        SeguroHogar seguroHogar1 = new SeguroHogar("Aramis Ayala", 124000.0, true);
        SeguroHogar seguroHogar2 = new SeguroHogar("Pepe Solis", 200000.0, false);

        SeguroVida seguroVida1 = new SeguroVida("Alberto Roberto", 40000.0, 30);
        SeguroVida seguroVida2 = new SeguroVida("Josefino Martinez", 130000.0, 68);


        System.out.println("=== DETALLES DE SEGUROS ===\n");

        System.out.println(seguroAuto1.detallesSeguro());
        System.out.println("\n-------------------------\n");
        System.out.println(seguroAuto2.detallesSeguro());
        System.out.println("\n-------------------------\n");

        System.out.println(seguroHogar1.detallesSeguro());
        System.out.println("\n-------------------------\n");
        System.out.println(seguroHogar2.detallesSeguro());
        System.out.println("\n-------------------------\n");

        System.out.println(seguroVida1.detallesSeguro());
        System.out.println("\n-------------------------\n");
        System.out.println(seguroVida2.detallesSeguro());
    }
}