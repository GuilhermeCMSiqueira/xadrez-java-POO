package elementos_tabuleiro;

public class Peça {
	protected Posição posicao;
	private Tabuleiro tabuleiro;
	
	public Peça(Tabuleiro tabuleiro) { 
		// Aqui você considera como se a peça ainda não tivesse sido colocada no tabuleiro.
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() { 
		// Somente classes dentro do mesmo pacote e subclasses poderão executar esse método
		return tabuleiro;
	}

	
	
	
}
