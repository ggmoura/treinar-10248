package br.com.treinar.bb;

import br.com.treinar.bb.view.TelaCadastroBB;

public class Main {

	public static void main(String[] args) {
		//TODO criar hora de abertura e fechamento do banco  Timer time = new Timer();
		TelaCadastroBB cadastro = new TelaCadastroBB();
		cadastro.iniciarOperacao();
		System.out.println("good-by");
	}
	
}
