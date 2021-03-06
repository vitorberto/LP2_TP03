package Cadastro;

import java.awt.*;

import javax.swing.*;

public class FormCadastro3 extends Frame {
	/* start components */
	// text fields
	private JTextField txtNumber = new JTextField();
	private JTextField txtNome = new JTextField();
	private JRadioButton fRadioButton = new JRadioButton("F");
	private JRadioButton mRadioButton = new JRadioButton("M");
	private JTextField txtAge = new JTextField();

	// buttons
	private JButton okButton = new JButton("OK");
	private JButton clearButton = new JButton("Limpar");
	private JButton showButton = new JButton("Mostrar");
	private JButton exiButton = new JButton("Sair");
	/* end components */

	private Pessoa umaPessoa = new Pessoa();
	private char selectedSex;

	public FormCadastro3(String title, int width, int height) {
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
		Panel painelSexo = new Panel(new GridLayout(1, 2));

		mRadioButton.addActionListener(e -> selectM());
		painelSexo.add(mRadioButton);

		fRadioButton.addActionListener(e -> selectF());
		painelSexo.add(fRadioButton);
		painelSuperior.add(painelSexo);

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
		String nome = txtNome.getText();
		char sexo = selectedSex;
		int idade = Integer.parseInt(txtAge.getText());

		umaPessoa.setNome(nome);
		umaPessoa.setSexo(sexo);
		umaPessoa.setIdade(idade);

		Pessoa.setKp();
	}

	public void selectF() {
		if (mRadioButton.isSelected())
			mRadioButton.setSelected(false);

		fRadioButton.setSelected(true);
		selectedSex = 'F';
	}

	public void selectM() {
		if (fRadioButton.isSelected())
			fRadioButton.setSelected(false);

		mRadioButton.setSelected(true);
		selectedSex = 'M';
	}

	public void clearForm() {
		txtAge.setText("");
		txtNome.setText("");

		if (fRadioButton.isSelected())
			fRadioButton.setSelected(false);

		if (mRadioButton.isSelected())
			mRadioButton.setSelected(false);
	}

	public void showData() {
		String response = "Nome: " + umaPessoa.getNome() + "\nSexo: " + Character.toUpperCase(umaPessoa.getSexo())
				+ "\nIdade: "
				+ umaPessoa.getIdade() + "\nkp: " + Pessoa.getKp();
		JOptionPane.showMessageDialog(this, response, "Dados da pessoa", JOptionPane.PLAIN_MESSAGE);
	}
}
