package br.com.treinar.aula.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.treinar.aula.Conta;

public class Ordenacao {

	public static void main(String[] args) {
		Conta c1 = new Conta();
		c1.numero = 10488;
		c1.saldo = 1.0;
		Conta c2 = new Conta();
		c2.numero = 10487;
		c2.saldo = 5.0;
		Conta c3 = new Conta();
		c3.numero = 10485;
		c3.saldo = 15.0;
		Conta c4 = new Conta();
		c4.numero = 10486;
		c4.saldo = -5.0;
		Conta c5 = new Conta();
		c5.numero = 10481;
		c5.saldo = 0.0;
		Conta c6 = new Conta();
		c6.numero = 10483;
		Conta c7 = new Conta();
		c7.numero = 10482;
		c7.saldo = -8000;
		Conta c8 = new Conta();
		c8.numero = 10484;
		c8.saldo = 8000;
		List<Conta> contas = new ArrayList<>();
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		contas.add(c4);
		contas.add(c5);
		contas.add(c6);
		contas.add(c7);
		contas.add(c8);
		
		System.out.println(contas);
		Collections.sort(contas);
		System.out.println(contas);
		
		System.out.println("Ordenado por saldo:");
		OrdenadorContaPorSaldo ordenador = new OrdenadorContaPorSaldo();
		Collections.sort(contas, ordenador);

		//ordenacao antes do java 8 classe anonima 
//		Collections.sort(contas, new Comparator<Conta>() {
//			@Override
//			public int compare(Conta o1, Conta o2) {
//				return o1.cliente.nome.compareTo(o2.cliente.nome);
//			}
//		});
		
		//ordenacao utilizando os recursos java 8 lambda
		//contas.sort((o1, o2) -> o1.cliente.nome.compareTo(o2.cliente.nome));
		
		//for utilizando lambda
		contas.forEach(c -> {
			System.out.println(c.saldo);
		});

		//filtra todas as contas negativas
		Stream<Conta> streamContas = contas.stream().filter(c -> c.saldo < 0);
		List<Conta> contasNegativas = streamContas.collect(Collectors.toList());
		streamContas.count();
		try {
			Conta nova = streamContas.findFirst().orElseThrow(() -> new IllegalArgumentException());
			System.out.println(nova.saldo);
		} catch (IllegalArgumentException e) {
			System.out.println("Não existe contas com saldo negativo!");
		}
		System.out.println(contasNegativas);
	}
	
}
