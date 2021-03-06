package com.vanessa.library2.entities;

public class EmprestimoSimples implements EmprestimoLivro {
	private PessoaFisica cliente;
	private Bibliotecario funcionario;
	private Livro livro;
	private int diasEmprestimo;

	public EmprestimoSimples(PessoaFisica cliente, Bibliotecario funcionario, Livro livro, int diasEmprestimo) {
		super();
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.livro = livro;
		this.diasEmprestimo = diasEmprestimo;
	}

	public PessoaFisica getCliente() {
		return cliente;
	}

	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getDiasEmprestimo() {
		return diasEmprestimo;
	}

	public void setDiasEmprestimo(int diasEmprestimo) {
		this.diasEmprestimo = diasEmprestimo;
	}

	public Bibliotecario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Bibliotecario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "" + livro;

	}

	public double getTaxaAtraso() {
		return livro.getTaxaAtraso();
	}

	public double getPeso() {
		return livro.getPeso();
	}

}
