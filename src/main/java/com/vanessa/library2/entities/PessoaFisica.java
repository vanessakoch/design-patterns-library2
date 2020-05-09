package com.vanessa.library2.entities;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisica extends Pessoa {
	protected String nome;
	private List<EmprestimoSimples> emprestimosRealizados = new ArrayList<EmprestimoSimples>();

	public PessoaFisica(int codigo, String nome) {
		super(codigo);
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa física - Nome: " + nome;
	}

}
