import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraNumerosGUI extends JFrame {
    private JTextField numerosField;
    private JTextArea resultadosArea;

    public CalculadoraNumerosGUI() {
        setTitle("Calculadora de Números");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel numerosLabel = new JLabel("Ingrese los números separados por comas:");
        numerosField = new JTextField();

        JButton calcularButton = new JButton("Calcular");
        resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numerosInput = numerosField.getText();
                String[] numerosArray = numerosInput.split(",");

                StringBuilder resultados = new StringBuilder();

                for (String numero : numerosArray) {
                    int num = Integer.parseInt(numero.trim());
                    double raizCuadrada = Math.sqrt(num);
                    int cuadrado = num * num;
                    int cubo = num * num * num;

                    resultados.append("Número: ").append(num).append("\n");
                    resultados.append("Raíz cuadrada: ").append(raizCuadrada).append("\n");
                    resultados.append("Cuadrado: ").append(cuadrado).append("\n");
                    resultados.append("Cubo: ").append(cubo).append("\n");
                    resultados.append("------------------------").append("\n");
                }

                resultadosArea.setText(resultados.toString());
            }
        });

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(numerosLabel, BorderLayout.NORTH);
        panelSuperior.add(numerosField, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        add(calcularButton, BorderLayout.CENTER);
        add(resultadosArea, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraNumerosGUI();
            }
        });
    }
}