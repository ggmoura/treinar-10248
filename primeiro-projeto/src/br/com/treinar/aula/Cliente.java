package br.com.treinar.aula;

public class Cliente extends Object {

	public String nome;
	public String cpf;
	
	public Cliente() {
		System.out.println("fiz...");
	}
	
	public Cliente(String nome) {
		this();
		this.nome = nome;
	}
	
	
	public Cliente(String nome, String cpf) {
		this(nome);
		this.cpf = cpf;
	}
	

	
}
