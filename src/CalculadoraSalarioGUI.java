import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSalarioGUI extends JFrame {
    private JTextField nombreField;
    private JTextField salarioHoraField;
    private JTextField horasTrabajadasField;
    private JLabel resultadoLabel;

    public CalculadoraSalarioGUI() {
        setTitle("Calculadora de Salario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(10);

        JLabel salarioHoraLabel = new JLabel("Salario básico por hora:");
        salarioHoraField = new JTextField(10);

        JLabel horasTrabajadasLabel = new JLabel("Horas trabajadas en el mes:");
        horasTrabajadasField = new JTextField(10);

        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                double salarioHora = Double.parseDouble(salarioHoraField.getText());
                int horasTrabajadas = Integer.parseInt(horasTrabajadasField.getText());

                double salarioMensual = salarioHora * horasTrabajadas;

                if (salarioMensual > 450000) {
                    resultadoLabel.setText("Nombre: " + nombre + ", Salario mensual: $" + salarioMensual);
                } else {
                    resultadoLabel.setText("Nombre: " + nombre);
                }
            }
        });

        add(nombreLabel);
        add(nombreField);
        add(salarioHoraLabel);
        add(salarioHoraField);
        add(horasTrabajadasLabel);
        add(horasTrabajadasField);
        add(calcularButton);
        add(resultadoLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraSalarioGUI();
            }
        });
    }
}

