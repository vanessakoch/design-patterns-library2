package com.vanessa.library2.entities;

public abstract class Pessoa {
	private int codigo;

	public Pessoa(int codigo) {
		super();
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
