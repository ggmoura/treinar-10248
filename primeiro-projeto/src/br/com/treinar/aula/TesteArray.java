package br.com.treinar.aula;

import java.util.Scanner;

public class TesteArray {

	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		Cliente[] clientes = new Cliente[3];

		for (int i = 0; i < clientes.length; i++) {
			clientes[i] = new Cliente();
			System.out.print("Informe o nome do cliente" + (i + 1) + ": ");
			clientes[i].nome = leitor.nextLine();
			System.out.print("Informe o CPF do cliente" + (i + 1) + ": ");
			clientes[i].cpf = leitor.nextLine();
		}
		leitor.close();
		for (int i = 0; i < clientes.length; i++) {
			System.out.println(clientes[i]);
		}
		
	}
	
}
