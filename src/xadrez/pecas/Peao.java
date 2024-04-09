package xadrez.pecas;

import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;

public class Peao extends PeçaXadrez{
	
	private PartidaXadrez partida;

	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
		super(tabuleiro, cor);
		this.partida = partida;
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
		
		// En Passant do peão branco
		if (posicao.getLinha() == 3) {
			Posição esquerda = new Posição(posicao.getLinha(), posicao.getColuna() - 1);
			if(getTabuleiro().posicaoExiste(esquerda) && temPeçaOponente(esquerda) && getTabuleiro().peca(esquerda) == partida.getVulnerabilidadeEnPassant()) {
				mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
			}
			
			Posição direita = new Posição(posicao.getLinha(), posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(direita) && temPeçaOponente(direita) && getTabuleiro().peca(direita) == partida.getVulnerabilidadeEnPassant()) {
				mat[direita.getLinha() - 1][direita.getColuna()] = true;
			}
		}
		
		// En Passant do peão preto
		if (posicao.getLinha() == 4) {
			Posição esquerda = new Posição(posicao.getLinha(), posicao.getColuna() - 1);
			if(getTabuleiro().posicaoExiste(esquerda) && temPeçaOponente(esquerda) && getTabuleiro().peca(esquerda) == partida.getVulnerabilidadeEnPassant()) {
				mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
			}
			
			Posição direita = new Posição(posicao.getLinha(), posicao.getColuna() + 1);
			if(getTabuleiro().posicaoExiste(direita) && temPeçaOponente(direita) && getTabuleiro().peca(direita) == partida.getVulnerabilidadeEnPassant()) {
				mat[direita.getLinha() + 1][direita.getColuna()] = true;
			}
		}
		
		return mat;
	}
	
}
