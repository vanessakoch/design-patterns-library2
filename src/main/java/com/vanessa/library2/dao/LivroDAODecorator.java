package com.vanessa.library2.dao;

import com.vanessa.library2.entities.Livro;
import com.vanessa.library2.exceptions.LivroException;

public class LivroDAODecorator implements LivroDAOInterface {
	private static LivroDAOInterface livroDAO;

	private LivroDAOInterface getInstance() throws LivroException {
		if (livroDAO == null)
			livroDAO = new LivroDAOProxy();
		return livroDAO;
	}
	
	public void adicionaLivro(String nomeLivro, String autor, int ano, double taxaAtraso, double peso)
			throws LivroException {
		if (nomeLivro.isBlank() || autor.isBlank() && ano != 0 && peso != 0)
			throw new LivroException("Digite dados válidos para adicionar o livro!");
		getInstance().adicionaLivro(nomeLivro, autor, ano, taxaAtraso, peso);	
	}
	
	public void removeLivro(String nomeLivro) throws LivroException {
		if (nomeLivro.isBlank())
			throw new LivroException("Digite um nome de livro existente na biblioteca!");
		Livro livro = getInstance().getLivro(nomeLivro);
		if (livro == null)
			throw new LivroException("Digite um nome de livro que tenha na biblioteca!");		
		getInstance().removeLivro(nomeLivro);
	}

	public Livro getLivro(String nomeLivro) throws LivroException {
		if (nomeLivro.isBlank())
			throw new LivroException("Digite um nome de livro existente na biblioteca!");
		Livro livro = getInstance().getLivro(nomeLivro);
		if (livro == null)
			throw new LivroException("Digite um nome de livro que tenha na biblioteca!");
		return livro;
	}

	public String getAll() throws LivroException {
		return getInstance().getAll();
	}

}
