package Front_End;

import Back_End.CodigoPilas;
import javax.swing.JOptionPane;

 class Interfaz {
public static void main(String[] args) {
        // Instanciamos la clase del Back-End
        CodigoPilas pila = new CodigoPilas();



        // GUI: Mostramos un menú emergente para pedir la opción (1 o 2)
        String entrada = JOptionPane.showInputDialog(
            null,
            "--- MENÚ PRINCIPAL ---\n" +
            "1. Mostrar datos del Back-End\n" +
            "2. Apagar programa\n\n" +
            "Ingresa una opción (1 o 2):"
        );

        // Verificamos que el usuario no haya cerrado la ventana o presionado Cancelar
        if (entrada != null) {
            int opcion = Integer.parseInt(entrada);

            // Opción 1: Mostrar estado del Back-End
            if (opcion == 1) {
                String datosBackEnd = "--- ESTADO DEL BACK-END ---\n" +
                                      "Elemento en el Tope (Peek): " + pila.peek() + "\n" +
                                      "Cantidad de elementos (Size): " + pila.size() + "\n" +
                                      "¿La pila está vacía?: " + (pila.isEmpty() ? "Sí" : "No");

                JOptionPane.showMessageDialog(null, datosBackEnd);
            }

            // Opción 2: Cerrar/Apagar el programa
            if (opcion == 2) {
                JOptionPane.showMessageDialog(null, "Apagando el programa...");
                System.exit(0);
            }
        }
    }
}
