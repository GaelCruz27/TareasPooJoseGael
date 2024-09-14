public class main {
    public static void escuela(String[] args) {
       
        Curso curso1 = new Curso("Matemáticas", "MAT101", "Dr. García");
        Curso curso2 = new Curso("Historia", "HIS202", "Prof. López");
        Curso curso3 = new Curso("Biología", "BIO303", "Dr. Fernández");

        Estudiante estudiante1 = new Estudiante("Juan Pérez", "E001");
        Estudiante estudiante2 = new Estudiante("María Gómez", "E002");

        estudiante1.agregarCurso(curso1);
        estudiante1.agregarCurso(curso2);

        estudiante2.agregarCurso(curso2);
        estudiante2.agregarCurso(curso3);

        estudiante1.mostrarInformacion();
        System.out.println("-------------------");
        estudiante2.mostrarInformacion();
    }
}