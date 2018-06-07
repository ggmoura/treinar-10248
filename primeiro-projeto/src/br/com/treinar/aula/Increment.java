package br.com.treinar.aula;

public class Increment {

	public static void main(String[] args) {
		int cont = 0;
		System.out.println("Cont = " + cont);
		cont = cont + 1;
		System.out.println("Cont = " + cont);
		cont += 1;
		System.out.println("Cont = " + cont);
		cont++;
		System.out.println("Cont = " + cont);
		
		System.out.println("cont++ = " + ++cont);
		System.out.println(cont);
		
		cont = 0;
		
		int posI = cont++;
		System.out.println("Espero que preI seja 1 [" + posI + "]");
		int preI = ++cont;
		System.out.println("Espero que preI seja 2 [" + preI + "]");
		
		
	}
	
}
