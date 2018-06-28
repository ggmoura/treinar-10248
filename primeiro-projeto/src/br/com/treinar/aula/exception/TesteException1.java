package br.com.treinar.aula.exception;

import java.util.Scanner;

public class TesteException1 {

	public static void main(String[] args) {
		
//		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//		Date niver = formatador.parse("09/o2/1980");
		
		Scanner sc = new Scanner(System.in);
		try {
			metodoUm(sc);
		} catch (IllegalAccessError | RuntimeException e) {
			System.out.println("teste");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("teste");
			sc.close();
		}
	}
	
	private static void metodoUm(Scanner sc) throws Exception {
		metodoDois(sc);
	}
	
	private static void metodoDois(Scanner sc) throws Exception, IllegalAccessError {
		String[] nomes = new String[1];
		System.out.println("Informe o nome: ");
		nomes[0] = sc.nextLine();
		if (nomes[0].equals("Maria Sophia")) {
			System.out.println("Eh Maria...");
		}
		nomes[2] = "Teste";
	}
	
}
