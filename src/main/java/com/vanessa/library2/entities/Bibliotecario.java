package com.vanessa.library2.entities;

public class Bibliotecario extends PessoaFisica {
	private String funcao;

	public Bibliotecario(int codigo, String nome, String funcao) {
		super(codigo, nome);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Bibliotecario(a) " + nome + ", função: " + funcao;
	}


}
