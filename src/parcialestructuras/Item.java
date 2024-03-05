package parcialestructuras;

/**
*
*@autor linan
*/

 public class Item{



  public static void main(String[] args) {
    ListaOrdenada estudiantes = new ListaOrdenada();

    estudiantes.add((Comparable) new Estudiante("Ana", "Ingeniería", 2023, 1));
    estudiantes.add((Comparable) new Estudiante("Juan", "Derecho", 2024, 2));
    estudiantes.add((Comparable) new Estudiante("María", "Medicina", 2023, 1));
    estudiantes.add((Comparable) new Estudiante("Pedro", "Ingeniería", 2023, 1));

    System.out.println("Tamaño de la lista: " + estudiantes.size());

    Estudiante estudianteEncontrado = estudiantes.buscar(new Estudiante("María", "", 0, 0));
    if (estudianteEncontrado != null) {
      System.out.println("Estudiante encontrado: " + estudianteEncontrado.getNombre());
    } else {
      System.out.println("Estudiante no encontrado");
    }

    System.out.println("Lista ordenada:");
    for (Object estudiante : estudiantes) {
      System.out.println(estudiante);
    }

    int numOcurrencias = estudiantes.countOccurrences((Comparable) new Estudiante("Pedro", "", 0, 0));
    System.out.println("Número de estudiantes con el nombre 'Pedro': " + numOcurrencias);

    Estudiante predecesor = estudiantes.getPredecesor(new Estudiante("Juan", "", 0, 0));
    if (predecesor != null) {
      System.out.println("Predecesor de 'Juan': " + predecesor.getNombre());
    } else {
      System.out.println("No hay predecesor para 'Juan'");
    }

    Estudiante sucesor = estudiantes.getSucesor((Comparable) new Estudiante("María", "", 0, 0));
    if (sucesor != null) {
      System.out.println("Sucesor de 'María': " + sucesor.getNombre());
    } else {
      System.out.println("No hay sucesor para 'María'");
    }

    Estudiante mejorEstudiante = (Estudiante) estudiantes.getMax();
    System.out.println("Mejor estudiante: " + mejorEstudiante.getNombre());

    Estudiante peorEstudiante = (Estudiante) estudiantes.getMin();
    System.out.println("Peor estudiante: " + peorEstudiante.getNombre());

    ListaOrdenada otraLista = new ListaOrdenada();
    otraLista.add((Comparable) new Estudiante("Ana", "Ingeniería", 2023, 1));
    otraLista.add((Comparable) new Estudiante("Juan", "Derecho", 2024, 2));
    boolean sonIguales = estudiantes.equals(otraLista);
    System.out.println("Las listas son iguales: " + sonIguales);
  }
}
