package br.com.treinar.aula;

public class TesteObjeto {
	
	public static void main(String[] args) {
		Conta c = new Conta();
		c.cliente = new Cliente();
		c.cliente.nome = "Maria Sophia";
		c.saldo = 200000;
		c.numero = 10481;
		Conta c2 = c;
		System.out.println(c2.numero);
		c = new Conta();
		System.out.println(c.numero);
		c2 = new Conta();
		System.out.println(c2.cliente.nome);
	}
}
