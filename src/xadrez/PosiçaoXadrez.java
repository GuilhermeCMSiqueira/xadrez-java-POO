package xadrez;

import elementos_tabuleiro.Posição;

public class PosiçaoXadrez {
	private char coluna;
	private int linha;
	
	
	public PosiçaoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new ExceçaoXadrez("Posição Inexistente. Valores possíveis: de a1 até h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}


	public int getLinha() {
		return linha;
	}
	
	protected Posição converterPosicao(){
		return new Posição(8 - linha, coluna - 'a');
	}

	protected static PosiçaoXadrez conversaoInversa(Posição posicao) {
		return new PosiçaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
	
}
