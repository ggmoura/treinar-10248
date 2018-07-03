package br.com.treinar.aula.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class AtividadeSaida {
	public static void main(String[] args) throws IOException {

		Scanner leitor = new Scanner(System.in);
		OutputStream os = new FileOutputStream("data/nomes.txt", Boolean.FALSE);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		String nome = null;
		// ignore case retorna verdadeiro indiferente de estar em caixa alta ou baixa
		String str = null;
		while (!"sair".equalsIgnoreCase(nome)) {
			System.out.print("Informe o nome, ou digite sair: ");
			nome = leitor.nextLine();
			str = !nome.equalsIgnoreCase("sair") ? new StringBuffer(nome).append("\n").toString() : "";
			bw.write(str);
		}
		leitor.close();
		bw.close();

	}
}