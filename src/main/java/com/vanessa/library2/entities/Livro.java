package com.vanessa.library2.entities;

import java.text.DecimalFormat;

public class Livro {
	private String nomeLivro;
	private String autor;
	private int ano;
	private int quantidade;
	private double taxaAtraso;
	private double peso;

	public Livro(String nomeLivro, String autor, int ano, double taxaAtraso, double peso) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.ano = ano;
		this.taxaAtraso = taxaAtraso;
		this.peso = peso;
		this.quantidade = 1;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getTaxaAtraso() {
		return taxaAtraso;
	}

	public double getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");

		return "Livro: " + nomeLivro + ", autor: " + autor + ", ano: " + ano + ", taxa de atraso: R$" 
			+ df.format(taxaAtraso) + ", peso: " + df.format(peso) + " kg";
	}
}
