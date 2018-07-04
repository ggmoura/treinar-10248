package br.com.treinar.aula.thread;

public class MeuPrograma {
	
	//https://www.caelum.com.br/apostila-java-orientacao-objetos/apendice-programacao-concorrente-e-threads/#escalonador-e-trocas-de-contexto
	
	public static void main(String[] args) throws InterruptedException {
		
		StringBuffer texto = new StringBuffer();

		synchronized (texto) {
			//StringBuilder texto = new StringBuilder();
			
			GeraPDF gerapdf = new GeraPDF(texto);
			Thread threadDoPdf = new Thread(gerapdf);
			threadDoPdf.start();
			
			BarraDeProgresso barraDeProgresso = new BarraDeProgresso(texto);
			Thread threadDaBarra = new Thread(barraDeProgresso);
			threadDaBarra.start();
			Thread.sleep(1000);
		}
		System.out.println(texto);
		
		
	}
}