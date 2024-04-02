package application;

import xadrez.PeçaXadrez;

public class Visual {
	
	public static void printTabuleiro(PeçaXadrez[][] pecas) {
		for (int i = 0; i<pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j< pecas.length; j++) {
				printPeça(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
	// Vamos criar um metodo pra imprimir uma única peça e usar ele no desenvolvimento da impressão do tabuleiro inteiro
	private static void printPeça(PeçaXadrez peca) {
		if (peca == null) {
			System.out.print('-');
		}else {
			System.out.print(peca);
		}
		System.out.print(' ');
	}
	
}
