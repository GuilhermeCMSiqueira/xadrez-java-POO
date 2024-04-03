package elementos_tabuleiro;

public class ExceçaoTabuleiro extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExceçaoTabuleiro(String msg) {
		super(msg);
	}
}
