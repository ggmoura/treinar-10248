package br.com.treinar.bb.model.banco;

public interface IProdutoPagavel extends IProduto {

	double getValorPagar();

	void setValorPagar(double valorPaga);
	
	void pagarValorMensalidade();
	
}
