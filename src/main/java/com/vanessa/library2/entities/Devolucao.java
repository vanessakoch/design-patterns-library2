package com.vanessa.library2.entities;

public class Devolucao {
	private PessoaFisica cliente;
	private EmprestimoSimples emprestimo;
	private int diasPosse;

	public Devolucao(PessoaFisica cliente, EmprestimoSimples emprestimo, int diasPosse) {
		super();
		this.cliente = cliente;
		this.emprestimo = emprestimo;
		this.diasPosse = diasPosse;
	}

	public Devolucao() {
	}

	public PessoaFisica getCliente() {
		return cliente;
	}

	public void setCliente(PessoaFisica cliente) {
		this.cliente = cliente;
	}

	public EmprestimoSimples getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(EmprestimoSimples emprestimo) {
		this.emprestimo = emprestimo;
	}

	public int getDiasPosse() {
		return diasPosse;
	}

	public void setDiasPosse(int diasPosse) {
		this.diasPosse = diasPosse;
	}

}
