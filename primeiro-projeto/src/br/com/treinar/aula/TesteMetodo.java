package br.com.treinar.aula;

public class TesteMetodo {
	
	public static void main(String[] args) {
		Conta c = new Conta();
		c.cliente = new Cliente();
		c.cliente.nome = "Maria Sophia";
		c.saldo = 200;
		c.numero = 10481;
		System.out.println("Saldo: " + c.saldo);
		c.sacar(50);
		System.out.println("Saldo: " + c.saldo);
		boolean sacou = c.sacar(200);
		if (sacou) {
			System.out.println("Saldo: " + c.saldo);
		} else {
			System.out.println("Saldo insuficiente");			
		}
		c.depositar(1000);
		System.out.println(c.saldo);
		
		
		
	}
}
