package br.com.treinar.bb.model.banco;

import br.com.treinar.bb.model.Cliente;

public abstract class Conta {

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
	
	public abstract void depositar(double valor);

	public double consultarSaldo() {
		return this.saldo;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente.toString() + "]";
	}
	
	
}
