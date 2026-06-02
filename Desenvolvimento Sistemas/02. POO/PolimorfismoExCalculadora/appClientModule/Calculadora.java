
public class Calculadora {
	
	// Soma 2 inteiros
	public int somar(int a, int b) {
		return a + b;
	}
	
	
	// Somar 3 inteiros
	public int somar(int a, int b, int c) {
		return a + b + c;
	}
	
	// Somar 2 Doubles ( mesmo nome, tipos diferentes)
	public double somar(double a, double b) {
		return a + b;
	}
	
	// Somar um array inteiro
	public int somar( int[] numeros) {
		int total = 0;
		for (int n : numeros) {
			total += n;
		}
		return total;
	}
}
