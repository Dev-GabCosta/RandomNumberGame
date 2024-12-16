import java.util.Random;
import java.util.Scanner;

public class Main {
	private static final Random RANDOM = new Random();
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int range = 15;
		int computerNumber = RANDOM.nextInt(range);
		int userNumber;
		int totalUserPoints = 0;
		boolean isCorrect = false;
		System.out.println("Olá, seja bem-vindo ao jogo de adivinhação!");
		System.out.println("Antes de começarmos, deixa eu te explicar as regras do jogo.");
		System.out.println("Obviamente, você jogará contra mim, 'Computador, o grande'...");
		System.out.println("Então, funciona assim: vou 'pensar' em um número, e você tem que adivinhar qual é o número que eu 'pensei'. Você é capaz de acertar? Mas tem mais. Se você acertar o número, você ganha 10 pontos. Se você passar perto, acertando um número pra cima ou pra baixo, você ganha 5 pontos. Sim, eu concordo, está fácil demais pra você. Só não te falei que se você não passar nem perto, você não ganha nada!");
		int i = 0;
		do {

			if (i == 0) {
				System.out.println("Então vamos lá! Em que número você acha que eu estou pensando? tic tac, tic tac...");
				userNumber = input.nextInt();
			} else {
				System.out.println("Vamos de novo. Qual número você escolhe agora?");
				userNumber = input.nextInt();
			}

			i++;

			int result = comparesNumbers(computerNumber, userNumber);

			if (result != 0) {
				totalUserPoints += result;
			}

			displayMessage(computerNumber, result, totalUserPoints);

			if (result == 10) {
				isCorrect = true;
			}

			if (isCorrect) {
				System.out.println("Você acertou o número que eu estava 'pensando'. Quer continuar jogando? (1 para sim, 0 para não)");
				int answer = input.nextInt();

				if (answer == 1) {

					computerNumber = RANDOM.nextInt(15);
					isCorrect = false;
					i = 0;
					totalUserPoints = 0;
				}

			}

		} while (!isCorrect);

	}

	private static int comparesNumbers(int computer, int user) {
		int userPoint;

		if (user == computer) {
			userPoint = 10;
		} else if (user == computer - 1 || user == computer + 1) {
			userPoint = 5;
		} else {
			userPoint = 0;
		}

		return userPoint;
	}

	private static void displayMessage(int computerNumber, int result, int totalUserPoints) {

		if (result == 0) {
			System.out.println("Que pena, você errou feio! Na verdade eu estava 'pensando' no número " + computerNumber);
		} else {
			System.out.println("Oba! Você ganhou " + result + " pontos.");
		}

		System.out.println("Total de pontos: " + totalUserPoints);
	}

}
