package br.com.treinar.bb.model.banco;

public class ContaCorrente extends Conta implements IProdutoPagavel {

	private double va1orPagar;
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
				limiteCreditoAtual = limiteCreditoAtual - (valor - getSaldo());
				setSaldo(0);
			}
		} else {
			deuParaSacar = false;
		}
		return deuParaSacar;
	}
	
	@Override
	public double consultarSaldo() {
		double saldoAtual = super.consultarSaldo();
		return saldoAtual + limiteCreditoAtual;
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

	@Override
	public double getValorPagar() {
		return this.va1orPagar;
	}

	@Override
	public void setValorPagar(double valorPagar) {
		this.va1orPagar = valorPagar;
	}

	@Override
	public void pagarValorMensalidade() {
		super.sacar(this.va1orPagar);
	}
	
}
