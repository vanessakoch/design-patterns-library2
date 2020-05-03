package com.vanessa.library2.entities;

import java.util.List;

public class EmprestimoComposto implements EmprestimoLivro {
	private List<EmprestimoLivro> livrosList;
	private double taxaComposicao;

	public EmprestimoComposto(List<EmprestimoLivro> livrosList, double taxaComposicao) {
		this.livrosList = livrosList;
	}

	public double getTaxaAtraso() {
		double taxa = 0;

		for (EmprestimoLivro l : livrosList) {
			taxa += l.getTaxaAtraso();
		}

		return taxa + taxaComposicao;
	}

	public double getPeso() {
		double peso = 0;

		for (EmprestimoLivro l : livrosList) {
			peso += l.getPeso();
		}

		return peso;
	}

	public List<EmprestimoLivro> getLivrosList() {
		return livrosList;
	}

	public double getTaxaComposicao() {
		return taxaComposicao;
	}

	@Override
	public String toString() {
		for (EmprestimoLivro l : livrosList) {
			System.out.println(l);
		}
		return "";

	}

}
