package com.vanessa.library2.entities;

public class Aluno extends Pessoa {

	private String curso;

	public Aluno(int codigo, String nome, String curso) {
		super(codigo, nome);
		this.curso = curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		return "Aluno(a) " + nome + ", curso: " + curso;
	}

}
