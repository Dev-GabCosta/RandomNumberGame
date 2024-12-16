# Jogo de Adivinhação em Java

Este é um jogo de adivinhação simples desenvolvido em Java. O objetivo do jogo é adivinhar um número gerado aleatoriamente pelo computador.

## Funcionamento

O jogo funciona da seguinte maneira:

1. O computador gera um número aleatório entre 1 e 10.
2. O usuário tenta adivinhar o número.
3. O computador fornece uma dica sobre o número, indicando se o número é maior ou menor que o chute do usuário.
4. O usuário pode continuar tentando adivinhar o número até acertar.
5. Se o usuário acertar o número, ele ganha 10 pontos. Se o usuário estiver perto do número (um número acima ou abaixo), ele ganha 5 pontos.
6. O jogo continua até que o usuário atinja o nível 3, onde o número é gerado entre 1 e 100, e o usuário precisa acertar o número para ganhar.

## Classes e Métodos

A classe `Main` contém os seguintes métodos:

* `main`: o método principal do jogo, responsável por iniciar o jogo e gerenciar o fluxo de execução.
* `comparesNumbers`: compara o número gerado pelo computador com o chute do usuário e retorna a pontuação.
* `displayMessage`: exibe a mensagem de feedback para o usuário, indicando se ele acertou ou errou.
* `givTip`: fornece uma dica sobre o número, indicando se o número é maior ou menor que o chute do usuário.
* `displaySummary`: exibe um resumo do jogo, incluindo os números acertados e errados.

## Variáveis e Constantes

A classe `Main` utiliza as seguintes variáveis e constantes:

* `RANDOM`: uma instância da classe `Random`, utilizada para gerar números aleatórios.
* `input`: uma instância da classe `Scanner`, utilizada para ler a entrada do usuário.
* `computerNumber`: o número gerado pelo computador.
* `userNumber`: o chute do usuário.
* `totalUserPoints`: a pontuação total do usuário.

## Compilação e Execução

Para compilar e executar o jogo, basta executar o comando `javac Main.java` e, em seguida, `java Main`. O jogo será iniciado e você pode começar a jogar.