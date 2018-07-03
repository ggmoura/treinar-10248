package br.com.treinar.aula.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestaEntrada {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("data/nomes.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println(br.readLine());
			String nome = br.readLine(); // primeira linha
			while (nome != null) {
				System.out.println(nome);
				nome = br.readLine();
			}
			is.close();
		} catch (IOException e) {
			System.out.println("Arquivo não encontrado");
		}
	}
}