import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraEcuacionGUI extends JFrame {
    private JTextField valorAField;
    private JTextField valorBField;
    private JTextField valorCField;
    private JLabel solucionesLabel;

    public CalculadoraEcuacionGUI() {
        setTitle("Calculadora de Ecuación de Segundo Grado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel valorALabel = new JLabel("Valor A:");
        valorAField = new JTextField(10);

        JLabel valorBLabel = new JLabel("Valor B:");
        valorBField = new JTextField(10);

        JLabel valorCLabel = new JLabel("Valor C:");
        valorCField = new JTextField(10);

        JButton calcularButton = new JButton("Calcular");
        solucionesLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(valorAField.getText());
                double b = Double.parseDouble(valorBField.getText());
                double c = Double.parseDouble(valorCField.getText());

                double discriminante = b * b - 4 * a * c;

                if (discriminante > 0) {
                    double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                    solucionesLabel.setText("Soluciones: x1 = " + x1 + ", x2 = " + x2);
                } else if (discriminante == 0) {
                    double x = -b / (2 * a);
                    solucionesLabel.setText("Solución única: x = " + x);
                } else {
                    solucionesLabel.setText("No existen soluciones reales");
                }
            }
        });

        add(valorALabel);
        add(valorAField);
        add(valorBLabel);
        add(valorBField);
        add(valorCLabel);
        add(valorCField);
        add(calcularButton);
        add(solucionesLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraEcuacionGUI();
            }
        });
    }
}

