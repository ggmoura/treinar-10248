package br.com.treinar.aula;

public class Conta {

	public int numero;
	public double saldo;
	public Cliente cliente;
	
	public boolean sacar(double valor) {
		boolean deuParaSacar;
		if (valor <= saldo) {
			saldo -= valor;	
			deuParaSacar = true;
		} else {
			deuParaSacar = false;
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
