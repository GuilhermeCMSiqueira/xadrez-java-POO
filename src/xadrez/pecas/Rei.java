package xadrez.pecas;

import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;

public class Rei extends PeçaXadrez{

	private PartidaXadrez partida;
	
	
	public Rei(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
		super(tabuleiro, cor);
		this.partida = partida;
	}

	@Override
	public String toString() {
		return "K";
		// Vamos utilizar o toString pra imprimir o tabuleiro
	}
	
	private boolean podeMover(Posição posicao) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peca(posicao);
		return p == null || p.getCor() != getCor();	 
		}
	
	private boolean testeRoque(Posição posicao) {
		PeçaXadrez p = (PeçaXadrez)getTabuleiro().peca(posicao);
		return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContadorMovimentos() == 0;
		}

	@Override
	public boolean[][] movimentosPossiveis() {
		// ele pode andar 1 casa para todas as direções
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posição p = new Posição(0,0);
		
		// pra cima
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// pra baixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// pra esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
	
		// pra direita
		p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Noroeste
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Nordeste
		p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Sudoeste
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Sudeste
		p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().posicaoExiste(p) && podeMover(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// JOGADA ESPECIAL ROQUE
		if (getContadorMovimentos() == 0 && !partida.getCheck()) {
			// Roque pequeno
			Posição posicao_torre1 = new Posição(posicao.getLinha(), posicao.getColuna() + 3);
			if (testeRoque(posicao_torre1)) {
				Posição p1 = new Posição(posicao.getLinha(), posicao.getColuna() + 1);
				Posição p2 = new Posição(posicao.getLinha(), posicao.getColuna() + 2);
				if (getTabuleiro().peca(p1) == null && getTabuleiro().peca(p2) == null) {
					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
				}
				
			// Roque grande
			Posição posicao_torre2 = new Posição(posicao.getLinha(), posicao.getColuna() - 4);
			if (testeRoque(posicao_torre2)) {
				Posição p3 = new Posição(posicao.getLinha(), posicao.getColuna() - 1);
				Posição p4 = new Posição(posicao.getLinha(), posicao.getColuna() - 2);
				Posição p5 = new Posição(posicao.getLinha(), posicao.getColuna() - 3);
				if (getTabuleiro().peca(p3) == null && getTabuleiro().peca(p4) == null && getTabuleiro().peca(p5) == null) {
					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
				
			}	
			
		}
			
		
		return mat;
	}
}
