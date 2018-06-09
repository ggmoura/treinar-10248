package br.com.treinar.bb.teste;

import br.com.treinar.bb.model.Conta;

public class TesteModificadorAcesso {

	public static void main(String[] args) {
		Conta c = new Conta();
		c.setNumero(10481);
		
		System.out.println(c.getNumero());
	}
	
}
