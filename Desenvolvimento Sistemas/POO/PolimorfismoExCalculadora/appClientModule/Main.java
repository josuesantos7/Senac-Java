
public class Main {
	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.somar(2, 3)); // 5
		System.out.println(calc.somar(2, 3, 4)); // 9
		System.out.println(calc.somar(2.5, 3.7)); // 6.2
		
		System.out.println(calc.somar(new int[] {1,2,3,4,5})); // 15.
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}