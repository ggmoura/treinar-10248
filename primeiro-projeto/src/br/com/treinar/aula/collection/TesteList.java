package br.com.treinar.aula.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.treinar.aula.Conta;

public class TesteList {

	public static void main(String[] args) {
		
		List<String> listaNomes = new ArrayList<>();
		listaNomes.add("B Maria Sophia 1");
		listaNomes.add("A Maria Sophia 2");
		listaNomes.add("V Maria Sophia 3");
		listaNomes.add("C Katarinna 1");
		listaNomes.add("Y Katarinna 2");
		listaNomes.add("E Katarinna 3");
		
		for (String nome : listaNomes) {
			System.out.println(nome);
		}
		
		System.out.println(listaNomes.indexOf("Katarinna 2"));
		System.out.println(listaNomes.get(4));
		
		System.out.println(listaNomes);
		listaNomes.remove(4);
		System.out.println(listaNomes);
		
		listaNomes.add(4, "Katarina nova");
		System.out.println(listaNomes);
		
		Collections.sort(listaNomes);
		
		System.out.println(listaNomes);
	
	}
	
}
