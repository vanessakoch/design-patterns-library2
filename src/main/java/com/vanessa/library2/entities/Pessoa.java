package com.vanessa.library2.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {
	private int codigo;
	protected String nome;
	private List<EmprestimoSimples> emprestimosRealizados = new ArrayList<EmprestimoSimples>();


	public Pessoa(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public EmprestimoSimples getEmprestimo(String nomeLivro) {
		for (EmprestimoSimples livro : emprestimosRealizados) {
			if (livro.getLivro().getNomeLivro().contentEquals(nomeLivro)) {
				return livro;
			}
		}
		return null;
	}

	public List<EmprestimoSimples> getEmprestimosRealizados() {
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
