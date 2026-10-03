package Front_End;

import Back_End.CodigoPilas;
import Back_End.Vinyl;
import Back_End.Node;

import javax.swing.*;
import java.awt.*;

public class CodigoDelInterfaz extends JFrame {
    private CodigoPilas pila = new CodigoPilas();
    
    private JTextField txtId = new JTextField(5);
    private JTextField txtNombre = new JTextField(10);
    private JTextArea areaPila = new JTextArea(10, 20);

    public CodigoDelInterfaz() {
        setTitle("TDA Pila - Gestión de Viniles");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Superior: Formulario de entrada
        JPanel panelFormulario = new JPanel();
        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);

        JButton btnPush = new JButton("Apilar (Push)");
        panelFormulario.add(btnPush);
        add(panelFormulario, BorderLayout.NORTH);

        // Panel Central: Visualización vertical de la Pila
        areaPila.setEditable(false);
        add(new JScrollPane(areaPila), BorderLayout.CENTER);

        // Panel Inferior: Botones de Operaciones
        JPanel panelBotones = new JPanel();
        JButton btnPop = new JButton("Desapilar (Pop)");
        JButton btnPeek = new JButton("Consultar Tope (Peek)");
        JButton btnClear = new JButton("Vaciar (Clear)");

        panelBotones.add(btnPop);
        panelBotones.add(btnPeek);
        panelBotones.add(btnClear);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnPush.addActionListener(e -> apilar());
        btnPop.addActionListener(e -> desapilar());
        btnPeek.addActionListener(e -> consultarTope());
        btnClear.addActionListener(e -> vaciar());

        setLocationRelativeTo(null);
    }

    private void apilar() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) throw new Exception("Nombre vacío");

            pila.push(new Vinyl(id, nombre));
            txtId.setText("");
            txtNombre.setText("");
            actualizarVista();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los campos del Vinyl.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void desapilar() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La pila está vacía. No se puede desapilar.", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            Vinyl p = pila.pop();
            JOptionPane.showMessageDialog(this, "Vinyl extraído: " + p);
            actualizarVista();
        }
    }

    private void consultarTope() {
        if (pila.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La pila está vacía.", "Atención", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Elemento en el tope: " + pila.peek());
        }
    }

    private void vaciar() {
        pila.clear();
        actualizarVista();
        JOptionPane.showMessageDialog(this, "La pila ha sido vaciada.");
    }

    private void actualizarVista() {
        areaPila.setText("--- TOPE DE LA PILA ---\n");
        Node actual = pila.top;
        while (actual != null) {
            areaPila.append("  ↓  " + actual.dato.toString() + "\n");
            actual = actual.next;
        }
        areaPila.append("--- FONDO DE LA PILA ---");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CodigoDelInterfaz().setVisible(true));
    }
}