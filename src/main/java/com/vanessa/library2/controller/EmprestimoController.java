package com.vanessa.library2.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAO;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.EmprestimoComposto;
import com.vanessa.library2.entities.EmprestimoSimples;
import com.vanessa.library2.entities.EmprestimoLivro;
import com.vanessa.library2.entities.Livro;

public class EmprestimoController {
	Scanner t = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");


	public void realizaEmprestimoSimples() {
		System.out.println("\nDigite o nome do aluno: ");
		Aluno alunoEmprestimo = AlunoDAO.getAluno(t.next());
		System.out.println("Digite o nome do funcionario: ");
		Bibliotecario bibliotecarioEmprestimo = BibliotecarioDAO.getBibliotecario(t.next());
		System.out.println("Digite o nome do livro: ");
		Livro livroEmprestimo = LivroDAO.getLivro(t.next());
		System.out.println("Digite os dias de empréstimo: ");
		int diasEmprestimo = t.nextInt();
		

		if (alunoEmprestimo != null && bibliotecarioEmprestimo != null && livroEmprestimo != null) {
			if (bibliotecarioEmprestimo.getFuncao().contentEquals("emprestimo")) {
				alunoEmprestimo.getEmprestimosRealizados().add(new EmprestimoSimples(alunoEmprestimo,
						bibliotecarioEmprestimo, livroEmprestimo, diasEmprestimo));

				System.out.println(livroEmprestimo);
				System.out.println("\nTaxa em caso de atraso: R$ " + df.format(livroEmprestimo.getTaxaAtraso())
				+ " por dia.\nPeso do livro: " + df.format(livroEmprestimo.getPeso()) + " kg.");
				System.out.println("\nEmpréstimo realizado com sucesso!");
				
			} else {
				System.out.println("Funcionário não permitido!");
			}
		} else {
			System.out.println("Funcionario, aluno ou livro não existe.");
		}
	}

	public void realizaEmprestimoComposto() {
		List<EmprestimoLivro> emprestimosList = new ArrayList<EmprestimoLivro>();

		System.out.println("\nDigite o nome do aluno: ");
		Aluno alunoEmprestimo = AlunoDAO.getAluno(t.next());
		System.out.println("Digite o nome do funcionario: ");
		Bibliotecario bibliotecarioEmprestimo = BibliotecarioDAO.getBibliotecario(t.next());

		while (true) {
			System.out.println("Digite o nome do livro: ");
			Livro livroEmprestimo = LivroDAO.getLivro(t.next());
			System.out.println("Digite os dias de empréstimo: ");
			int diasEmprestimo = t.nextInt();

			if (alunoEmprestimo != null && bibliotecarioEmprestimo != null && livroEmprestimo != null) {
				if (bibliotecarioEmprestimo.getFuncao().contentEquals("emprestimo")) {
					EmprestimoLivro emprestimo = new EmprestimoSimples(alunoEmprestimo, bibliotecarioEmprestimo,
							livroEmprestimo, diasEmprestimo);
					alunoEmprestimo.getEmprestimosRealizados().add((EmprestimoSimples) emprestimo);
					emprestimosList.add(emprestimo);
					System.out.println("\nAdicionado com sucesso.");
				}
			}

			System.out.println("\n[1] Emprestar mais um livro");
			System.out.println("[0] Concluir empréstimo");

			int saindo = t.nextInt();

			System.out.println();

			if (saindo == 0) {
				EmprestimoLivro composto = new EmprestimoComposto(emprestimosList, 10);
				System.out.println(composto);
				System.out.println("Taxa total em caso de atraso: R$ " + df.format(composto.getTaxaAtraso())
						+ " por dia.\nPeso total dos livros: " + df.format(composto.getPeso()) + " kg.");
				System.out.println("\nEmpréstimo realizado com sucesso!");

				break;
			}

		}

	}
}
