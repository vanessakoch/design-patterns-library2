package com.vanessa.library2;

import java.util.Scanner;

import com.vanessa.library2.controller.DevolucaoController;
import com.vanessa.library2.controller.EmprestimoController;
import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAO;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.Livro;

public class Main {

	public static void main(String[] args) {
		Scanner t = new Scanner(System.in);
		
		LivroDAO.addLivros();
		AlunoDAO.addAlunos();
		BibliotecarioDAO.addBibliotecarios();
		
		while(true) {
			menu();
			int escolha = t.nextInt();
			
			switch(escolha) {
			
			case 1:
				System.out.println("\n[1] - Listar alunos");
				System.out.println("[2] - Listar bibliotecarios");
				System.out.println("[3] - Listar livros");
				int num = t.nextInt();
				
				switch(num) {
				
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
				System.out.println("Digite o nome do aluno: ");
				Aluno aluno = AlunoDAO.getAluno(t.next());
				System.out.println("Digite o nome do funcionario: ");
				Bibliotecario bibliotecario = BibliotecarioDAO.getBibliotecario(t.next());
				System.out.println("Digite o nome do livro: ");
				Livro livro = LivroDAO.getLivro(t.next());
				System.out.println("Digite os dias de empréstimo: ");
				int diasEmprestimo = t.nextInt();
				
				
				if(aluno != null && bibliotecario != null && livro != null) {
					if(bibliotecario.getFuncao().contentEquals("emprestimo")) {
						EmprestimoController emprestar = new EmprestimoController();
						emprestar.realizaEmprestimo(aluno, bibliotecario, livro, diasEmprestimo);
					}else {
						System.out.println("\nEste bibliotecário não tem permissão de realizar empréstimos.");
					}
				} else {
					System.out.println("\nAluno ou funcionário ou livro não existe!");
				}
				
				
				break;
				
			case 3:
				System.out.println("\nDigite o nome do aluno: ");
				String alunoDevolucao = t.next();
				System.out.println("Digite o nome do funcionario: ");
				String bibliotecarioDevolucao = t.next();
				System.out.println("Digite o nome do livro: ");
				String livroDevolucao = t.next();
				System.out.println("Digite quantos dias o aluno ficou com o livro");
				int dias = t.nextInt();
		
				DevolucaoController devolve = new DevolucaoController();
				devolve.devolverEmprestimo(alunoDevolucao, bibliotecarioDevolucao, livroDevolucao, dias);
		
				break;
				
			case 4:
				System.out.println("\nDigite o nome do aluno: ");
				Aluno alunoEmprestimos = AlunoDAO.getAluno(t.next());

				if(alunoEmprestimos != null) {
					
					System.out.println(alunoEmprestimos.getEmprestimosRealizados());
					
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
