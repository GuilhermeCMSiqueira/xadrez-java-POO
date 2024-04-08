package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import elementos_tabuleiro.Peça;
import elementos_tabuleiro.Posição;
import elementos_tabuleiro.Tabuleiro;
import xadrez.pecas.Bispo;
import xadrez.pecas.Peao;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean check;
	private boolean checkmate;
	
	private List<Peça> peçasTabuleiro = new ArrayList<>();
	private List<Peça> peçasCapturadas = new ArrayList<>();
	
	public PartidaXadrez() {
		tabuleiro = new Tabuleiro(8,8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		setupInicial();
	}
	
	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckmate() {
		return checkmate;
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
		
		if (testeCheck((jogadorAtual))) {
			desfazerMovimento(origem, fim, pecaCapturada);
			throw new ExceçaoXadrez("Você não pode se colocar em check.");
			
		}
		
		// Operador condicional ternário:
		check = (testeCheck(oponente(jogadorAtual))) ? true : false;
		
		if (testeCheckmate(oponente(jogadorAtual))) {
			checkmate = true;
		}
		else {
			proximoTurno();
		}
		
		return (PeçaXadrez)pecaCapturada;
	}
	
	private void desfazerMovimento(Posição origem, Posição fim, Peça pecaCapturada) {
		PeçaXadrez p = (PeçaXadrez)tabuleiro.removerPeça(fim);
		p.diminuirMovimentos();
		tabuleiro.colocarPeça(p, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.colocarPeça(pecaCapturada, fim);
			peçasCapturadas.remove(pecaCapturada);
			peçasTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validarPosiçaoInicial(Posição posicao) {
		if (!tabuleiro.peçaExiste(posicao)) {
			throw new ExceçaoXadrez("Não existe peça na posição de origem.");
		}
		if(jogadorAtual != ((PeçaXadrez)tabuleiro.peca(posicao)).getCor()) {
			throw new ExceçaoXadrez("Essa peça não corresponde a sua cor.");
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
		PeçaXadrez p = (PeçaXadrez)tabuleiro.removerPeça(origem);
		p.aumentarMovimentos();
		Peça pecaCapturada = tabuleiro.removerPeça(fim);
		tabuleiro.colocarPeça(p, fim);
		
		if (pecaCapturada != null) {
			peçasTabuleiro.remove(pecaCapturada);
			peçasCapturadas.add(pecaCapturada);
		}
		return pecaCapturada;
	}
	
	
	private void colocarNovaPeça(char coluna, int linha, PeçaXadrez peca) {
		tabuleiro.colocarPeça(peca, new PosiçaoXadrez(coluna, linha).converterPosicao());
		peçasTabuleiro.add(peca);
	} // Método utilizado para colocarmos as peças no tabuleiro utilizando coordenadas de xadrez e não numeros
	
	private void proximoTurno() {
		turno++;
		if (jogadorAtual == Cor.BRANCO) {
			jogadorAtual = Cor.PRETO;
		}
		else {
			jogadorAtual = Cor.BRANCO;
		}
	}
	
	private Cor oponente(Cor cor) {
		if (cor == Cor.BRANCO) {
			return Cor.PRETO;
		}
		else {
			return Cor.BRANCO;
		}
	}
	
	private PeçaXadrez rei(Cor cor) {
		List<Peça> lista = peçasTabuleiro.stream().filter(x -> ((PeçaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peça p: lista) {
			if (p instanceof Rei) {
				return (PeçaXadrez)p;
			}
		}
		throw new IllegalStateException("Não existe rei " + cor + " no tabuleiro.");
	}
	
	private boolean testeCheck(Cor cor) {
		Posição posicaoRei = rei(cor).getPosiçaoXadrez().converterPosicao();
		List<Peça> peçasOponentes = peçasTabuleiro.stream().filter(x -> ((PeçaXadrez)x).getCor() == oponente(cor)).collect(Collectors.toList());
		for (Peça p: peçasOponentes) {
			boolean[][] mat = p.movimentosPossiveis();
			if (mat[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}	
		} 
		return false;
	}
	
	private boolean testeCheckmate(Cor cor) {
		if (!testeCheck(cor)) {
			return false;
		}
		List<Peça> lista = peçasTabuleiro.stream().filter(x -> ((PeçaXadrez)x).getCor() == cor).collect(Collectors.toList());
		for (Peça p: lista) {
			boolean[][] mat = p.movimentosPossiveis();
			for (int i = 0; i < tabuleiro.getLinhas(); i++) {
				for (int j = 0; j < tabuleiro.getColunas(); j++) {
					if (mat[i][j]) {
						Posição origem = ((PeçaXadrez)p).getPosiçaoXadrez().converterPosicao();
						Posição fim = new Posição(i, j);
						Peça pecaCapturada = fazerMovimento(origem, fim);
						boolean testeCheck = testeCheck(cor);
						desfazerMovimento(origem, fim, pecaCapturada);
						if(!testeCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	private void setupInicial(){

        colocarNovaPeça('a', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('h', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('e', 1, new Rei(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('a', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('b', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('c', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('d', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('e', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('f', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('g', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('h', 2, new Peao(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('c', 1, new Bispo(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('f', 1, new Bispo(tabuleiro, Cor.BRANCO));

        colocarNovaPeça('a', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeça('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeça('h', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeça('a', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('b', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('c', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('d', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('e', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('f', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('g', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('h', 7, new Peao(tabuleiro, Cor.PRETO));
        colocarNovaPeça('c', 8, new Bispo(tabuleiro, Cor.PRETO));
        colocarNovaPeça('f', 8, new Bispo(tabuleiro, Cor.PRETO));
	}
	
	
}
