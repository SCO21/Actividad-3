import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MayorValorGUI extends JFrame {
    private JTextField numerosField;
    private JLabel resultadoLabel;

    public MayorValorGUI() {
        setTitle("Encontrar el Mayor Valor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JLabel numerosLabel = new JLabel("Ingrese los números separados por comas:");
        numerosField = new JTextField();

        JButton encontrarButton = new JButton("Encontrar");
        resultadoLabel = new JLabel();

        encontrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numerosInput = numerosField.getText();
                String[] numerosArray = numerosInput.split(",");

                int mayorValor = Integer.MIN_VALUE;

                for (String numero : numerosArray) {
                    int num = Integer.parseInt(numero.trim());

                    if (num > mayorValor) {
                        mayorValor = num;
                    }
                }

                resultadoLabel.setText("El mayor valor es: " + mayorValor);
            }
        });

        add(numerosLabel);
        add(numerosField);
        add(encontrarButton);
        add(resultadoLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MayorValorGUI();
            }
        });
    }
}