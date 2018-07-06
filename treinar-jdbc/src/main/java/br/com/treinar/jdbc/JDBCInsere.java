package br.com.treinar.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import br.com.treinar.model.Contato;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		Contato c = new Contato();
		inserirContato(c);
	}

	private static void inserirContato(Contato contato) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();

		// cria um preparedStatement
		String sql = "insert into contatos" + " (nome, email, endereco, dataNascimento) values ( ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);

		// preenche os valores
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new java.sql.Date(new Date().getTime()));

		// executa
		stmt.execute();
		stmt.close();

		System.out.println("Gravado!");

		con.close();
	}
}