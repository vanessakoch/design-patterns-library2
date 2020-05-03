package com.vanessa.library2.controller;

public class Moeda1Real extends ProcessadorCaixa {
	private int quantidadeMoeda;
	private double resto;

	public Moeda1Real(ProcessadorCaixa proximo) {
		super(proximo);
	}

	@Override
	protected void processaDinheiro(double valor) {
		quantidadeMoeda = (int) (valor / 1);
		resto = valor % 1;
		proximo.processaDinheiro(resto);
		System.out.println("Entrada de 1 Real: " + quantidadeMoeda);
	}

}
