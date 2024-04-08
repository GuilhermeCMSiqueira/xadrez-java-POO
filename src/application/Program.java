package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import xadrez.ExceçaoXadrez;
import xadrez.PartidaXadrez;
import xadrez.PeçaXadrez;
import xadrez.PosiçaoXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PartidaXadrez partida = new PartidaXadrez();
		List<PeçaXadrez> capturados = new ArrayList<>();
		
		while(true) {
			try {
				Visual.limparTela();
				Visual.printPartida(partida, capturados);
				System.out.println();
				System.out.println("Origem: ");
				PosiçaoXadrez origem = Visual.lerPosiçaoXadrez(sc);
				
				boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
				Visual.limparTela();
				Visual.printTabuleiro(partida.verPeças(), movimentosPossiveis);
				
				System.out.println();
				System.out.println("Fim do movimento: ");
				PosiçaoXadrez fim = Visual.lerPosiçaoXadrez(sc);
				
				PeçaXadrez pecaCapturada = partida.fazerMovimentoXadrez(origem, fim);
				
				if (pecaCapturada != null) {
					capturados.add(pecaCapturada);
				}
			}
			catch (ExceçaoXadrez e){
				System.out.println(e.getMessage());
				sc.nextLine();			}
			}
		}
		
	}


