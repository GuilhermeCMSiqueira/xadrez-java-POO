package xadrez;

import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
	}
	
	public PeçaXadrez[][] verPeças(){
		PeçaXadrez[][] matriz = new PeçaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int i = 0; i<tabuleiro.getLinhas(); i++) {
			for (int j = 0; j<tabuleiro.getLinhas(); j++) {
				matriz[i][j] = (PeçaXadrez) tabuleiro.peca(i, j);
				// Aqui faremos um DOWNCASTING de todas as peças do tabuleiro para a classe PeçaXadrez
			}
		}
		return matriz;
	}
	
	public void setupInicial(){
		tabuleiro.colocarPeça(new Rei(tabuleiro, Cor.BRANCO), new Posição(0, 4));
		tabuleiro.colocarPeça(new Rei(tabuleiro, Cor.BRANCO), new Posição(7, 4));
	}
}
