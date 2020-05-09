package com.vanessa.library2.dao;

import com.vanessa.library2.entities.Livro;
import com.vanessa.library2.exceptions.LivroException;

public interface LivroDAOInterface {

	public void adicionaLivro(String nomeLivro, String autor, int ano, double taxaAtraso, double peso)
			throws LivroException;

	public void removeLivro(String nomeLivro) throws LivroException;

	public Livro getLivro(String nomeLivro) throws LivroException;

	public String getAll() throws LivroException;
}
