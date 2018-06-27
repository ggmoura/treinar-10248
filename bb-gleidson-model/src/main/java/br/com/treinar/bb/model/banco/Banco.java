package br.com.treinar.bb.model.banco;

public class Banco {

	public static final int TEMPO_FUNCIONAMENTO;
	private Conta[] contas;

	static {
		TEMPO_FUNCIONAMENTO = 10;
	}

	public Conta[] getContas() {
		return contas;
	}

	public void setContas(Conta[] contas) {
		this.contas = contas;
	}

}
