package br.com.treinar.bb;

import br.com.treinar.bb.util.BBUtil;
import br.com.treinar.bb.view.TelaCadastroBB;

public class Main {

	public static void main(String[] args) {
		//TODO criar hora de abertura e fechamento do banco  Timer time = new Timer();
		BBUtil util = BBUtil.getInstance();
		String timeout = util.getProperty("timeout");
		System.out.println(timeout);
		TelaCadastroBB cadastro = new TelaCadastroBB();
		cadastro.iniciarOperacao();
		util.persistirDados();
		System.out.println(util.getProperty("mensagemFinal"));
	}
	
}
