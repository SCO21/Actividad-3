import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraSalarioEmpleado extends JFrame {
    private JTextField codigoField, nombresField, horasField, valorHoraField, retencionField;
    private JLabel codigoLabel, nombresLabel, horasLabel, valorHoraLabel, retencionLabel;
    private JButton calcularButton;

    public CalculadoraSalarioEmpleado() {
        setTitle("Calculadora de Salario");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        codigoLabel = new JLabel("Código:");
        codigoField = new JTextField(10);
        nombresLabel = new JLabel("Nombres:");
        nombresField = new JTextField(20);
        horasLabel = new JLabel("Horas trabajadas:");
        horasField = new JTextField(10);
        valorHoraLabel = new JLabel("Valor hora:");
        valorHoraField = new JTextField(10);
        retencionLabel = new JLabel("Retención (%):");
        retencionField = new JTextField(10);
        calcularButton = new JButton("Calcular");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(codigoLabel);
        panel.add(codigoField);
        panel.add(nombresLabel);
        panel.add(nombresField);
        panel.add(horasLabel);
        panel.add(horasField);
        panel.add(valorHoraLabel);
        panel.add(valorHoraField);
        panel.add(retencionLabel);
        panel.add(retencionField);
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSalario();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void calcularSalario() {
        try {
            int horasTrabajadas = Integer.parseInt(horasField.getText());
            double valorHora = Double.parseDouble(valorHoraField.getText());
            double retencion = Double.parseDouble(retencionField.getText());

            double salarioBruto = horasTrabajadas * valorHora;
            double retencionFuente = salarioBruto * (retencion / 100);
            double salarioNeto = salarioBruto - retencionFuente;

            JOptionPane.showMessageDialog(this,
                    "Código: " + codigoField.getText() + "\n" +
                            "Nombres: " + nombresField.getText() + "\n" +
                            "Salario Bruto: $" + salarioBruto + "\n" +
                            "Salario Neto: $" + salarioNeto,
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, ingresa valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraSalarioEmpleado();
            }
        });
    }
}