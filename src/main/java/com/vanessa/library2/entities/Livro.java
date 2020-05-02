package com.vanessa.library2.entities;

public class Livro {
	private String nomeLivro;
	private String autor;
	private int edicao;
	private int ano;
	private int quantidade;
    
	public Livro(String nomeLivro, int edicao, String autor, int ano) {
		super();
		this.nomeLivro = nomeLivro;
		this.edicao = edicao;
		this.autor = autor;
		this.ano = ano;
		this.quantidade = 1;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public String getAutorLivro() {
		return autor;
	}

	public Integer getAnoLivro() {
		return ano;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Livro " + nomeLivro + ", autor: " + autor + ", ano: " + ano;
	}

}
