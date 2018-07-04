package br.com.treinar.aula.thread;

public class BarraDeProgresso implements Runnable {

	private StringBuffer texto;
	
	public BarraDeProgresso(StringBuffer texto) {
		this.texto = texto;
	}
	
	public void run() {
		for (int i = 0; i < 10000; i++) {
			texto.append(new StringBuilder("Davi Lucas ").append(i)).append("\n");
			//System.out.println(new StringBuilder("Davi Lucas ").append(i));
		}
	}
}