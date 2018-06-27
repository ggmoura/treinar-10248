package br.com.treinar.bb.model.banco;

public interface IProdutoPagavel {

	double getValorPagar();

	void setValorPagar(double valorPaga);
	
	void pagarValorMensalidade();
	
}
