package br.com.treinar.bb.model.banco;

public interface IProdutoPagavel {

	double getValorPagar();

	void setValorPaga(double valorPaga);
	
	void efetuarPagamento();
	
}
