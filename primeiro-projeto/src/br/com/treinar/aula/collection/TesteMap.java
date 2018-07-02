package br.com.treinar.aula.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TesteMap {

	public static void main(String[] args) {
		Map<Long, String> nomes = new HashMap<>();
		nomes.put(10481L, "Maria Sophia");
		nomes.put(10482L, "Davi Lucas");
		nomes.put(10483L, "Ana Cecilia");
		nomes.put(10484L, "Marta Silva");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe o codigo do aluno: ");
		Long codigo = sc.nextLong();
		if (nomes.containsKey(codigo)) {
			System.out.println(nomes.get(codigo));
		} else {
			System.out.println("Codigo inválido");
		}
		sc.close();
		
		Set<Long> keys = nomes.keySet();
		for (Long key : keys) {
			System.out.println(key + " - " + nomes.get(key));
		}
		
		Set<Entry<Long, String>> entrySet = nomes.entrySet();
		for (Entry<Long, String> entry : entrySet) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
	
}
