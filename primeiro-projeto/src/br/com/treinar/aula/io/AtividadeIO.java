package br.com.treinar.aula.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class AtividadeIO {
	public static void main(String[] args) throws IOException {
		try (
			Scanner sc = new Scanner(System.in);
			OutputStream os = new FileOutputStream("data/nomes.data", Boolean.FALSE)) {
			try(OutputStreamWriter osw = new OutputStreamWriter(os)) {
				try(BufferedWriter bw = new BufferedWriter(osw)) {
					bw.write(sc.nextLine());
				}
			}
		}
	}
}
