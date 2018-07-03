package br.com.treinar.aula.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AtividadeMap {

	
	public static void main(String[] args) {

		//TODO ler sobre collections
		//https://www.caelum.com.br/apostila-java-orientacao-objetos/collections-framework/#para-saber-mais-properties
		
		//Ler os nomes do teclado
		//Obs, um nome deve possuir no minimo tres caracteres sendo que 
		//sem espaços nos tres primeiros caracters
		List<String> nomes = new ArrayList<>();
		nomes.add("Maria Sophia");
		nomes.add("Davi Lucas");
		nomes.add("Ana Madalena");
		nomes.add("Ana Cecilia");
		nomes.add("Douglas");
		nomes.add("Aline");
		nomes.add("Marta Silva");
		nomes.add("Gleidson Moura");
		
		Map<Character, List<String>> mapNomes = new HashMap<>();
		Character primeiraLetra = null;
		List<String> novaListaDeNomes = null;
		//Percorre toda a lista de nomes
		for (String nome : nomes) {
			primeiraLetra = nome.charAt(0);
			//Se for a primeira letra
			if (!mapNomes.containsKey(primeiraLetra)) {
				//cria um array e coloca o nome dentro dele
				novaListaDeNomes = new ArrayList<>();
				novaListaDeNomes.add(nome);
				//coloca a letra como chave e o novo array como valor do map
				mapNomes.put(primeiraLetra, novaListaDeNomes);
			} else {
				mapNomes.get(primeiraLetra).add(nome);
			}
		}
		mapNomes.entrySet().forEach(entry -> {
			StringBuilder msg = new StringBuilder("Ordenando os nomes que começam com a letra: ");
			msg.append(entry.getKey());
			System.out.println(msg);
			Collections.sort(entry.getValue());
		});
		System.out.println(mapNomes);
	}
	
}
