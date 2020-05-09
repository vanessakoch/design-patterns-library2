package com.vanessa.library2.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library2.entities.Aluno;

public class AlunoDAO {
	public static List<Aluno> alunosList = new ArrayList<Aluno>();

	public static void addAlunos() {

		alunosList.add(new Aluno(1,"Vanessa", "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno(2,"Felipe", "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno(3,"Ramon", "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno(4,"Leonardo", "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno(5,"Rojie", "Analise e Desenvolvimento de Sistemas"));
		alunosList.add(new Aluno(6,"Fernando", "Analise e Desenvolvimento de Sistemas"));

	}

	public static Aluno getAluno(String nome) {
		for (Aluno aluno : alunosList) {
			if (nome.equalsIgnoreCase(aluno.getNome()))
				return aluno;
		}
		return null;
	}
	
	public static void getAlunos() {
		for(Aluno aluno : alunosList) {
			System.out.println(aluno);
		}
	}
}
