package br.com.treinar.aula;

public class LoopControl {

	public static void main(String args) {
		
		int cont = 0;
		
		System.out.println("while\n");
		while (cont < 100000) {
			System.out.println(++cont);
		}
		
		System.out.println("\ndo while");
		do {
			System.out.println(cont--);
		} while (cont > 0);
		
		
		System.out.println("\nfor ");
		for (int i = 0; i < 10; ) {
			System.out.println(i);
		}
//		System.out.println(i); 
		
	}
	
}
