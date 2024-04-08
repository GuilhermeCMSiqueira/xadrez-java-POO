package xadrez;

import elementos_tabuleiro.Peça;
import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;

public abstract class PeçaXadrez extends Peça{
	private Cor cor;
	private int contadorMovimentos;

	public PeçaXadrez(Tabuleiro tabuleiro, Cor cor) {
		// Nesse caso, no nosso construtor, temos a utilzação do construtor da nossa superclasse (Peça)
		super(tabuleiro);
		this.cor = cor;
	}


	public Cor getCor() {
		return cor;
	}
	
	public int getContadorMovimentos() {
		return contadorMovimentos;
	}
	
	public void aumentarMovimentos() {
		contadorMovimentos++;
	}
	
	public void diminuirMovimentos() {
		contadorMovimentos--;
	}
	
	protected boolean temPeçaOponente(Posição posicao) {
		PeçaXadrez p = (PeçaXadrez) getTabuleiro().peca(posicao);
		return p != null && p.getCor() != cor;
	}
	
	public PosiçaoXadrez getPosiçaoXadrez() {
		return PosiçaoXadrez.conversaoInversa(posicao);
	}
	
}
