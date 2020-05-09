package com.vanessa.library2.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;
import com.vanessa.library2.dao.LivroDAODecorator;
import com.vanessa.library2.dao.LivroDAOInterface;
import com.vanessa.library2.entities.Aluno;
import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.EmprestimoSimples;
import com.vanessa.library2.entities.Livro;
import com.vanessa.library2.exceptions.LivroException;

public class DevolucaoController {
	Scanner t = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("0.00");

	public void devolverEmprestimo() throws LivroException {
		LivroDAOInterface dao = new LivroDAODecorator();

		System.out.println("\nDigite o nome do aluno: ");
		Aluno alunoDevolve = AlunoDAO.getAluno(t.next());
		System.out.println("Digite o nome do funcionario: ");
		Bibliotecario bibliotecarioDevolve = BibliotecarioDAO.getBibliotecario(t.next());
		System.out.println("Digite o nome do livro: ");
		Livro livroDevolve = dao.getLivro(t.next());
		System.out.println("Digite quantos dias o aluno ficou com o livro: ");
		int dias = t.nextInt();
		List<EmprestimoSimples> alunoEmprestimos = alunoDevolve.getEmprestimosRealizados();

		if (alunoDevolve != null && bibliotecarioDevolve != null && livroDevolve != null) {
			if (bibliotecarioDevolve.getFuncao().equalsIgnoreCase("devolucao")) {
				for (int i = 0; i < alunoEmprestimos.size(); i++) {
					Livro livroAlunoDevolve = alunoEmprestimos.get(i).getLivro();
					if (livroAlunoDevolve.getNomeLivro().equalsIgnoreCase(livroDevolve.getNomeLivro())) {
						if (dias > alunoEmprestimos.get(i).getDiasEmprestimo()) {
							int diasAtraso = dias - alunoEmprestimos.get(i).getDiasEmprestimo();
							double valorAtraso = (alunoEmprestimos.get(i).getTaxaAtraso() * diasAtraso);
							System.out.println("Deverá pagar R$ " + df.format(valorAtraso) + " de taxa de atraso.");
							System.out.println("Quanto dará de dinheiro?");
							double entrada = t.nextDouble();
							if(entrada >= valorAtraso) {
								double troco = entrada - valorAtraso;
								ProcessadorCaixa caixa = new Moeda1Real(
										new Moeda50Centavos(new Moeda25Centavos(new Moeda10Centavos(new Moeda5Centavos(null)))));
								System.out.println("\nProcessamento de caixa ...");
								caixa.processaDinheiro(valorAtraso);
								System.out.println("Recebeu troco de: R$ " + df.format(troco));
	
								alunoEmprestimos.remove(alunoEmprestimos.get(i));
								System.out.println("\nLivro devolvido com sucesso!");
							} else {
								System.out.println("Livro não devolvido, valor não suficiente!");
							}
							
						} else {
							alunoEmprestimos.remove(alunoEmprestimos.get(i));
							System.out.println("\nLivro devolvido com sucesso!");
						}
					} 
				}
			} else {
				System.out.println("Funcionário não permitido na devolução!");
			}
		} else {
			System.out.println("\nAluno, funcionário ou livro não existe!");
		}
	}
}
