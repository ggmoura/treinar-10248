package br.com.treinar.aula;

public class PrimeiraClasse {

	public static void main(String[] args) {
		String nomeIdade = "Gleidson Moura " + 37;
		System.out.println(nomeIdade);
		
		byte a = 10;
		System.out.println("a = " + a);
		short b = a;
		System.out.println("b = " + b);
		b = 20000;
		System.out.println("b = " + b);
		a = (byte) b;
		
		int idade = 45;
		long numeroGrande  = 05;
		
		System.out.println(numeroGrande);
		
		System.out.println("idade = " + idade);
		System.out.println("Long = " + numeroGrande);
		
		
		float numeroFlutuante = 3.14f;
		
		boolean portaAberta = false;
		
		System.out.println(portaAberta);
		
		char aa = 'a';
		System.out.println(aa);
		
		char aaa = 65;
		
		System.out.println(aaa);
		
		int aMaiusculo = 'A';
		
		System.out.println(aMaiusculo);
		char cx = '\'';
		String nomeCompleto = "Gleidson\n\tMoura \"'";
		
		System.out.println(nomeCompleto);
		
		
	}

}
