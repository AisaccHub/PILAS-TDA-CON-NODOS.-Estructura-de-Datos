package Back_End;

public class Node {
    public Vinyl dato;
    public Node next;

    // Cambiamos 'Vinyl Vinyl' a 'Vinyl vinyl' con minúscula
    public Node(Vinyl vinyl) {
        this.dato = vinyl;
        this.next = null;
    }
}