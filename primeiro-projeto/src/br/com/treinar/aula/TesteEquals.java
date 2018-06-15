package br.com.treinar.aula;

public class TesteEquals {

	public static void main(String[] args) {
		Cliente c1 = new Cliente();
		c1.cpf = "10481";
		c1.nome = "Maria Sophia";
		
		Cliente c2 = new Cliente();
		c2.cpf = new String("10481");
		
		System.out.println(c1 == c2);
		
		System.out.println(c1.equals(c2));
		
	}
	
}
