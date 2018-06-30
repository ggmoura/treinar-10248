package br.com.treinar.aula;

public class Conta implements Comparable<Conta> {

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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + numero;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Conta other = (Conta) obj;
		if (numero != other.numero) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.numero);
	}
	
	@Override
	public int compareTo(Conta o) {
		return this.numero - o.numero;
	}
	
}
