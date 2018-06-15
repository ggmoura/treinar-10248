package br.com.treinar.bb.model.banco;

import java.util.Calendar;

public class ContaPoupanca extends Conta {

	private static float taxaRendimento;
	private int diaUltimoDeposito;
	
	static {
		taxaRendimento = 0.02f;
	}

	public static float getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(float taxaRendimento) {
		ContaPoupanca.taxaRendimento = taxaRendimento;
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

	@Override
	public String toString() {
		return super.toString() + " " + "ContaPoupanca [diaUltimoDeposito=" + diaUltimoDeposito + "]";
	}

}
