package br.com.treinar.bb;

import java.util.Scanner;

import br.com.treinar.bb.model.Conta;

public class Main {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		do {
			imprimirMenu();
			opcao = input.nextInt();
			switch (opcao) {
			case 1:
				criarConta();
				break;
			case 2:
				System.out.println("DEPOSITAR");//TODO - CRIAR CONTA			
				break;
			case 0:
				System.out.println("VALEU");//TODO - CRIAR CONTA			
				break;

			default:
				System.out.println("OPÇÃO INVÁLIDA DIGITE NOVAMENTE");			
				break;
			}
		} while (opcao != 0);
		System.out.println("good-by");
		
		input.close();
		
	}

	private static void criarConta() {
		Conta c = new Conta();
		System.out.print("Informe o numer: ");
		c.numero = input.nextInt();
		
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
