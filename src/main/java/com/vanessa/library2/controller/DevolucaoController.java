package com.vanessa.library2.controller;

import java.util.Scanner;

import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAO;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.EmprestimoSimples;
import com.vanessa.library2.entities.Livro;

public class DevolucaoController {

	public void devolverEmprestimo() {
		Scanner t = new Scanner(System.in);
		
		System.out.println("\nDigite o nome do aluno: ");
		Aluno alunoDevolve = AlunoDAO.getAluno(t.next());
		System.out.println("Digite o nome do funcionario: ");
		Bibliotecario bibliotecarioDevolve = BibliotecarioDAO.getBibliotecario(t.next());
		System.out.println("Digite o nome do livro: ");
		Livro livroDevolve = LivroDAO.getLivro(t.next());
		System.out.println("Digite quantos dias o aluno ficou com o livro");
		int dias = t.nextInt();
		
		if (alunoDevolve != null && bibliotecarioDevolve != null && livroDevolve != null) {
			for (int i = 0; i < alunoDevolve.getEmprestimosRealizados().size(); i++) {
				if (alunoDevolve.getEmprestimosRealizados().get(i).getLivro().getNomeLivro()
						.equalsIgnoreCase(livroDevolve.getNomeLivro())) {
					alunoDevolve.getEmprestimosRealizados().remove(alunoDevolve.getEmprestimosRealizados().get(i));
					System.out.println("\nLivro devolvido com sucesso!");
				}
			}
		}

	}

}
