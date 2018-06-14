package br.com.treinar.bb.controller;

import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.IProdutoPagavel;

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
		conta.depositar(valor);
	}

	public double recuperarSaldo() {
		return conta.consultarSaldo();
	}

	public boolean sacar(double valor) {
		return conta.sacar(valor);
	}

	public void alterarTaxaRendimento(float novaTaxa) {
		ContaPoupanca.setTaxaRendimento(novaTaxa);
	}

	public float recuperarTaxaRendimento() {
		return ContaPoupanca.getTaxaRendimento();
	}

	public void cobrarMensalidade() {
		if (conta instanceof IProdutoPagavel) {
			((IProdutoPagavel) conta).pagarValorMensalidade();			
		}
	}
}
