package br.com.treinar.aula.util;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		instance.imprimirNome("Maria Sophia");
		Singleton instance2 = Singleton.getInstance();
		instance2.imprimirNome("Davi Lucas");
		Singleton instance3 = Singleton.getInstance();
		instance3.imprimirNome("Davi Lucas");
		
		//o construtor na classe Singleton eh privado, portanto, nao eh possivel 
		//instanciar a classe em um ponto fora dele 
		//Singleton instanceX = new Singleton();
				
	}
	
}
