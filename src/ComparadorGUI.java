import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparadorGUI extends JFrame {
    private JLabel labelA, labelB, labelResultado;
    private JTextField campoA, campoB;
    private JButton botonComparar;

    public ComparadorGUI() {
        // Configuración de la ventana
        setTitle("Comparador de valores");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Creación de los componentes
        labelA = new JLabel("Valor A:");
        campoA = new JTextField();
        labelB = new JLabel("Valor B:");
        campoB = new JTextField();
        botonComparar = new JButton("Comparar");
        labelResultado = new JLabel("");

        // Agregar componentes a la ventana
        add(labelA);
        add(campoA);
        add(labelB);
        add(campoB);
        add(new JLabel()); // Espacio en blanco
        add(botonComparar);
        add(new JLabel()); // Espacio en blanco
        add(labelResultado);

        // Configuración del botón de comparar
        botonComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compararValores();
            }
        });
    }

    private void compararValores() {
        // Obtener los valores de los campos de texto
        int valorA = Integer.parseInt(campoA.getText());
        int valorB = Integer.parseInt(campoB.getText());

        // Comparar los valores
        if (valorA > valorB) {
            labelResultado.setText("A es mayor que B");
        } else if (valorA < valorB) {
            labelResultado.setText("A es menor que B");
        } else {
            labelResultado.setText("A es igual a B");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComparadorGUI gui = new ComparadorGUI();
                gui.setVisible(true);
            }
        });
    }
}
