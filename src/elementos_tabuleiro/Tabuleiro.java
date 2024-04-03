package elementos_tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peça[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new ExceçaoTabuleiro("Erro criando o tabuleiro. É necessário que haja pelo menos 1 linha e 1 coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peça[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public Peça peca(int linha, int coluna) {
		if (!posicaoExiste(linha, coluna)) {
			throw new ExceçaoTabuleiro("Posição inexistente.");
		}
		return pecas[linha][coluna];
		// Nesse método, vamos retornar a peça que se encontra naquela posição do tabuleiro, recebendo a linha e a coluna diretamente.
	}
	
	public Peça peca(Posição posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExceçaoTabuleiro("Posição inexistente.");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
		// Nesse método, vamos retornar a peça que se encontra naquela posição do tabuleiro recebendo a posição específica do tabuleiro.
	}
	
	public void colocarPeça(Peça peca, Posição posicao) {
		if (peçaExiste(posicao)) {
			throw new ExceçaoTabuleiro("Já existe uma peça nesse local.");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public boolean posicaoExiste(int linha, int coluna){
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean posicaoExiste(Posição posicao){
		return posicaoExiste(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean peçaExiste(Posição posicao) {
		if (!posicaoExiste(posicao)) {
			throw new ExceçaoTabuleiro("Posição inexistente.");
		}
		return peca(posicao) != null;
	}
	
}
