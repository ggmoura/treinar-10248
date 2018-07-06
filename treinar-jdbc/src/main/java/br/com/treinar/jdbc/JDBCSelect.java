package br.com.treinar.jdbc;

import java.util.List;

import br.com.treinar.model.Contato;

public class JDBCSelect {

	public static void main(String[] args) {
		List<Contato> lista = new ContatoDAO().getLista();
		System.out.println(lista);
	}
}
