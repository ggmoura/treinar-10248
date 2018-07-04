package br.com.treinar.aula.thread;

public class GeraPDF implements Runnable {
	
	private StringBuffer texto;
	
	public GeraPDF(StringBuffer texto) {
		this.texto = texto;
	}
	
	public void run () {
		for (int i = 0; i < 10000; i++) {
			texto.append(new StringBuilder("Maria Sophia ").append(i)).append("\n");
			//System.out.println(new StringBuilder("Maria Sophia ").append(i));
		}
	}

}