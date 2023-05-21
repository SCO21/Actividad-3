import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrianguloEquilateroGUI extends JFrame implements ActionListener {
    private JTextField ladoTextField;
    private JLabel resultadoPerimetroLabel;
    private JLabel resultadoAlturaLabel;
    private JLabel resultadoAreaLabel;

    public TrianguloEquilateroGUI() {
        // Configurar la ventana
        setTitle("Cálculo de Triángulo Equilátero");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear los componentes
        JLabel ladoLabel = new JLabel("Lado:");
        ladoTextField = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);

        JLabel perimetroLabel = new JLabel("Perímetro:");
        resultadoPerimetroLabel = new JLabel();

        JLabel alturaLabel = new JLabel("Altura:");
        resultadoAlturaLabel = new JLabel();

        JLabel areaLabel = new JLabel("Área:");
        resultadoAreaLabel = new JLabel();

        // Configurar el diseño
        setLayout(new GridLayout(5, 2));
        add(ladoLabel);
        add(ladoTextField);
        add(calcularButton);
        add(new JLabel()); // Espacio en blanco
        add(perimetroLabel);
        add(resultadoPerimetroLabel);
        add(alturaLabel);
        add(resultadoAlturaLabel);
        add(areaLabel);
        add(resultadoAreaLabel);
    }

    public static void main(String[] args) {
        TrianguloEquilateroGUI gui = new TrianguloEquilateroGUI();
        gui.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calcular")) {
            // Obtener el valor del lado
            double lado = Double.parseDouble(ladoTextField.getText());

            // Calcular el perímetro
            double perimetro = lado * 3;
            resultadoPerimetroLabel.setText(String.valueOf(perimetro));

            // Calcular la altura
            double altura = Math.sqrt(3) / 2 * lado;
            resultadoAlturaLabel.setText(String.valueOf(altura));

            // Calcular el área
            double area = Math.sqrt(3) / 4 * lado * lado;
            resultadoAreaLabel.setText(String.valueOf(area));
        }
    }
}