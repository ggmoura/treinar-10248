package br.com.treinar.bb.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.IProdutoPagavel;
import br.com.treinar.bb.model.banco.SaldoInsuficienteException;

public class BancoController {
	
	private Banco banco;

	public BancoController() {
		banco = new Banco();
		banco.setContas(new ArrayList<>());
	}

	public List<Conta> recuperarContas() {
		return banco.getContas();
	}
	
	public void criarConta(Conta conta) {
		this.banco.getContas().add(conta);
	}

	public void depositar(double valor, int posicao) {
		banco.getContas().get(posicao).depositar(valor);
	}

	public double recuperarSaldo(int posicao) {
		return banco.getContas().get(posicao).consultarSaldo();
	}

	public void sacar(double valor, int posicao) throws SaldoInsuficienteException {
		banco.getContas().get(posicao).sacar(valor);
	}

	public void alterarTaxaRendimento(float novaTaxa) {
		ContaPoupanca.setTaxaRendimento(novaTaxa);
	}

	public float recuperarTaxaRendimento() {
		return ContaPoupanca.getTaxaRendimento();
	}

	public void cobrarMensalidade() {
//		Conta[] contas = banco.getContas();
//		for (int i = 0; i < contas.length; i++) {
//			if (contas[i] instanceof IProdutoPagavel) {
//				((IProdutoPagavel) contas[i]).pagarValorMensalidade();			
//			}
//		}
		
//		Criando uma classe anonima
//		banco.getContas().forEach(new Consumer<Conta>() {
//			@Override
//			public void accept(Conta t) {
//				if (conta instanceof IProdutoPagavel) {
//					((IProdutoPagavel) conta).pagarValorMensalidade();
//				}
//			}
//		});
		
//		Utilizando expressao lambda
		banco.getContas().forEach(conta -> {
			if (conta instanceof IProdutoPagavel) {
				((IProdutoPagavel) conta).pagarValorMensalidade();
			}
		});
	}
}
