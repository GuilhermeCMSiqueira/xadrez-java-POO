package xadrez;

import elementos_tabuleiro.ExceçaoTabuleiro;

public class ExceçaoXadrez extends ExceçaoTabuleiro {
	private static final long serialVersionUID = 1L;
	
	public ExceçaoXadrez(String msg) {
		super(msg);
	}
}
