package com.vanessa.library2.controller;


public abstract class ProcessadorCaixa {
	
	protected ProcessadorCaixa proximo;
	
	public ProcessadorCaixa(ProcessadorCaixa proximo) {
		this.proximo = proximo;
	}

	protected abstract void processaDinheiro(double valor);
	
}
