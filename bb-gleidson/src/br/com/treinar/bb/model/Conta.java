package br.com.treinar.bb.model;

public class Conta {

	public int numero;
	public double saldo;
	public Cliente cliente;

	public boolean sacar(double valor) {
		boolean deuParaSacar = false;
		if (valor <= saldo) {
			saldo -= valor;
			deuParaSacar = true;
		}
		return deuParaSacar;
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public double consultarSaldo() {
		return saldo;
	}

}
