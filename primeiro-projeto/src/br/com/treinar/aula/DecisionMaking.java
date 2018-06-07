package br.com.treinar.aula;

public class DecisionMaking {

	public static void main(String[] args) {
		int a = 266;
		int b = 20;

		if (a > b) {
			System.out.println("a maior que b");
		} else if (a < b) {
			System.out.println("a menor que b");
		} else {
			System.out.println("a eh igual a b ");
		}

		int i = 1;

		if (i == 1) {
			System.out.println("Um");
		} else if (i == 2) {
			System.out.println("Dois");
		} else if (i == 3) {
			System.out.println("Tres");
		} else if (i == 4) {
			System.out.println("Quatro");
		} else if (i == 5) {
			System.out.println("Cinco");
		} else {
			System.out.println("fora do dominio 0 ~ 5");
		}
		
		
		switch (i) {
		case 1:
			System.out.println("switch Um");
//			break;
		case 2:
			System.out.println("switch Dois");
//			break;
		case 3:
			System.out.println("switch Tres");
//			break;
		case 4:
			System.out.println("switch Quatro");
//			break;
		case 5:
			System.out.println("switch Cinco");
//			break;
		default:
			System.out.println("switch fora do dominio 0 ~ 5");
			break;
		}
		

	}

}
