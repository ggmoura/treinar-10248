package br.com.treinar.bb.controller;

import java.util.Scanner;

import br.com.treinar.bb.model.Conta;

public class BancoController {

	private Scanner input = new Scanner(System.in);
	private Conta conta;
	
	public void criarConta() {
		Conta conta = new Conta(300);
		System.out.println(conta.consultarSaldo());
		System.out.print("Informe o numer: ");
		conta.setNumero(input.nextInt());
		conta.depositar(200);
		System.out.println(conta.consultarSaldo());
		this.conta = conta;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void depositar(double valor) {
		conta.depositar(valor);
	}
}
