package br.com.treinar.aula.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class TestaEntrada {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("data/arquivo.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		System.out.println(br.readLine());
		String s = br.readLine(); // primeira linha
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}
		is.close();
	}
}