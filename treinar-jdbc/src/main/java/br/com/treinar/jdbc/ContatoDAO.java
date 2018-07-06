package br.com.treinar.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.treinar.model.Contato;

public class ContatoDAO {
	
	public List<Contato> getLista() {
		
		Connection con = new ConnectionFactory().getConnection();
		
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = con.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			Contato contato = null;
			while (rs.next()) {
				// criando o objeto Contato
				contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				try {
					contato.setDataNascimento(new Date(rs.getDate("dataNascimento").getTime()));
				} catch (Exception e) {
					System.out.println(new StringBuilder("Erro ao carregar data de nascimento do ").append(contato.getNome()));
				}

				// adicionando o objeto à lista
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
