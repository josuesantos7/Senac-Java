import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Minha tabuada!!!");
		
		System.out.println("Digite o primeiro número para a operação");
		int numero = scanner.nextInt();
		
		System.out.println("Digite o segundo número para a operação");
		int numero2 = scanner.nextInt();
		
		if(numero >= 1 && numero <= 10 && numero2 >= 1 && numero2 <= 10) {
			if (numero > numero2) {
				System.out.println("MULTIPLICAÇÃO");
				System.out.println("Operação: " + numero2 + " x " + "1" + " = " + (numero * 1));
				System.out.println("Operação: " + numero2 + " x " + "2" + " = " + (numero * 2));
				System.out.println("Operação: " + numero2 + " x " + "3" + " = " + (numero * 3));
				System.out.println("Operação: " + numero2 + " x " + "4" + " = " + (numero * 4));
				System.out.println("Operação: " + numero2 + " x " + "5" + " = " + (numero * 5));
				System.out.println("Operação: " + numero2 + " x " + "6" + " = " + (numero * 6));
				System.out.println("Operação: " + numero2 + " x " + "7" + " = " + (numero * 7));
				System.out.println("Operação: " + numero2 + " x " + "8" + " = " + (numero * 8));
				System.out.println("Operação: " + numero2 + " x " + "9" + " = " + (numero * 9));
				System.out.println();
				
				System.out.println("Operação: " + numero + " x " + "1" + " = " + (numero * 1));
				System.out.println("Operação: " + numero + " x " + "2" + " = " + (numero * 2));
				System.out.println("Operação: " + numero + " x " + "3" + " = " + (numero * 3));
				System.out.println("Operação: " + numero + " x " + "4" + " = " + (numero * 4));
				System.out.println("Operação: " + numero + " x " + "5" + " = " + (numero * 5));
				System.out.println("Operação: " + numero + " x " + "6" + " = " + (numero * 6));
				System.out.println("Operação: " + numero + " x " + "7" + " = " + (numero * 7));
				System.out.println("Operação: " + numero + " x " + "8" + " = " + (numero * 8));
				System.out.println("Operação: " + numero + " x " + "9" + " = " + (numero * 9));
				System.out.println();
				
				
				
			}else {
				System.out.println("MULTIPLICAÇÃO");
				System.out.println("Operação: " + numero + " x " + "1" + " = " + (numero * 1));
				System.out.println("Operação: " + numero + " x " + "2" + " = " + (numero * 2));
				System.out.println("Operação: " + numero + " x " + "3" + " = " + (numero * 3));
				System.out.println("Operação: " + numero + " x " + "4" + " = " + (numero * 4));
				System.out.println("Operação: " + numero + " x " + "5" + " = " + (numero * 5));
				System.out.println("Operação: " + numero + " x " + "6" + " = " + (numero * 6));
				System.out.println("Operação: " + numero + " x " + "7" + " = " + (numero * 7));
				System.out.println("Operação: " + numero + " x " + "8" + " = " + (numero * 8));
				System.out.println("Operação: " + numero + " x " + "9" + " = " + (numero * 9));
				System.out.println();
				
				System.out.println("Operação: " + numero2 + " x " + "1" + " = " + (numero * 1));
				System.out.println("Operação: " + numero2 + " x " + "2" + " = " + (numero * 2));
				System.out.println("Operação: " + numero2 + " x " + "3" + " = " + (numero * 3));
				System.out.println("Operação: " + numero2 + " x " + "4" + " = " + (numero * 4));
				System.out.println("Operação: " + numero2 + " x " + "5" + " = " + (numero * 5));
				System.out.println("Operação: " + numero2 + " x " + "6" + " = " + (numero * 6));
				System.out.println("Operação: " + numero2 + " x " + "7" + " = " + (numero * 7));
				System.out.println("Operação: " + numero2 + " x " + "8" + " = " + (numero * 8));
				System.out.println("Operação: " + numero2 + " x " + "9" + " = " + (numero * 9));
				System.out.println();
			
				
			}
			
			
//			System.out.println("DIVISÃO");
//			System.out.println("Operação: " + numero + " / " + "1" + " = " + (numero / 1));
//			System.out.println("Operação: " + numero + " / " + "2" + " = " + (numero / 2));
//			System.out.println("Operação: " + numero + " / " + "3" + " = " + (numero / 3));
//			System.out.println("Operação: " + numero + " / " + "4" + " = " + (numero / 4));
//			System.out.println("Operação: " + numero + " / " + "5" + " = " + (numero / 5));
//			System.out.println("Operação: " + numero + " / " + "6" + " = " + (numero / 6));
//			System.out.println("Operação: " + numero + " / " + "7" + " = " + (numero / 7));
//			System.out.println("Operação: " + numero + " / " + "8" + " = " + (numero / 8));
//			System.out.println("Operação: " + numero + " / " + "9" + " = " + (numero / 9));
		
		} else {
			System.err.println("Valor inválido");
		}
		scanner.close();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}