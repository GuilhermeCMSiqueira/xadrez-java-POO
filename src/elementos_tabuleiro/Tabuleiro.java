package elementos_tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peça[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peça[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	public Peça peca(int linha, int coluna) {
		return pecas[linha][coluna];
		// Nesse método, vamos retornar a peça que se encontra naquela posição do tabuleiro, recebendo a linha e a coluna diretamente.
	}
	
	public Peça peca(Posição posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
		// Nesse método, vamos retornar a peça que se encontra naquela posição do tabuleiro recebendo a posição específica do tabuleiro.
	}
	
}
