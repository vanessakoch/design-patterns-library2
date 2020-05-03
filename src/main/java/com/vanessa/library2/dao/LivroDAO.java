package com.vanessa.library2.dao;

import java.util.ArrayList;
import java.util.List;

import com.vanessa.library2.entities.Livro;

public class LivroDAO {
	public static List<Livro> livrosList = new ArrayList<Livro>();

	public static void addLivros() {
		livrosList.add(new Livro("Java", "Stephen King", 2013, 0.8f, 1.0f));
		livrosList.add(new Livro("C++","Stephen King", 1977, 0.5f, 0.8f));
		livrosList.add(new Livro("Python","Stephen King", 1990, 0.3f, 0.5f));
		livrosList.add(new Livro("Ruby","Stephen King", 1975, 0.7f, 0.9f));
		livrosList.add(new Livro("JavaScript","Stephen King", 2011, 1.0f, 0.8f));
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
