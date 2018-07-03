package br.com.treinar.aula.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

class TestaSaida {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("data/saida.txt", Boolean.TRUE);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.newLine();
		bw.write("Nova Linha");
		bw.close();
	}
}