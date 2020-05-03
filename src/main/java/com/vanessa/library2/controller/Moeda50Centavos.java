package com.vanessa.library2.controller;


public class Moeda50Centavos extends ProcessadorCaixa{
	private int quantidadeMoeda;
	private double resto;
	
	public Moeda50Centavos(ProcessadorCaixa proximo) {
		super(proximo);
	}

	@Override
	protected void processaDinheiro(double valor) {
		quantidadeMoeda = (int)(valor/0.50);
		resto = valor % 0.50;
		proximo.processaDinheiro(resto);
		System.out.println("Entrada de 50 centavos: " + quantidadeMoeda);		
	}

}
