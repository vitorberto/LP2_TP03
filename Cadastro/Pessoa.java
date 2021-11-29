package Cadastro;

public class Pessoa {
	protected static int kp = 0;
	protected String nome;
	protected char sexo;
	protected int idade;

	Pessoa() {
		this.nome = null;
		this.sexo = 0;
		this.idade = 0;
	}

	Pessoa(String nome, char sexo, int idade) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
	}

	public static void setKp() {
		Pessoa.kp++;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static int getKp() {
		return kp;
	}

	public String getNome() {
		return nome;
	}

	public char getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}
}
