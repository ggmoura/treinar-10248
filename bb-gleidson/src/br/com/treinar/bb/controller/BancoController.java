package br.com.treinar.bb.controller;

import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;

public class BancoController {

	private Conta conta;
	
	public void criarConta(Conta conta) {
		this.conta = conta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void depositar(double valor) {
	}

	public double recuperarSaldo() {
		return conta.consultarSaldo();
	}

	public void sacar(double valor) {
		conta.sacar(valor);
	}

	public void alterarTaxaRendimento(float novaTaxa) {
		ContaPoupanca.setTaxaRendimento(novaTaxa);
	}

	public float recuperarTaxaRendimento() {
		return ContaPoupanca.getTaxaRendimento();
	}
}
