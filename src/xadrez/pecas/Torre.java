package xadrez.pecas;

import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PeçaXadrez;

public class Torre extends PeçaXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posição p = new Posição(0, 0);
		// Pra cima
		p.setValores(p.getLinha() - 1, p.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Pra baixo
		
		p.setValores(p.getLinha() + 1, p.getColuna());
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Pra direita
		
		p.setValores(p.getLinha(), p.getColuna() + 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Pra esquerda
		
		p.setValores(p.getLinha(), p.getColuna() - 1);
		while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		return mat;
	}
}
