package com.vanessa.library2.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library2.entities.Bibliotecario;
import com.vanessa.library2.entities.PessoaFisica;

public class BibliotecarioDAO {
	public static List<Bibliotecario> bibliotecariosList = new ArrayList<Bibliotecario>();

	public static void addBibliotecarios() {
		
		PessoaFisica bibliotecario1 = new Bibliotecario(7, "Maria", "emprestimo");
		PessoaFisica bibliotecario2 = new Bibliotecario(8, "Joao","devolucao");
		
		bibliotecariosList.add((Bibliotecario) bibliotecario1);
		bibliotecariosList.add((Bibliotecario) bibliotecario2);

	}

	public static Bibliotecario getBibliotecario(String nome) {

		for (Bibliotecario bibliotecario : bibliotecariosList) {
			if (nome.equalsIgnoreCase(bibliotecario.getNome()))
				return bibliotecario;
		}
		return null;
	}
	
	public static void getBibliotecarios() {
		for(Bibliotecario bibliotecario : bibliotecariosList) {
			System.out.println(bibliotecario);
		}
	}
}
