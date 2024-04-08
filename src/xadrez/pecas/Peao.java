package xadrez.pecas;

import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PeçaXadrez;

public class Peao extends PeçaXadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posição p = new Posição(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			p.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			Posição p2 = new Posição(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p) && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().peçaExiste(p2) && getContadorMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
		}
		else {
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			Posição p2 = new Posição(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().posicaoExiste(p) && !getTabuleiro().peçaExiste(p) && getTabuleiro().posicaoExiste(p2) && !getTabuleiro().peçaExiste(p2) && getContadorMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().posicaoExiste(p) && temPeçaOponente(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		
		return mat;
	}
	
}
