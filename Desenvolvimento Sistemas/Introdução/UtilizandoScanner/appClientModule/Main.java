import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite seu nome: ");
		String nome = scanner.nextLine();
		System.out.println("O nome digitado foi: " + nome);
		
		
		
		scanner.close();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}