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
	
	@Override
	public String toString() {
		return "Nome: " + this.nome + " CPF: " + this.cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	
}
