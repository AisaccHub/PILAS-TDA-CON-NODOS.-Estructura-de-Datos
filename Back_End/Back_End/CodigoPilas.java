package Back_End;

public class CodigoPilas {
    public Node top;
    private int count;

    public CodigoPilas() {
        top = null;
        count = 0;
    }

    public void push(Vinyl vinyl) {
        Node temp = new Node(vinyl);
        temp.next = top;
        top = temp;
        count++;
    }

    public Vinyl pop() {
        if (isEmpty()) return null;
        Node temp = top;
        top = top.next;
        count--;
        return temp.dato;
    }

    public Vinyl peek() {
        if (isEmpty()) return null;
        return top.dato;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return count;
    }

    public void clear() {
        top = null;
        count = 0;
    }
}

