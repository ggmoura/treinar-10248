package br.com.treinar.aula.collection;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AtividadeEntradaComMap {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("data/nomes.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String nome = br.readLine(); // primeira linha
		List<String> nomes = new ArrayList<>();
		while (nome != null) {
			nomes.add(nome);
			nome = br.readLine();
		}
		is.close();
		//remove os itens null do arraylist
		nomes.removeIf(Objects::isNull);//somente para conhecimento, situacao nao ocorrera
		Map<Character, List<String>> mapNomes = new HashMap<>();
		Character primeiraLetra = null;
		List<String> novaListaDeNomes = null;
		//Percorre toda a lista de nomes
		for (String pessoa : nomes) {
			primeiraLetra = pessoa.charAt(0);
			//Se for a primeira letra
			if (!mapNomes.containsKey(primeiraLetra)) {
				//cria um array e coloca o nome dentro dele
				novaListaDeNomes = new ArrayList<>();
				novaListaDeNomes.add(pessoa);
				//coloca a letra como chave e o novo array como valor do map
				mapNomes.put(primeiraLetra, novaListaDeNomes);
			} else {
				mapNomes.get(primeiraLetra).add(pessoa);
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