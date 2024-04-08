package xadrez;

import elementos_tabuleiro.Peça;
import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private Tabuleiro tabuleiro;
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		setupInicial();
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
	
	public boolean[][] movimentosPossiveis(PosiçaoXadrez origem){
		Posição posicao = origem.converterPosicao();
		validarPosiçaoInicial(posicao);
		return tabuleiro.peca(posicao).movimentosPossiveis();
		}
	
	public PeçaXadrez fazerMovimentoXadrez (PosiçaoXadrez origemP, PosiçaoXadrez fimP) {
		// vamos converter os argumentos da função para a linguagem de tabuleiro
		Posição origem = origemP.converterPosicao();
		Posição fim = fimP.converterPosicao();
		validarPosiçaoInicial(origem);
		validarPosiçaoFinal(origem, fim);
		Peça pecaCapturada = fazerMovimento(origem, fim);
		return (PeçaXadrez)pecaCapturada;
		
	}
	
	private void validarPosiçaoInicial(Posição posicao) {
		if (!tabuleiro.peçaExiste(posicao)) {
			throw new ExceçaoXadrez("Não existe peça na posição de origem.");
		}
		if(!tabuleiro.peca(posicao).qualquerMovimentoPossivel()) {
			throw new ExceçaoXadrez("Não existe movimentos possíveis para a peça escolhida.");
		}
	}
	
	public void validarPosiçaoFinal(Posição origem, Posição fim) {
		if (!tabuleiro.peca(origem).movimentoPossivel(fim)) {
			throw new ExceçaoXadrez("A peça escolhida não pode se mover para esse local.");
		}
	}
	
	
	private Peça fazerMovimento(Posição origem, Posição fim) {
		Peça p = tabuleiro.removerPeça(origem);
		Peça pecaCapturada = tabuleiro.removerPeça(fim);
		tabuleiro.colocarPeça(p, fim);
		return pecaCapturada;
	}
	
	
	private void colocarNovaPeça(char coluna, int linha, PeçaXadrez peca) {
		tabuleiro.colocarPeça(peca, new PosiçaoXadrez(coluna, linha).converterPosicao());
	} // Método utilizado para colocarmos as peças no tabuleiro utilizando coordenadas de xadrez e não numeros
	
	
	
	private void setupInicial(){

		colocarNovaPeça('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeça('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeça('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeça('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeça('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		colocarNovaPeça('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		colocarNovaPeça('c', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeça('c', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeça('d', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeça('e', 7, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeça('e', 8, new Torre(tabuleiro, Cor.PRETO));
		colocarNovaPeça('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
	
	
}
