import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random randon = new Random();
		
		int numeroSecreto = randon.nextInt(19) + 1; // 1 a 20
		
//		System.out.println(numeroSecreto);
		
		int palpite;
		int tentativas = 0;
		
		System.out.println("=== Jogo da advinhação ===");
		System.out.println("Tentando adivinhar um número de 1 a 20 ...\n");
		
		do {
			System.out.println("Digite seu palpite: ");
			palpite = scanner.nextInt();
			
			tentativas++;
			
			if(palpite < numeroSecreto) {
				System.out.println("Muito baixo!, Tente um número maior");
			}else if (palpite > numeroSecreto) {
				System.out.println("Muito alto, Tente um número menor");
			} else {
				System.out.println("Parabéns!, Você acertou! e em " + tentativas + " tentativas." );
			}
			
		}while (palpite != numeroSecreto);
		scanner.close();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}