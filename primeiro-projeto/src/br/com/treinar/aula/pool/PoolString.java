package br.com.treinar.aula.pool;

public class PoolString {

	public static void main(String[] args) {
		//pool de string
		String a = "Maria Sophia";
		String b = "Maria Sophia";
		
		//endereco de memoria diferente
		String c = new String("Maria Sophia");
		
		System.out.println(a == b);
		System.out.println(a == c);
	}
	
}
