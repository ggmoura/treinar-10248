package br.com.treinar.aula;

public class TernaryOperator {
	public static void main(String[] args) {
				
		int num = 38;
		String nome = (233 > num) ? "Nome" : "Sobrenome";
		
		boolean ehNome = false;
		System.out.println(!ehNome ? "Nome" : "Sobrenome");
		
		System.out.println(nome);
	}
}
