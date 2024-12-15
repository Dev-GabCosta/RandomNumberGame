import java.util.Random;
import java.util.Scanner;

public class Main {
	private static final Random RANDOM = new Random();
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int range = 15;
		int computerNumber = RANDOM.nextInt(range);
		System.out.println("Olá, seja bem-vindo ao jogo de adivinhação!");
		System.out.println("Antes de começarmos, deixa eu te explicar as regras do jogo.");
		System.out.println("Obviamente, você jogará contra mim, 'Computador, o grande'...");
		System.out.println("Então, funciona assim: vou 'pensar' em um número, e você tem que adivinhar qual é o número que eu 'pensei'. Você é capaz de acertar? Mas tem mais. Se você acertar o número, você ganha 10 pontos. Se você passar perto, acertando um número pra cima ou pra baixo, você ganha 5 pontos. Sim, eu concordo, está fácil demais pra você. Só não te falei que se você não passar nem perto, você não ganha nada!");
		System.out.println("Então vamos lá. Vamos ver se você é bom nisso. Em que número você acha que eu estou pensando? tic tac, tic tac...");
		int userNumber = input.nextInt();
		System.out.println(comparesNumbers(computerNumber, userNumber));
	}

	private static String comparesNumbers(int computer, int user) {
		String computerSpeak;
		int userPoint;

		if (user == computer) {
			userPoint = 10;
			computerSpeak = "Uau! Estou impressionado com seu feito! Mas te digo: isso foi só sorte. Na próxima eu venço!";
		} else if (user == computer - 1 || user == computer + 1) {
			userPoint = 5;
			computerSpeak = "É, você até que foi bem. Quem sabe na próxima você consegue atingir meu nível!";
		} else {
			userPoint = 0;
			computerSpeak = "Oh não! Isso foi terrível! Você realmente precisa melhorar pra competirmos de igual pra igual.";
		}

		return computerSpeak +
				       " Você ganhou " + userPoint + " pontos. Na verdade eu estava 'pensando' no número " + computer;
	}
}
