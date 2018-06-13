package br.com.treinar.bb.model.banco;

public class ContaCorrente extends Conta {

	private double limiteCredito;
	private double limiteCreditoAtual;

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public double getLimiteCreditoAtual() {
		return limiteCreditoAtual;
	}

	public void setLimiteCreditoAtual(double limiteCreditoAtual) {
		this.limiteCreditoAtual = limiteCreditoAtual;
	}

	@Override
	public boolean sacar(double valor) {
		boolean deuParaSacar = true;
		if (valor <= getSaldo() + this.limiteCreditoAtual) {
			if (valor <= getSaldo()) {
				setSaldo(getSaldo() - valor);
			} else {
				limiteCreditoAtual = limiteCreditoAtual - (getSaldo() - valor);
				setSaldo(0);
			}
		} else {
			deuParaSacar = false;
		}
		return deuParaSacar;
	}
	
	@Override
	public void depositar(double valorDeposito) {
		double valorDevido = this.limiteCreditoAtual - this.limiteCredito;
		if (valorDevido == 0) {
			setSaldo(getSaldo() + valorDeposito);
		} else {
			if (valorDeposito > valorDevido) {
				setSaldo(valorDeposito - valorDevido);
				this.limiteCreditoAtual += valorDevido;
			}
		}
	}
	
}
