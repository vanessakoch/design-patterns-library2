package com.vanessa.library2.controller;

public class Moeda25Centavos extends ProcessadorCaixa{
	private int quantidadeMoeda;
	private double resto;
	
	public Moeda25Centavos(ProcessadorCaixa proximo) {
		super(proximo);
	}

	@Override
	protected void processaDinheiro(double valor) {
		quantidadeMoeda = (int)(valor/0.25);
		resto = valor % 0.25;
		proximo.processaDinheiro(resto);
		System.out.println("Entrada de 25 centavos: " + quantidadeMoeda);		
	}

}
