package com.vanessa.library2.controller;

public class Moeda5Centavos extends ProcessadorCaixa {
	private int quantidadeMoeda;

	public Moeda5Centavos(ProcessadorCaixa proximo) {
		super(proximo);
	}

	@Override
	protected void processaDinheiro(double valor) {
		quantidadeMoeda = (int) (valor / 0.05);
		System.out.println("Entrada de 5 centavos: " + quantidadeMoeda);
	}

}
