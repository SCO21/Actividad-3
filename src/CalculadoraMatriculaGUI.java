import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraMatriculaGUI extends JFrame {
    private JTextField inscripcionField;
    private JTextField nombresField;
    private JTextField patrimonioField;
    private JTextField estratoField;
    private JLabel matriculaLabel;

    public CalculadoraMatriculaGUI() {
        setTitle("Calculadora de Matrícula");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        JLabel inscripcionLabel = new JLabel("Número de inscripción:");
        inscripcionField = new JTextField(10);

        JLabel nombresLabel = new JLabel("Nombres:");
        nombresField = new JTextField(10);

        JLabel patrimonioLabel = new JLabel("Patrimonio:");
        patrimonioField = new JTextField(10);

        JLabel estratoLabel = new JLabel("Estrato social:");
        estratoField = new JTextField(10);

        JButton calcularButton = new JButton("Calcular");
        matriculaLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int patrimonio = Integer.parseInt(patrimonioField.getText());
                int estrato = Integer.parseInt(estratoField.getText());

                int matricula = 50000; // Valor constante de matrícula

                if (patrimonio > 2000000 && estrato > 3) {
                    double incremento = patrimonio * 0.03;
                    matricula += incremento;
                }

                matriculaLabel.setText("Pago de matrícula: $" + matricula);
            }
        });

        add(inscripcionLabel);
        add(inscripcionField);
        add(nombresLabel);
        add(nombresField);
        add(patrimonioLabel);
        add(patrimonioField);
        add(estratoLabel);
        add(estratoField);
        add(calcularButton);
        add(matriculaLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraMatriculaGUI();
            }
        });
    }
}