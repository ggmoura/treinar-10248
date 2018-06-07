package br.com.treinar.aula;

public class Operator {

	public static void main(String[] args) {
		int num = -1;
		boolean ehIgual = num != 1;
		System.out.println(ehIgual);
		
		boolean igualNovamente = ehIgual && num > 2;
		System.out.println(igualNovamente);
		
		boolean verdadeiro = true;
		System.out.println(!(verdadeiro && false));
		System.out.println(verdadeiro);
		
		
		
	}
	
}
