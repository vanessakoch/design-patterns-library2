package com.vanessa.library2.controller;

import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.Emprestimo;
import com.vanessa.library2.entities.Livro;
import com.vanessa.library2.entities.Pessoa;

public class EmprestimoController {

	public void realizaEmprestimo(Pessoa aluno, Bibliotecario funcionario, Livro livro, int diasEmprestimo) {
		aluno.getEmprestimosRealizados().add(new Emprestimo(aluno, funcionario, livro, diasEmprestimo));
		System.out.println("\nEmpréstimo realizado com sucesso!");
	}
	
	
}
