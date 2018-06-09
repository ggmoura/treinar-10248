package br.com.treinar.bb.model;

public class Conta {

	private int numero;
	private double saldo;
	private Cliente cliente;
	private double limiteCredito;

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

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Conta() {
		super();
		System.out.println("O Objeto foi criado");
	}

	public Conta(double limiteCredito) {
		this();
		this.limiteCredito = limiteCredito;
	}

	public Conta(double limiteCredito, String nomeCliente) {
		this(limiteCredito);
		this.cliente = new Cliente();
		this.cliente.setNome(nomeCliente);
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
