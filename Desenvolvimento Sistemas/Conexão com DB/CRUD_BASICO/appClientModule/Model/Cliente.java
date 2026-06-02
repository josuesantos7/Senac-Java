package Model;

import java.time.LocalDate;

public class Cliente {
	private int id;
	private String nome;
	private char sexo;
	private LocalDate dtNascimento;
	
	public Cliente(String nome, char sexo, LocalDate dtNascimento) { // add depois int id
//		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
}