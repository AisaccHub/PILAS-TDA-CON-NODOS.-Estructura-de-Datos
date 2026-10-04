//Declaracion de nodos, para usarse depues en el codigo de la interfaz

public class Node {
    public Vinyl dato;
    public Node next;


    public Node(Vinyl vinyl) {
        this.dato = vinyl;
        this.next = null;
    }
}