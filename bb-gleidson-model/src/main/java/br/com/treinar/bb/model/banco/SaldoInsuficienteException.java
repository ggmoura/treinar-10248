package br.com.treinar.bb.model.banco;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 2L;

	private Double saldoAtual;

	public Double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(Double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

}
