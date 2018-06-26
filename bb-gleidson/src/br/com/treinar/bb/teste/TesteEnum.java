package br.com.treinar.bb.teste;

import java.util.Scanner;

import br.com.treinar.bb.model.tipodado.TipoCliente;

public class TesteEnum {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		TipoCliente tipoCliente = TipoCliente.ESPECIAL;
		System.out.println(tipoCliente);
		System.out.println("Tipo Conta: ");
		TipoCliente[] tiposDeCliente = TipoCliente.values();
		
		for (TipoCliente tpCli : tiposDeCliente) {
			System.out.println("\t" + tpCli);
		}
		
		System.out.print("-> ");
		
		String tipoContaStr = sc.nextLine();
		TipoCliente tipoByStr = TipoCliente.valueOf(tipoContaStr.toUpperCase());
		System.out.println();
		System.out.println(tipoByStr);
		
		System.out.println("Ordinal: " + tipoByStr.ordinal() + " Salario minimo: " + tipoByStr.getSalarioMinimo());
		
		
		System.out.print("Informe o ordinal: ");
		int ordinal = sc.nextInt();
		TipoCliente novoEnumAPartirDoOrdinal = tiposDeCliente[ordinal];
		System.out.println(novoEnumAPartirDoOrdinal + " " + novoEnumAPartirDoOrdinal.getSalarioMinimo());
		
		sc.close();
		
	}
	
}
