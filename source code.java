import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public abstract class main extends JFrame {

    private JLabel weightLabel, heightLabel, bmiLabel, resultLabel;
    private JTextField weightField, heightField;
    private JButton calculateButton;

    public main() {
        super("BMI Calculator");

        weightLabel = new JLabel("Weight (kg):");
        heightLabel = new JLabel("Height (cm):");
        bmiLabel = new JLabel("BMI:");
        resultLabel = new JLabel();

        weightField = new JTextField(5);
        heightField = new JTextField(5);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(weightLabel);
        inputPanel.add(weightField);
        inputPanel.add(heightLabel);
        inputPanel.add(heightField);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));
        resultPanel.add(bmiLabel);
        resultPanel.add(resultLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);

        Container container = getContentPane();
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(resultPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        setSize(250, 150);
        setVisible(true);
    }

    private class CalculateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height / 100 * height / 100);

            resultLabel.setText(String.format("%.2f", bmi));

            if (bmi < 18.5) {
                resultLabel.setForeground(Color.BLUE);
                resultLabel.setText("Underweight");
            } else if (bmi < 25) {
                resultLabel.setForeground(Color.GREEN);
                resultLabel.setText("Normal");
            } else if (bmi < 30) {
                resultLabel.setForeground(Color.ORANGE);
                resultLabel.setText("Overweight");
            } else {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText("Obese");
            }
        }
    }

    public static void main(String[] args) {
        main bmiCalculator = new main() {};
        bmiCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
