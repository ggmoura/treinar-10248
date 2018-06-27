package br.com.treinar.bb.model;

import br.com.treinar.bb.model.tipodado.TipoCliente;

public class Cliente {

	private String nome;
	private String cpf;
	private TipoCliente tipoCliente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
