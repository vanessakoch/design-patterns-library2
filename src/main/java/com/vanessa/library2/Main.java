package com.vanessa.library2;

import java.util.Scanner;

import com.vanessa.library2.controller.DevolucaoController;
import com.vanessa.library2.controller.EmprestimoController;
import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAO;
import com.vanessa.library2.entities.Aluno;

public class Main {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);

		LivroDAO.addLivros();
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
					LivroDAO.getLivros();
					break;

				default:
					break;
				}
				break;

			case 2:
				System.out.println("[1] Emprestar um livro");
				System.out.println("[2] Emprestar mais livros");
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
				System.out.println("\nDigite o nome do aluno: ");
				Aluno alunoEmprestimos = AlunoDAO.getAluno(t.next());

				if (alunoEmprestimos != null) {
					for (int i = 0; i < alunoEmprestimos.getEmprestimosRealizados().size(); i++) {
						System.out.println(alunoEmprestimos.getEmprestimosRealizados().get(i));
					}

				} else {

					System.out.println("Aluno não existe na base de dados!");
				}

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
		System.out.println("[4] - Pesquisar empréstimos por nome\n");
	}

}
