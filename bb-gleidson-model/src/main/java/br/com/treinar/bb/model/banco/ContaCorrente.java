package br.com.treinar.bb.model.banco;

import br.com.treinar.bb.model.tipodado.TipoCliente;

public class ContaCorrente extends Conta implements IProdutoPagavel {

	private double va1orPagar;
	private double limiteCredito;
	private double limiteCreditoAtual;

	@Override
	public TipoConta getType() {
		return TipoConta.CORRENTE;
	}

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
	public void sacar(double valor) throws SaldoInsuficienteException {
		if (valor <= getSaldo() + this.limiteCreditoAtual) {
			if (valor <= getSaldo()) {
				setSaldo(getSaldo() - valor);
			} else {
				limiteCreditoAtual = limiteCreditoAtual - (valor - getSaldo());
				setSaldo(0);
			}
		}
	}
	
	@Override
	public double consultarSaldo() {
		double saldoAtual = super.consultarSaldo();
		return saldoAtual + limiteCreditoAtual;
	}
	
	@Override
	public void depositar(double valorDeposito) {
		double valorDevido = this.limiteCredito - this.limiteCreditoAtual;
		if (getCliente().getTipoCliente() != null && getCliente().getTipoCliente().equals(TipoCliente.ESPECIAL)) {
			valorDeposito += 1.0;//clientes especiais ganham um real ao depositar
		}
		if (valorDevido == 0) {
			setSaldo(getSaldo() + valorDeposito);
		} else {
			if (valorDeposito > valorDevido) {
				this.limiteCreditoAtual += valorDevido;
				setSaldo(valorDeposito - valorDevido);
			} else {
				this.limiteCreditoAtual += valorDeposito;				
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
		try {
			super.sacar(this.va1orPagar);
		} catch (SaldoInsuficienteException e) {
			//TODO - apos tres meses sem pagar cancela a conta
			//XXX - 
			//FIXME - 
		}
	}

	@Override
	public String toString() {
		return  super.toString() + " " + "ContaCorrente [va1orPagar=" + va1orPagar + ", limiteCredito=" + limiteCredito + ", limiteCreditoAtual="
				+ limiteCreditoAtual + "]";
	}
	
}
