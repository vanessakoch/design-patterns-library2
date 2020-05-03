package com.vanessa.library2.controller;

public class Moeda10Centavos extends ProcessadorCaixa {
	private int quantidadeMoeda;
	private double resto;

	public Moeda10Centavos(ProcessadorCaixa proximo) {
		super(proximo);
	}

	@Override
	protected void processaDinheiro(double valor) {
		quantidadeMoeda = (int) (valor / 0.10);
		resto = valor % 0.10;
		proximo.processaDinheiro(resto);
		System.out.println("Entrada de 10 centavos: " + quantidadeMoeda);
	}

}
