import java.util.Random;
import java.util.Scanner;

public class Main {
	private static final Random RANDOM = new Random();
	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int computerNumber = generateNumber(9);
		int[] correctNumbers = new int[50];
		int[] wrongNumbers = new int[50];
		int userNumber = 0;
		int totalUserPoints = 0;
		boolean isCorrect = false;
		System.out.println("Olá, seja bem-vindo ao jogo de adivinhação!");
		System.out.println("Antes de começarmos, deixa eu te explicar as regras do jogo.");
		System.out.println("Obviamente, você jogará contra mim, 'Computador, o grande'...");
		System.out.println("Então, funciona assim: vou 'pensar' em um número, e você tem que adivinhar qual é o número que eu 'pensei'. Você é capaz de acertar? Mas tem mais. Se você acertar o número, você ganha 10 pontos. Se você passar perto, acertando um número pra cima ou pra baixo, você ganha 5 pontos. Sim, eu concordo, está fácil demais pra você. Só não te falei que se você não passar nem perto, você não ganha nada!");
		int level = 1;
		int i = 0;
		int countSuccesses = 0;
		int countErrors = 0;

		do {

			if (i == 0) {
				System.out.println("Então vamos lá! Em que número você acha que eu estou pensando? tic tac, tic tac...");
				System.out.println("Nível: fácil. Nesse nível, você escolhe números de 1 a 10.");
				userNumber = input.nextInt();
			} else {
				givTip(computerNumber, userNumber, level);
				System.out.println("Vamos de novo. Qual número você escolhe agora?");
				userNumber = input.nextInt();
			}

			i++;
			int result = comparesNumbers(computerNumber, userNumber);

			if (result != 0) {
				totalUserPoints += result;
			}

			displayMessage(result, totalUserPoints);

			if (result == 10) {
				isCorrect = true;
				correctNumbers[countSuccesses] = userNumber;
				countSuccesses++;
			} else {
				wrongNumbers[countErrors] = userNumber;
				countErrors++;
			}


			if(level== 3 && isCorrect == true) {
				break;
			}

			if (isCorrect) {
				System.out.println("Você acertou o número que eu estava 'pensando'. Quer continuar jogando? (1 para sim, 0 para não)");
				int answer = input.nextInt();

				if (answer == 1) {
					isCorrect = false;
				} else {
					break;
				}

				level++;

				switch (level) {
					case 2:
						System.out.println("Hmm, você foi bem até aqui. Reconheço: você tem coragem ao continuar. Mas já aviso   que ficará um pouco mais difícil.");
						System.out.println("Nível: médio. Agora você escolhe números de 1 a 50.");
						computerNumber = generateNumber(49);
						break;
					case 3:
						System.out.println("Ok, admito. Você é bom!");
						System.out.println("Então você quer continuar, não é? Te respeito por sua coragem, mas acho que você vai se arrepender dessa escolha.");
						System.out.println("Nível: difícil. Aqui, você pode escolher números de 1 a 100.");
						computerNumber = RANDOM.nextInt(99);
						break;
					default:
						break;
				}

			}

		} while (!isCorrect);

		System.out.printf("Ok, Esses foram seus resultados finais:\n");
		displaySummary(countSuccesses, countErrors, correctNumbers, wrongNumbers);
		System.out.println("Espero que tenha se divertido! Até a próxima!");
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

	private static void displayMessage(int result, int totalUserPoints) {

		if (result == 0) {
			System.out.println("Que pena, você errou feio!");
		} else if (result == 5) {
			System.out.println("Você foi bem! Quase acertou. Por isso, você ganhou " + result + " pontos.");
		} else {
			System.out.println("Uau! Muito bem! Você ganhou " + result + "  pontos.");
		}

		System.out.println("Total de pontos: " + totalUserPoints);
	}

	private static void givTip(int computer, int user, int level) {
		String message = "";
		int interval;

		if (level == 1) {
			interval = 3;

			if (computer - user >= interval) {
				message = "O número que eu escolhi é maior";
			}

			if (user - computer >= interval) {
				message = "O número que eu escolhi é menor";
			}

		}

		if (level == 2) {
			interval = 6;

			if (computer - user >= interval) {
				message = "O número que eu escolhi é maior";
			}

			if (user - computer >= interval) {
				message = "O número que eu escolhi é menor";
			}

		}

		if (level == 3) {
			interval = 10;

			if (computer - user >= interval) {
				message = "O número que eu escolhi é maior";
			}

			if (user - computer >= interval) {
				message = "O número que eu escolhi é menor";
			}

		}

		System.out.println(message);
	}

	private static void displaySummary(int successes, int errors, int[] correctNumbers, int[] wrongNumbers) {

		if (successes == 1) {
			System.out.printf("Você acertou o número %d ", correctNumbers[0]);
		} else {
			System.out.printf("Você acertou os números");

			for (int n = 0; n < successes; n++) {
				System.out.printf(" %d, ", correctNumbers[n]);
			}

			System.out.printf("%d", correctNumbers[successes]);
		}

		if (errors == 1) {
			System.out.printf("e errou o número %d", wrongNumbers[0]);
		} else if (errors > 1) {
			System.out.printf(" e errou os números");

			for (int n = 0; n < errors - 1; n++) {
				System.out.printf("%d, ", wrongNumbers[n]);
			}

			System.out.printf("%d.\n", wrongNumbers[errors - 1]);
		} else {
			System.out.printf(" e não errou nenhum número. Parabéns!");
		}

	}

	private static int generateNumber(int number) {
		return RANDOM.nextInt(number) + 1;
	}

}
