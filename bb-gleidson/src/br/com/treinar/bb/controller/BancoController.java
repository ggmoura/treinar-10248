package br.com.treinar.bb.controller;

import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.IProdutoPagavel;

public class BancoController {

	private int posicao;
	private Banco banco;
	
	public BancoController() {
		posicao = 0;
		banco = new Banco();
		Conta[] contas = new Conta[10];
		banco.setContas(contas);
	}

	public Conta[] recuperarContas() {
		return banco.getContas();
	}
	
	public void criarConta(Conta conta) {
		if (posicao < banco.getContas().length) {
			this.banco.getContas()[posicao++] = conta;			
		}
	}

	public void depositar(double valor, int posicao) {
		banco.getContas()[posicao].depositar(valor);
	}

	public double recuperarSaldo(int posicao) {
		return banco.getContas()[posicao].consultarSaldo();
	}

	public boolean sacar(double valor, int posicao) {
		return banco.getContas()[posicao].sacar(valor);
	}

	public void alterarTaxaRendimento(float novaTaxa) {
		ContaPoupanca.setTaxaRendimento(novaTaxa);
	}

	public float recuperarTaxaRendimento() {
		return ContaPoupanca.getTaxaRendimento();
	}

	public void cobrarMensalidade() {
		Conta[] contas = banco.getContas();
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] instanceof IProdutoPagavel) {
				((IProdutoPagavel) contas[i]).pagarValorMensalidade();			
			}
		}
		
	}
}
