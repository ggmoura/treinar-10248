package br.com.treinar.bb.model.banco;

public class ContaSalario extends Conta implements IProdutoPagavel {

	private int diaCreditoSalario;
	private double va1orPagar;

	public int getDiaCreditoSalario() {
		return diaCreditoSalario;
	}

	public void setDiaCreditoSalario(int diaCreditoSalario) {
		this.diaCreditoSalario = diaCreditoSalario;
	}
	
	@Override
	public void depositar(double valor) {
		setSaldo(getSaldo() + valor);
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

	@Override
	public String toString() {
		return super.toString() + " " + "ContaSalario [diaCreditoSalario=" + diaCreditoSalario + ", va1orPagar=" + va1orPagar + "]";
	}

}
