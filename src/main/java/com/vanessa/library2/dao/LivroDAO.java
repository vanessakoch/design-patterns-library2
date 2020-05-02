package com.vanessa.library2.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library2.entities.Livro;

public class LivroDAO {
	public static List<Livro> livrosList = new ArrayList<Livro>();

	public static void addLivros() {
		livrosList.add(new Livro("Java", 3, "Stephen King", 2013));
		livrosList.add(new Livro("C++", 1,"Stephen King", 1977));
		livrosList.add(new Livro("Python", 1,"Stephen King", 1990));
		livrosList.add(new Livro("Ruby", 1,"Stephen King", 1975));
		livrosList.add(new Livro("JavaScript", 1,"Stephen King", 2011));
	}

	public static Livro getLivro(String nome) {
		for (Livro livro : livrosList) {
			if (nome.equalsIgnoreCase(livro.getNomeLivro()))
				return livro;
		}
		return null;
	}
	
	public static void getLivros() {
		for(Livro livro : livrosList) {
			System.out.println(livro);
		}
	}

}
