package br.com.treinar.aula.collection;

import java.util.HashSet;
import java.util.Set;

import br.com.treinar.aula.Conta;

public class TesteSet {

	public static void main(String[] args) {
		//Seria dificil ter que verificar sempre o tipo do objeto
		//interno da colecao para fazer um cast e acessar os atributos]
		//e funcionalidades do mesmo.. 
		
		Set meuSet = new HashSet();
		
		meuSet.add("Gleidson");
		meuSet.add("Maria Sophia");
		meuSet.add(1);
		meuSet.add('g');
		Conta conta = new Conta();
		meuSet.add(conta);
		meuSet.add(conta);
		for (Object object : meuSet) {
			if (object instanceof Conta) {
				System.out.println(((Conta)object).numero);
			}
		}
		
		Set<Integer> inteiros = new HashSet<>();
		
		
		//Utilizando generics
		Set<Conta> contas = new HashSet<>();
		
		
		Conta novaConta = new Conta();
		novaConta.numero = 10481;
		contas.add(novaConta);
		
		for (Conta c : contas) {
			System.out.println(c.numero);
		}
		
		
	}
	
}
