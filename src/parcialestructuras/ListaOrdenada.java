package parcialestructuras;

import java.util.Iterator;

/**
 *
 * @author USUARIO
 */
public class ListaOrdenada<Item extends Comparable<? super Item>> implements Iterable<Item> {

    Node primero;

    Estudiante buscar(Estudiante estudiante) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private class Node {

        Item item;
        Node next;

        //constructor
        private Node() {
            this.next = null;
            this.item = null;
        }

        private Node(Item item) {
            this.item = item;
            this.next = null;
        }

        String getNombre() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    }

    //COnstructor
    public ListaOrdenada() {
        primero = null;
    }

    //Metodos API
    public boolean isEmpty() {
        return primero == null;
    }

    public int size() {
        Node recorre = primero;
        return size(recorre);
    }

    //Adicionar un elemento a la lista ordenada, garantizando que siga ordenada
    public void add(Item item) {
        Node actual = null;
        //Inicializar el elemento a adicionar
        Node nuevo = new Node(item);
        //UNa lista ordenada es null
        if (primero == null) {
            //UNa lista con un elemento es una lista ordenada
            System.out.println("lista con un unico elemento");
            primero = nuevo;
            return;
        }
        actual = primero;
        //El nuevo elemento es el primero de la lista
        if (item.compareTo(actual.item) <= 0) {
            System.out.println("El nuevo elemento es ahora el primero de la lista");
            nuevo.next = primero;
            primero = nuevo;
            return;
        }
        //EL nuevo elemento se adiciona entre otros
        while (actual.next!=null && item.compareTo(actual.next.item) > 0) {
                actual = actual.next;
            }
        //Agregar el elemento entre actual y actual.next
        System.out.println("El nuevo elemento se adiciona entre dos nodos o al final");
        nuevo.next=actual.next;
        actual.next=nuevo;
        return;

    }
    
    public int countOccurrences(Item valor) {
        Node actual = primero;
        int count = 0;
        while (actual != null) {
          if (actual.item.equals(valor)) {
            count++;
          }
          actual = actual.next;
        }
        return count;
}
    
    public Node getPredecesor(Item valor) {
        Node actual = primero;
        Node predecesor = null;
        while (actual != null && !actual.item.equals(valor)) {
          predecesor = actual;
          actual = actual.next;
        }
        return predecesor;
}
    
    public Node getSucesor(Item valor) {
        Node actual = primero;
        while (actual != null && !actual.item.equals(valor)) {
          actual = actual.next;
        }
        return actual != null ? actual.next : null;
}

    public Item getMax() {
        Node actual = primero;
        Item max = actual.item;
        while (actual != null) {
          if (actual.item.compareTo(max) > 0) {
            max = actual.item;
          }
          actual = actual.next;
        }
        return max;
}

    public Item getMin() {
        Node actual = primero;
        Item min = actual.item;
        while (actual != null) {
          if (actual.item.compareTo(min) < 0) {
            min = actual.item;
          }
          actual = actual.next;
        }
        return min;
}

    public boolean equals(ListaOrdenada otraLista) {
        Node actual1 = this.primero;
        Node actual2 = otraLista.primero;
        while (actual1 != null && actual2 != null) {
          if (!actual1.item.equals(actual2.item)) {
            return false;
          }
          actual1 = actual1.next;
          actual2 = actual2.next;
        }
        return actual1 == null && actual2 == null;
}



    public int size(Node temp) {
        if (temp == null) {
            return 0;
        }
        return 1 + size(temp.next);
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        //Declarar un atributo que tenga la referencia al primero
        private Node actual = primero;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Item next() {
            Item item = actual.item;
            actual = actual.next;
            return item;
        }

    }

}