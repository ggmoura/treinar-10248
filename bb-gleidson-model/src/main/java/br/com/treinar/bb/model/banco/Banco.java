package br.com.treinar.bb.model.banco;

import java.util.List;

public class Banco {

	public static final int TEMPO_FUNCIONAMENTO;
	private List<Conta> contas;

	static {
		TEMPO_FUNCIONAMENTO = 10;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
