package br.com.treinar.bb.view;

import java.util.Scanner;

import br.com.treinar.bb.controller.BancoController;
import br.com.treinar.bb.model.Cliente;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaCorrente;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.ContaSalario;

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
				criarConta();
				break;
			case 2:
				System.out.println();
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

	private void criarConta() {
		System.out.print("Digite:\n\t1 - Conta Corrente\n\t2 - Conta Poupança\n\t3 - Conta Salario\n=> ");
		int opcao = input.nextInt();
		switch (opcao) {
		case 1:
			criarContaCorrente();
			break;
		case 2:
			criarContaPoupanca();
			break;
		case 3:
			criarContaSalario();
			break;

		default:
			break;
		}
	}

	private void criarContaSalario() {
		ContaSalario cs = new ContaSalario();
		criarContaGenerica(cs);
		System.out.print("Informe o dia de credito do salario: ");
		int diaCreditoSalario = input.nextInt();
		cs.setDiaCreditoSalario(diaCreditoSalario);
		controller.criarConta(cs);
	}

	private void criarContaPoupanca() {
		ContaPoupanca cp = new ContaPoupanca();
		criarContaGenerica(cp);
		System.out.print("Informe a taxa de rendimento: ");
		float taxaRendimento = input.nextFloat();
		cp.setTaxaRendimento(taxaRendimento);
		controller.criarConta(cp);
	}

	private void criarContaCorrente() {
		ContaCorrente cc = new ContaCorrente();
		criarContaGenerica(cc);
		System.out.print("Informe o limite de credito: ");
		double limiteCredito = input.nextDouble();
		cc.setLimiteCredito(limiteCredito);
		controller.criarConta(cc);
	}

	public void criarContaGenerica(Conta conta) {
		input.nextLine();
		System.out.print("Inform o numero da conta: ");
		int numeroConta = input.nextInt();
		input.nextLine();
		System.out.print("Inform o nome do cliente: ");
		String nomeCliente = input.nextLine();
		System.out.print("Inform o CPF do cliente: ");
		String cpfCliente = input.nextLine();
		conta.setCliente(new Cliente());
		conta.getCliente().setNome(nomeCliente);
		conta.getCliente().setCpf(cpfCliente);
		conta.setNumero(numeroConta);
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
			+ "\t1 - Criar Conta\\n"
			+ "\t\n=> "
		);
	}
	
}
