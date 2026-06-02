
public class Main {
	public static void main(String[] args) {
		
		int numero1 = 15;
		int numero2 = 2;
		
		System.out.println("########## Minha Calculadora Com Métodos ##########");
		System.out.println("A soma de: " + numero1 + " + " + numero2 + " = " + somar(numero1, numero2));
		resultado(" + ", numero1, numero2);
		
		System.out.println("A subtração de: " + numero1 + " - " + numero2 + " = " + subtrair(numero1, numero2));
		
		System.out.println("A divisão de: " + numero1 + " / " + numero2 + " = " + dividir(numero1, numero2));
		
		System.out.println("A multiplicação de: " + numero1 + " * " + numero2 + " = " + multiplicar(numero1, numero2));
	}

	static int somar(int numero1, int numero2) {
		int soma = numero1 + numero2;
		return(soma);
	}
	
	static int subtrair(int numero1, int numero2) {
		return(numero1 - numero2);
	}
	
	static int dividir(int numero1, int numero2) {
		return (numero1 / numero2);
	}
	
	static int multiplicar(int numero1, int numero2) {
		return (numero1 * numero2);
	}
	
	static void resultado(String operacao, int numero1, int numero2) {
		System.out.println("A soma de: " + numero1 + operacao + numero2 + " = " + somar(numero1, numero2));
	}
	
	
	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}