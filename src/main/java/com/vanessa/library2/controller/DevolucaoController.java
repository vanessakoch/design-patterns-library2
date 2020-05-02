package com.vanessa.library2.controller;

import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAO;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.Emprestimo;
import com.vanessa.library2.entities.Livro;


public class DevolucaoController {

	public void devolverEmprestimo(String pessoa, String bibliotecario, String livro, int diasDePosse) {
		
		Aluno alunoDevolve = AlunoDAO.getAluno(pessoa);
		Bibliotecario bibliotecarioDevolve = BibliotecarioDAO.getBibliotecario(bibliotecario);
		Livro livroDevolve = LivroDAO.getLivro(livro);

		if(alunoDevolve != null && bibliotecarioDevolve != null && livroDevolve != null) {
			for (int i = 0; i < alunoDevolve.getEmprestimosRealizados().size(); i++) {
				if (alunoDevolve.getEmprestimosRealizados().get(i).getLivro().getNomeLivro().equalsIgnoreCase(livroDevolve.getNomeLivro())) {
					alunoDevolve.getEmprestimosRealizados().remove(alunoDevolve.getEmprestimosRealizados().get(i));
					System.out.println("\nLivro devolvido com sucesso!");
				}
			}
		}
		
	}

	
}
