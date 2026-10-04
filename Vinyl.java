

public class Vinyl {
    private int id;
    private String nombre;

    public Vinyl(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre;
    }
}