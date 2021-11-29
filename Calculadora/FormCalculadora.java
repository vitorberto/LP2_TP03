package Calculadora;

import java.awt.*;

import javax.swing.*;

public class FormCalculadora extends Frame {
	JTextField operationText = new JTextField();
	double n1 = 0, n2 = 0, result = 0;
	String operator;

	public FormCalculadora(String title, int width, int height) {
		super(title);
		setSize(width, height);
		setLayout(new BorderLayout());

		// Criando um listener para possibilitar o encerramento do processo
		addWindowListener(new FechaJanela());

		add(operationText, BorderLayout.PAGE_START);

		GridLayout layoutPainelInferior = new GridLayout(5, 4);
		Panel painelInferior = new Panel(layoutPainelInferior);
		JButton[] numberButtons = new JButton[10];

		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i] = new JButton(Integer.toString(i));
			numberButtons[i].addActionListener(e -> addToOperationText(((JButton) e.getSource()).getText()));
		}

		// Primeira linha
		painelInferior.add(numberButtons[7]);
		painelInferior.add(numberButtons[8]);
		painelInferior.add(numberButtons[9]);

		JButton divisionButton = new JButton("/");
		divisionButton.addActionListener(e -> setOperation(((JButton) e.getSource()).getText()));
		painelInferior.add(divisionButton);

		// Segunda Linha
		painelInferior.add(numberButtons[4]);
		painelInferior.add(numberButtons[5]);
		painelInferior.add(numberButtons[6]);

		JButton multiplicationButton = new JButton("*");
		multiplicationButton.addActionListener(e -> setOperation(((JButton) e.getSource()).getText()));
		painelInferior.add(multiplicationButton);

		// Terceira Linha
		painelInferior.add(numberButtons[1]);
		painelInferior.add(numberButtons[2]);
		painelInferior.add(numberButtons[3]);

		JButton minusButton = new JButton("-");
		minusButton.addActionListener(e -> setOperation(((JButton) e.getSource()).getText()));
		painelInferior.add(minusButton);

		// Segunda Linha
		painelInferior.add(numberButtons[0]);

		JButton dotButton = new JButton(".");
		dotButton.addActionListener(e -> addToOperationText(((JButton) e.getSource()).getText()));
		painelInferior.add(dotButton);

		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(e -> finishOperation());
		painelInferior.add(equalsButton);

		JButton plusButton = new JButton("+");
		plusButton.addActionListener(e -> setOperation(((JButton) e.getSource()).getText()));
		painelInferior.add(plusButton);

		// Última linha
		JButton clearButton = new JButton("C");
		clearButton.addActionListener(e -> clearCache());
		painelInferior.add(clearButton);

		add(painelInferior, BorderLayout.PAGE_END);
	}

	public void addToOperationText(String text) {
		String actualText = operationText.getText();
		if (text != ".")
			operationText.setText(actualText + text);
		else if (!actualText.contains("."))
			operationText.setText(actualText + text);
	}

	public void setOperation(String sign) {
		if (n1 == 0) {
			n1 = Double.parseDouble(operationText.getText());
			operationText.setText("");
			operator = sign;
		}
	}

	public void finishOperation() {
		try {
			if (n2 == 0)
				n2 = Double.parseDouble(operationText.getText());
			else
				n1 = Double.parseDouble(operationText.getText());

			switch (operator) {
				case "/":
					result = n1 / n2;
					break;
				case "*":
					result = n1 * n2;
					break;
				case "-":
					result = n1 - n2;
					break;
				case "+":
					result = n1 + n2;
					break;
			}

			operationText.setText(String.valueOf(result));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage() == "empty String") {
				JOptionPane.showMessageDialog(this, "Você não digitou nenhum número, tente novamente!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
			}

			clearCache();
		}
	}

	public void clearCache() {
		n1 = 0;
		n2 = 0;
		result = 0;
		operator = null;
		operationText.setText("");
	}
}
