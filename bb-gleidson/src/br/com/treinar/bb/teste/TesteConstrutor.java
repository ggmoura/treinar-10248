package br.com.treinar.bb.teste;

import br.com.treinar.bb.model.Conta;

public class TesteConstrutor {

	public static void main(String[] args) {
		Conta c = new Conta(200, "Gleidson");
		System.out.println(c.getNumero());
	}
	
}
