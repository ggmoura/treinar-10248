package br.com.treinar.bb.controller;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.IProdutoPagavel;
import br.com.treinar.bb.model.banco.SaldoInsuficienteException;
import br.com.treinar.bb.util.BBUtil;

public class BancoController {
	
	private Banco banco;

	public BancoController() {
		banco = BBUtil.getInstance().getBanco();
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

	public CompletableFuture<Integer> cobrarMensalidade() {
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

//			Utilizando expressao lambda
//			new Thread(() -> {
//				try {
//					Thread.sleep(15000);
//					banco.getContas().forEach(conta -> {
//						if (conta instanceof IProdutoPagavel) {
//							((IProdutoPagavel) conta).pagarValorMensalidade();
//						}
//					});
//					System.out.println("Tarifou as contas");
//				} catch (Exception e) {
//					System.out.println("Erro ao processar");
//				}
//			}).start();
		//Utilizando completablefuture para que o metodo que chamar este metodo consiga
		//tratar o retorno, e nao seja necessario esperar a execucao
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			try {
				AtomicInteger count = new AtomicInteger(0);
				banco.getContas().forEach(conta -> {
					if (conta instanceof IProdutoPagavel) {
						count.incrementAndGet();
						((IProdutoPagavel) conta).pagarValorMensalidade();
					}
				});
				Thread.sleep(5000);
				return count.get();
			} catch (Exception e) {
				return null;
			}
		});
		return future;
	}

	public void excluirContaPorPosicao(int posicaoConta) {
		banco.getContas().remove(posicaoConta);
	}

	public void excluirContaPorNumero(int numeroConta) throws ContaInexistenteException {
		Iterator<Conta> iterator = banco.getContas().iterator();
		Conta c = null;
		while (iterator.hasNext()) {
			c = iterator.next();
			if (c.getNumero() == numeroConta) {
				iterator.remove();
				break;
			}
		}
		if (c == null) {
			throw new ContaInexistenteException();
		}
	}
}
