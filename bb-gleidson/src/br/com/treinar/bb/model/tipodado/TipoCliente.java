package br.com.treinar.bb.model.tipodado;

public enum TipoCliente {

	ESPECIAL(10_000.00) {
		public Boolean verificar(Double valor) {
			return valor >= getSalarioMinimo();
		}
	},
	COMUM(1_000.00) {
		@Override
		public Boolean verificar(Double valor) {
			return valor >= getSalarioMinimo();
		}
	},
	UNIVERSITARIA(0D) {
		@Override
		public Boolean verificar(Double valor) {
			return valor >= getSalarioMinimo();
		}
	};

	private Double salarioMinimo;

	//todas as instancias deverao possuir este metodo
	public abstract Boolean verificar(Double valor);

	private TipoCliente(Double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public Double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(Double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

}
