package com.vanessa.library2.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	private int codigo;
	protected String nome;
	private List<Emprestimo> emprestimosRealizados = new ArrayList<Emprestimo>();


	public Pessoa( int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Emprestimo getEmprestimo(String nomeLivro) {
		for (Emprestimo livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}

	public List<Emprestimo> getEmprestimosRealizados() {
		return emprestimosRealizados;
	}
	
	public String getNome() {
		return nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome + ", código: " + codigo;
	}
	
}
