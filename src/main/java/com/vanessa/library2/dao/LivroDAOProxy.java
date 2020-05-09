package com.vanessa.library2.dao;

import java.util.HashMap;
import java.util.Map;

import com.vanessa.library2.entities.Livro;
import com.vanessa.library2.exceptions.LivroException;

public class LivroDAOProxy implements LivroDAOInterface {
	private Map<String, Livro> livros;

	public LivroDAOProxy() throws LivroException {
		super();
		this.livros = new HashMap<String, Livro>();
		
		if(this.livros.isEmpty()) 
			adicionaLivro("Java", "Stephen King", 2013, 0.8f, 1.0f);
			adicionaLivro("C++","Stephen King", 1977, 0.5f, 0.8f);
			adicionaLivro("Python","Stephen King", 1990, 0.3f, 0.5f);
			adicionaLivro("Ruby","Stephen King", 1975, 0.7f, 0.9f);
			adicionaLivro("JavaScript","Stephen King", 2011, 1.0f, 0.8f);	
	}

	public void adicionaLivro(String nomeLivro, String autor, int ano, double taxaAtraso, double peso)
			throws LivroException {
		this.livros.put(nomeLivro, new Livro(nomeLivro, autor, ano, taxaAtraso, peso));
	}

	public void removeLivro(String nomeLivro) throws LivroException {
		this.livros.remove(nomeLivro);
	}

	public Livro getLivro(String nomeLivro) throws LivroException {
		return livros.get(nomeLivro);
	}

	public String getAll() throws LivroException {

		for (String key : livros.keySet()) {
			Livro value = livros.get(key);
			System.out.println(key + " = " + value);
		}
		
		return "A biblioteca não tem livros!";
	}

}
