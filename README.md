# Criação de um sistema do jogo xadrez utilizando conceitos de Programação Orientada ao Objeto

**Desenvolvimento do Trabalho**
1. Criação dos elementos do tabuleiro, elementos específicos do xadrez e o método de impressão do tabuleiro
O trabalho começou com a criação da estrutura inicial do jogo de xadrez, incluindo a construção do tabuleiro e a definição dos elementos básicos, como peças e suas representações. O método de impressão foi desenvolvido para facilitar a visualização do tabuleiro.

2. Início da criação de peças (rei e torre) e organização inicial do tabuleiro
O próximo passo foi a implementação das peças iniciais, começando pelo rei e a torre, além de uma organização básica do tabuleiro.

3. Início da criação das peças específicas (rei e torre) e organização inicial do tabuleiro
A criação das peças foi continuada, dando ênfase nas funcionalidades básicas do rei e da torre, e como elas interagem com o tabuleiro.

4. Adicionando exceções e programação defensiva
A etapa seguinte envolveu o tratamento de exceções para garantir que movimentos inválidos ou situações inesperadas fossem devidamente tratados pelo sistema.

5. Desenvolvimento das mecânicas de movimentação
Foram implementadas as primeiras mecânicas de movimentação das peças, incluindo os métodos necessários para determinar os movimentos válidos para cada tipo de peça.

6. Adição de métodos para conversão de coordenadas genéricas para coordenadas de xadrez
A seguir, foi desenvolvida a lógica para conversão de coordenadas genéricas para coordenadas padrão de xadrez, facilitando a movimentação das peças no tabuleiro.

7. Aperfeiçoando o print do tabuleiro adicionando cores
A aparência visual do tabuleiro foi melhorada ao adicionar cores nos prints, tornando a interface mais amigável e fácil de ler.

8. Adição da lógica de xeque-mate
Implementação da lógica para detectar e gerenciar a condição de xeque-mate, que é um elemento chave no final de uma partida de xadrez.

9. Adição da mecânica de check
Foi implementada a mecânica de "check", permitindo que o jogo detectasse quando o rei está em cheque, o que é um passo necessário para a vitória.

10. Adição do contador de movimentos por peça
Para tornar o jogo mais dinâmico, foi introduzido um contador de movimentos para cada peça, possibilitando o controle do número de movimentos realizados por cada peça.

11. Manipulando peças capturadas
Foi implementada a lógica para capturar peças, movendo-as para uma área específica, além de uma gestão interna dessas peças capturadas.

12. Trocando os jogadores por turno
A mecânica de alternância entre os jogadores foi implementada, permitindo que o jogo se movesse de forma interativa entre os dois participantes.

13. Movimentos possíveis do rei
A lógica específica para os movimentos do rei foi adicionada, respeitando as regras de movimentação dessa peça, incluindo os movimentos básicos e especiais.

14. Imprimindo os movimentos possíveis na tela
Foi implementada a funcionalidade de exibir os movimentos possíveis de cada peça no tabuleiro, facilitando a interação do jogador com o sistema.

15. Adicionando os possíveis movimentos da torre
A torre foi programada com os movimentos específicos e restrições, além de ser integrada com o sistema de exibição de movimentos possíveis.

16. Início da lógica de movimentos possíveis de uma peça
A lógica básica para verificar os movimentos válidos de qualquer peça foi iniciada, criando a fundação para as regras de movimentação no jogo.

17. Tratamento de exceções dos movimentos e limpeza de tela durante a execução
O tratamento de exceções foi ampliado para garantir que qualquer erro durante os movimentos das peças fosse corretamente gerenciado, e a limpeza de tela foi otimizada.

18. Desenvolvimento das jogadas especiais (Roque, En Passant e Promoção)
Foram implementadas as jogadas especiais do xadrez, como Roque, En Passant e Promoção, que adicionam complexidade ao jogo e tornam a jogabilidade mais rica.

19. Criação das classes de peças específicas (Rainha, Cavalo, Bispo, Peão)
A criação das classes de peças foi expandida para incluir a Rainha, Cavalo, Bispo e Peão, cada uma com suas características e comportamentos únicos.

**O que eu aprendi e utilizei de Programação Orientada a Objetos**

- Durante o desenvolvimento desse projeto, utilizei conceitos fundamentais de Programação Orientada a Objetos (POO) para estruturar o código de forma eficiente e modular. Cada peça do jogo de xadrez foi representada como uma classe, com suas propriedades (como posição, cor, tipo) e métodos (como movimentos válidos e captura). A herança foi usada para criar classes específicas para cada tipo de peça (como Rei, Torre, Rainha, etc.), reutilizando código comum, enquanto polimorfismo permitiu que diferentes peças tivessem implementações distintas de movimentos. O encapsulamento foi essencial para esconder os detalhes internos das peças e manter o código organizado, facilitando a manutenção e a evolução do jogo.

- Além disso, o uso de exceções foi importante para garantir que o sistema fosse robusto e capaz de lidar com entradas inválidas ou estados inesperados durante a partida. O desenvolvimento também exigiu uma boa organização do código, onde a lógica de movimentação, verificação de xeque e mate, além das jogadas especiais, foram devidamente distribuídas entre as classes para manter a clareza e o controle do fluxo do jogo.

-Por fim, esse projeto reforçou a importância de seguir os princípios de POO para construir soluções escaláveis e reutilizáveis, além de aprimorar minha habilidade de pensar em termos de objetos e interações em sistemas mais complexos.
