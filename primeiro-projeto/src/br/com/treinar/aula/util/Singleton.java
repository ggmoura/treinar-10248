package br.com.treinar.aula.util;

public class Singleton {

	private static Singleton instance;
	
	static {
		instance = new Singleton();
	}
	
	private Singleton() {
		super();
	}
	
	public static Singleton getInstance() {
		return instance;
	}
	
	public void imprimirNome(String nome) {
		System.out.println("Nome: " + nome);
	}
	
	public void somar(int a, int b) {
		System.out.println("Nome: " + a + b);
	}
	
}
