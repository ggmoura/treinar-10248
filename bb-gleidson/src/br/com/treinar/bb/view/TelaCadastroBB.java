package br.com.treinar.bb.view;

import java.util.Scanner;

import br.com.treinar.bb.controller.BancoController;

public class TelaCadastroBB {

	private BancoController controller;
	private Scanner input;
	
	public TelaCadastroBB() {
		controller = new BancoController();
		input = new Scanner(System.in);
	}
	
	public void iniciarOperacao() {
		int opcao;
		do {
			imprimirMenu();
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				controller.criarConta();
				break;
			case 2:
				depositar();	
				break;
			case 3:
				imprimirSaldo();
				break;
			case 0:
				break;

			default:
				System.out.println("OPÇÃO INVÁLIDA DIGITE NOVAMENTE");			
				break;
			}
		} while (opcao != 0);
		
		input.close();
		
	}

	private void imprimirSaldo() {
		System.out.println("Saldo atual: " + controller.getConta().getSaldo());
	}

	private void depositar() {
		System.out.print("Valor a ser depositado: ");
		controller.depositar(input.nextDouble());
	}

	private static void imprimirMenu() {
		System.out.print(""
			+ "Informe a opcão:\n"
			+ "\t0 - Sair\n"
			+ "\\t1 - Criar Conta\\n"
			+ "\t\n=> "
		);
	}
	
}
