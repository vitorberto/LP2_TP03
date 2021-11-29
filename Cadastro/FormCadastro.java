package Cadastro;

import java.awt.*;

import javax.swing.*;

public class FormCadastro extends Frame {
	/* start components */
	// text fields
	private JTextField txtNumber = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtSex = new JTextField();
	private JTextField txtAge = new JTextField();

	// buttons
	private JButton okButton = new JButton("OK");
	private JButton clearButton = new JButton("Limpar");
	private JButton showButton = new JButton("Mostrar");
	private JButton exiButton = new JButton("Sair");
	/* end components */

	private Pessoa umaPessoa = new Pessoa();

	public FormCadastro(String title, int width, int height) {
		super(title);
		setSize(width, height);

		addWindowListener(new FechaJanela());

		GridLayout layoutSuperior = new GridLayout(4, 2);
		JPanel painelSuperior = new JPanel(layoutSuperior);

		GridLayout layoutInferior = new GridLayout(1, 4);
		JPanel painelInferior = new JPanel(layoutInferior);

		/* start painel superior */
		// numero input
		painelSuperior.add(new JLabel("Numero:"));
		txtNumber.setEnabled(false);
		painelSuperior.add(txtNumber);

		// name input
		painelSuperior.add(new JLabel("Nome:"));
		painelSuperior.add(txtNome);

		// sex input
		painelSuperior.add(new JLabel("Sexo:"));
		painelSuperior.add(txtSex);

		// age input
		painelSuperior.add(new JLabel("Idade:"));
		painelSuperior.add(txtAge);
		/* end painel superior */

		/* start painel inferior */
		okButton.addActionListener(e -> createPerson());
		painelInferior.add(okButton);

		clearButton.addActionListener(e -> clearForm());
		painelInferior.add(clearButton);

		showButton.addActionListener(e -> showData());
		painelInferior.add(showButton);

		exiButton.addActionListener(e -> this.dispose());
		painelInferior.add(exiButton);
		/* end painel inferior */

		add(painelSuperior, BorderLayout.PAGE_START);
		add(painelInferior, BorderLayout.PAGE_END);
	}

	public void createPerson() {
		char sexChar = Character.toLowerCase(txtSex.getText().charAt(0));
		if (sexChar == 'f' || sexChar == 'm') {
			String nome = txtNome.getText();
			char sexo = txtSex.getText().charAt(0);
			int idade = Integer.parseInt(txtAge.getText());

			umaPessoa.setNome(nome);
			umaPessoa.setSexo(sexo);
			umaPessoa.setIdade(idade);

			Pessoa.setKp();
		} else {
			JOptionPane.showMessageDialog(this, "Você não digitou um sexo válido", "Erro!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void clearForm() {
		txtAge.setText("");
		txtNome.setText("");
		txtSex.setText("");
	}

	public void showData() {
		String response = "Nome: " + umaPessoa.getNome() + "\nSexo: " + Character.toUpperCase(umaPessoa.getSexo())
				+ "\nIdade: "
				+ umaPessoa.getIdade() + "\nkp: " + Pessoa.getKp();
		JOptionPane.showMessageDialog(this, response, "Dados da pessoa", JOptionPane.PLAIN_MESSAGE);
	}
}
