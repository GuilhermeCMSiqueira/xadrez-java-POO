# Criação de um sistema do jogo xadrez utilizando conceitos de Programação Orientada ao Objeto

Nesse projeto, criei um sistema de xadrez utilizando a linguagem Java, o desenvolvimento do meu código se deu através de 4 pacotes (application, elementos_tabuleiro, xadrez, xadrez.peças) nos quais eu criei diversas classes que podem ser observadas nesse repositório. 

##Conceitos utilizados no projeto:

- Estruturas condicionais
- Estruturas repetitivas
- Funções
- Listas e Matrizes
- Enumerações
- Herança
- Downcasting
- Sobreposição
- Polimorfismo
- Classes e métodos abstratos
- Tratamento de exceções
- Encapsulamento
- Construtores
- Getters e Setters

##Passo a passo do desenvolvimento:

0) Criamos a classe Program do programa principal no pacote application.
1) Criação da Classe Posição utilizando os conceitos de encapsulamento (os atributos da classe são privados), Construtores (que serão utilizados na instanciação de todos os objetos de cada classe) e o método toString (utiliza o conceito de sobreposição, em que você sobrescreve o método toString da classe Object).
2) Criação das Classes Peça e Tabuleiro: Nessa etapa, acrescentamos o conceito de matrizes em nosso projeto pra representar o tabuleiro e também utilizamos métodos que possuem o estado "protected", permitindo assim ser apenas executados por subclasses e classes do mesmo pacote.
3) Criação do método para retornar as peças de cada posição do tabuleiro, início da utilização de tipos enumerados (para separar as peças brancas e pretas). Além disso, a criação da classe PeçaXadrez que vai ser uma classe que estende a classe Peça.
4) Criação da Classe PartidaXadrez que vai organizar as regras da nossa partida de xadrez. Criamos o tabuleiro que vai ser utilizado nela e realizamos o Downcasting de todas as peças da classe Peça para a classe PeçaXadrez.
5) Vamos instanciar a partida de xadrez no programa principal. Além disso, criamos a classe Visual para representar as partes gráficas do projeto, como a impressão do tabuleiro (método implementado nessa etapa)
Na etapa 4 e 5, podemos destacar os conceitos de herança, downcasting, membros estáticos, enumeração e encapsulamento.
6) Nessa etapa, colocamos as peças no tabuleiro (método de Colocar Peça na classe tabuleiro) e criamos as classes do Rei e da Torre. Além disso, vamos criar o método que gera o setup inicial da partida de xadrez.
7) Agora, vamos criar uma classe que é exceção personalizada pra prevenir erros na execução do nosso código. Também criamos métodos pra checar a existência de uma determinada posição e uma determinada peça no tabuleiro. Além disso, criamos condições pra evitar erros no código, aplicando a prática da programação defensiva.
8) Realização de um sistema pra realizar a organização do espaço do xadrez (utilização de letras e números nas coordenadas). Criação das classes ExceçaoXadrez e PosiçaoXadrez. Nessa classe, iremos realizar a conversão de posições genéricas de um tabuleiro para coordenadas de xadrez.
9) Melhoria nas impressão do tabuleiro, diferenciando peças brancas e pretas.
10) Realização das mecânicas de movimentação das peças. Criação de métodos como RemoverPeça e FazerMovimentoXadrez. Além disso, criar um método na classe Visual para ler a posição da peça. Aqui utilizaremos conceitos como encapsulamento, tratamento de exceções e downcasting.
11) Agora, vamos tratar exceções vistas nos movimentos e limpar a tela para deixar o andamento do programa mais limpo.
12) Iniciamos a lógica de possíveis movimentos de uma peça, utilizando uma matriz de valores booleanos com "True" nas casas que a peça pode chegar. Vamos usar o conceito de método abstrato, visto que temos diversos tipos de peça e cada uma se move de maneira diferente, implicando assim a necessidade de atualizar algumas classes para abstratas.
13) Implementação dos movimentos possíveis da torre, usando os conceitos de polimorfismo, encapsulamento e exceções. Além disso, foi criado um método para validar a posição de destino do nosso movimento.
14) Vamos começar a imprimir os movimentos possíveis de cada peça na hora do movimento. Nessa etapa, utilizamos o conceito de sobreposição de um método, visto que agora temos 2 possibilidades para imprimir o tabuleiro (com e sem os movimentos possíveis).
15) Agora, vamos implementar os movimentos do rei, utilizando os conceitos de polimorfismo e encapsulamento.
16) Adicionando a troca de jogadores por turno. Criando o esquema de turnos, jogador atual e um método para imprimir os dados da partida (tabuleiro, turno e jogador da vez).
17) Nessa etapa, vamos começar a manipular as peças capturadas. Vamos usar listas para guardar o conjunto de peças capturado 
pelos jogadores. Além disso, vamos separar em 2 listas as peças que ainda estão no tabuleiro, e as capturadas.
18) Agora, vamos realizar a lógica de xeque (seu rei está sob ameaça de pelo menos uma peça oponente, assim obrigando o ameaçado a sair dessa posição de xeque). Além disso, teremos que adicionar a lógica de forma que não é possível o jogador se colocar em xeque. Utilizaremos um método para desfazer os movimentos (que será utilizado caso o jogador se coloque em xeque)
19) Vamos implementar a regra do Xeque-Mate (que faz o jogo ser finalizado).
20) Criação de uma propriedade para contar o número de movimentos de cada peça, atributo que vai ser utilizado mais a frente (ex: primeiro movimento do peão).
21) Agora, faremos o desenvolvimento das peças restantes (Peão, Bispo, Rainha e Cavalo) utilizando os conceitos de herança, polimorfismo, encapsulamente, etc. Junto a isso, vamos atualizando o setup inicial de nosso tabuleiro.
22) Adição de jogadas especiais ao sistema (Roque, En passant e Promoção).
