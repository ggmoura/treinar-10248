package br.com.treinar.aula.collection;

import java.util.Comparator;

import br.com.treinar.aula.Conta;

public class OrdenadorContaPorSaldo implements Comparator<Conta> {

	@Override
	public int compare(Conta o1, Conta o2) {
		Double saldo1 = Double.valueOf(o1.saldo);
		Double saldo2 = Double.valueOf(o2.saldo);
		return saldo1.compareTo(saldo2);
	}

}
