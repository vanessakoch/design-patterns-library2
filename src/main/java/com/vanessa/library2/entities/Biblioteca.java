package com.vanessa.library2.entities;

import com.vanessa.library2.dao.AlunoDAO;
import com.vanessa.library2.dao.BibliotecarioDAO;

public class Biblioteca extends PessoaJuridica {
	private String cnpj;
	private String endereco;
	private String inscricaoEstadual;
	private static Biblioteca biblioteca;

	private Biblioteca(int codigo, String razaoSocial) {
		super(codigo, razaoSocial);
	}

	private Biblioteca(int codigo, String razaoSocial, String cnpj) {
		super(codigo, razaoSocial);
		this.cnpj = cnpj;
	}

	public Biblioteca(int codigo, String razaoSocial, String cnpj, String endereco, String inscricaoEstadual) {
		super(codigo, razaoSocial);
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public static Biblioteca criaNomeCnpj(int codigo, String razaoSocial, String cnpj) {
		if (biblioteca != null) {
			biblioteca.setCodigo(codigo);
			biblioteca.setRazaoSocial(razaoSocial);
			biblioteca.setCnpj(cnpj);
			return biblioteca;
		}
		if (!validaCodigo(codigo))
			return null;
		if (!validaString(razaoSocial))
			return null;
		if (!validaCnpj(cnpj))
			return null;
		return new Biblioteca(codigo, razaoSocial, cnpj);
	}

	public static Biblioteca criaNomeEndereco(int codigo, String razaoSocial, String endereco) {
		if (biblioteca != null) {
			biblioteca.setCodigo(codigo);
			biblioteca.setRazaoSocial(razaoSocial);
			biblioteca.setEndereco(endereco);
			return biblioteca;
		}
		if (!validaCodigo(codigo))
			return null;
		if (!validaString(razaoSocial) || !validaString(endereco))
			return null;
		Biblioteca library = new Biblioteca(codigo, razaoSocial);
		library.setEndereco(endereco);
		return library;
	}

	public static Biblioteca criarNomeInscricao(int codigo, String razaoSocial, String inscricaoEstadual) {
		if (biblioteca != null) {
			biblioteca.setCodigo(codigo);
			biblioteca.setRazaoSocial(razaoSocial);
			biblioteca.setInscricaoEstadual(inscricaoEstadual);
			return biblioteca;
		}
		if (!validaCodigo(codigo))
			return null;
		if (!validaString(razaoSocial) || !validaString(inscricaoEstadual))
			return null;
		Biblioteca library = new Biblioteca(codigo, razaoSocial);
		library.setInscricaoEstadual(inscricaoEstadual);
		return library;
	}

	public static Biblioteca incluirTudo(int codigo, String razaoSocial, String cnpj, String endereco, String inscricaoEstadual) {
		if (biblioteca != null) {
			biblioteca.setCodigo(codigo);
			biblioteca.setRazaoSocial(razaoSocial);
			biblioteca.setCnpj(cnpj);
			biblioteca.setEndereco(endereco);
			biblioteca.setInscricaoEstadual(inscricaoEstadual);
			return biblioteca;
		}
		if (!validaCodigo(codigo))
			return null;
		if (!validaString(razaoSocial))
			return null;
		if (!validaCnpj(cnpj))
			return null;
		if (!validaString(endereco))
			return null;
		if (!validaString(inscricaoEstadual))
			return null;
		return new Biblioteca(codigo, razaoSocial, cnpj, endereco, inscricaoEstadual);
	}

	private static boolean validaString(String texto) {
		if (texto.contains(" "))
			return false;
		return true;
	}

	private static boolean validaCnpj(String num) {
		if (num.length() != 14) {
			return false;
		}
		return true;
	}

	private static boolean validaCodigo(int codigo) {
		for (Aluno aluno : AlunoDAO.alunosList) {
			if (aluno.getCodigo() == codigo)
				return false;
		}
		for (Bibliotecario bibliotecario : BibliotecarioDAO.bibliotecariosList) {
			if (bibliotecario.getCodigo() == codigo)
				return false;
		}
		if (codigo <= 0) {
			return false;
		}

		return true;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@Override
	public String toString() {
		return "Pessoa Jurídica - Razão Social: " + razaoSocial + ", Cnpj: " + cnpj + ", Endereço: "
				+ endereco + ", Inscrição Estadual: " + inscricaoEstadual + ".";
	}

}
