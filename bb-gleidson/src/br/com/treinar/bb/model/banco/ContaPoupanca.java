package br.com.treinar.bb.model.banco;

import java.util.Calendar;

public class ContaPoupanca extends Conta {

	private float taxaRendimento;
	private int diaUltimoDeposito;

	public float getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}

	public int getDiaUltimoDeposito() {
		return diaUltimoDeposito;
	}

	public void setDiaUltimoDeposito(int diaUltimoDeposito) {
		this.diaUltimoDeposito = diaUltimoDeposito;
	}

	@Override
	public void depositar(double valor) {
		setSaldo(getSaldo() + valor);
		diaUltimoDeposito = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

}
