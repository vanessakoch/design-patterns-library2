package com.vanessa.library2;

import java.util.List;
import java.util.Scanner;

import com.vanessa.library2.controller.DevolucaoController;
import com.vanessa.library2.controller.EmprestimoController;
import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAODecorator;
import com.vanessa.library2.dao.LivroDAOInterface;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.EmprestimoSimples;
import com.vanessa.library2.exceptions.LivroException;

public class Main {
	static Scanner t = new Scanner(System.in);

	public static void main(String[] args) throws LivroException {
		LivroDAOInterface daoLivros = new LivroDAODecorator();

		AlunoDAO.addAlunos();
		BibliotecarioDAO.addBibliotecarios();

		while (true) {
			menu();
			int escolha = t.nextInt();

			switch (escolha) {

			case 1:
				System.out.println("\n[1] - Listar alunos");
				System.out.println("[2] - Listar bibliotecarios");
				System.out.println("[3] - Listar livros");
				int num = t.nextInt();

				switch (num) {

				case 1:
					AlunoDAO.getAlunos();
					break;
				case 2:
					BibliotecarioDAO.getBibliotecarios();
					break;
				case 3:
					daoLivros.getAll();
					break;

				default:
					break;
				}
				break;

			case 2:
				System.out.println("[1] Emprestar apenas um livro");
				System.out.println("[2] Emprestar vários livros");
				int numero = t.nextInt();
				switch (numero) {

				case 1:
					EmprestimoController emprestar = new EmprestimoController();
					emprestar.realizaEmprestimoSimples();
					break;

				case 2:
					EmprestimoController emprestimoComposto = new EmprestimoController();
					emprestimoComposto.realizaEmprestimoComposto();
					break;

				default:
					break;
				}

				break;

			case 3:
				DevolucaoController devolve = new DevolucaoController();
				devolve.devolverEmprestimo();
				break;

			case 4:
				verEmprestimos();
				break;

			case 5:
				System.out.println("[1] - Adicionar livro");
				System.out.println("[2] - Remover livro");
				int number = t.nextInt();

				if (number == 1) 
					adicionaLivro();
				
				if (number == 2) 
					removerLivro();
				
				break;

			default:
				break;
			}

		}

	}

	public static void menu() {
		System.out.println("\n[1] - Listar cadastros");
		System.out.println("[2] - Emprestar livro");
		System.out.println("[3] - Devolver livro");
		System.out.println("[4] - Pesquisar empréstimos por nome");
		System.out.println("[5] - Gerencia livros\n");
	}

	public static void verEmprestimos() {
		System.out.println("\nDigite o nome do aluno: ");
		Aluno alunoEmprestimos = AlunoDAO.getAluno(t.next());
		List<EmprestimoSimples> seuEmprestimo = alunoEmprestimos.getEmprestimosRealizados();

		if (alunoEmprestimos != null && seuEmprestimo.size() > 0) {
			System.out.println("\nEmpréstimos de " + alunoEmprestimos.getNome() + ":");
			for (int i = 0; i < seuEmprestimo.size(); i++) {
				System.out.println(
						seuEmprestimo.get(i) + ", dias de empréstimo: " + seuEmprestimo.get(i).getDiasEmprestimo());
			}
		} else {
			System.out.println("\nAluno não existe ou não possui empréstimos!");
		}
	}

	public static void adicionaLivro() {
		LivroDAOInterface daoLivros = new LivroDAODecorator();
		System.out.println("\nDigite o nome do livro: ");
		String nomeLivro = t.next();
		System.out.println("Digite o autor: ");
		String autorLivro = t.next();
		System.out.println("Digite o ano: ");
		int anoLivro = t.nextInt();
		System.out.println("Digite a taxa que deverá ser paga em caso de atraso de empréstimo: ");
		double taxaLivro = t.nextDouble();
		System.out.println("Qual o peso do livro?");
		double pesoLivro = t.nextDouble();

		try {
			daoLivros.adicionaLivro(nomeLivro, autorLivro, anoLivro, taxaLivro, pesoLivro);
		} catch (LivroException e) {
			System.err.println("Não foi possível adicionar o livro.");
			System.err.println(e.getMessage());
		}
		System.out.println("Livro adicionado com sucesso!");

	}

	public static void removerLivro() {
		LivroDAOInterface daoLivros = new LivroDAODecorator();
		boolean livroEmprestado = false;
		System.out.println("Digite o nome do livro que deseja remover: ");
		String livroRemover = t.next();
		for (Aluno aluno : AlunoDAO.alunosList) {
			if (aluno.getEmprestimo(livroRemover) != null)
				livroEmprestado = true;

		}
		if (!livroEmprestado) {
			try {
				daoLivros.removeLivro(livroRemover);
				System.out.println("\nLivro removido com sucesso!");

			} catch (LivroException e) {
				System.err.println("Não foi possível remover este livro.");
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("\nEste livro está emprestado por algum aluno, não pode ser removido!");
		}

	}
}
