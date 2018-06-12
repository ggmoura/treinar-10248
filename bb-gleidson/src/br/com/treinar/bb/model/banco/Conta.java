package br.com.treinar.bb.model.banco;

import br.com.treinar.bb.model.Cliente;

public class Conta {

	private int numero;
	private double saldo;
	private Cliente cliente;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Conta() {
		super();
		System.out.println("O Objeto foi criado");
	}

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
		return this.saldo;
	}
}
