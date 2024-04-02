package application;

import xadrez.PartidaXadrez;

public class Program {

	public static void main(String[] args) {

		PartidaXadrez partida = new PartidaXadrez();
		Visual.printTabuleiro(partida.verPeças());
	}

}
