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
				depositar();
				break;
			case 3:
				exibirSaldo();
				break;
			case 4:
				sacar();
				break;
			case 5:
				alterarTaxaRendimento();
				break;
			case 6:
				exibirTaxaRendimento();
				break;
			case 0:
				break;

			default:
				System.out.println("Opcção inválida");
				break;
			}
		} while (opcao != 0);
		
		input.close();
	}
	
	private void alterarTaxaRendimento() {
		System.out.print("Informe a taxa de rendimento: ");
		float taxaRendimento = input.nextFloat();
		controller.alterarTaxaRendimento(taxaRendimento);
	}

	private void sacar() {
		System.out.print("Valor a ser sacado: ");
		boolean sacou = controller.sacar(input.nextDouble());
		String mensagem = sacou ? "Saque efetuado com sucesso" : "Saldo insuficiente";
		System.out.println(mensagem);
	}

	private void criarConta() {
		System.out.print("Digite:\n\t1 - Conta Corrente\n\t2 - Conta Poupança\n\t3 - Conta Salário\n=> ");
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
		controller.criarConta(cp);
	}

	private void criarContaCorrente() {
		ContaCorrente cc = new ContaCorrente();
		criarContaGenerica(cc);
		System.out.print("Informe o limite de credito: ");
		double limiteCredito = input.nextDouble();
		cc.setLimiteCredito(limiteCredito);
		cc.setLimiteCreditoAtual(limiteCredito);
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
	private void exibirSaldo() {
		double saldo = controller.recuperarSaldo();
		System.out.println("Saldo atual: " + saldo);
	}
	private void exibirTaxaRendimento() {
		System.out.println("Taxa rendimento atual: " + controller.recuperarTaxaRendimento());
	}

	private void depositar() {
		System.out.print("Valor a ser depositado: ");
		controller.depositar(input.nextDouble());
	}

	private static void imprimirMenu() {
		System.out.print(""
			+ "Informe a opção:\n"
			+ "\t0 - Sair\n"
			+ "\t1 - Criar Conta\n"
			+ "\t2 - Depositar\n"
			+ "\t3 - Exibir Saldo\n"
			+ "\t4 - Sacar\n"
			+ "\t5 - Alterar Taxa de Rendimento\n"
			+ "\t6 - Exibir Taxa de Rendimento\n"
			+ "\t\n=> "
		);
	}
	
}
