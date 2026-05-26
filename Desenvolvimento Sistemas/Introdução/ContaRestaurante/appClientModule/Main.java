
public class Main {
	public static void main(String[] args) {
		
		double valorTotal = 180.00;
		int numeroPessoas = 4;
		double gorjeta = valorTotal * 0.10;
		
		double totalGorjeta = valorTotal + gorjeta;
		double valorPessoa = totalGorjeta / numeroPessoas;
		
		boolean todosPaga = true;
		boolean podeSair = todosPaga && (valorPessoa > 0);
		
		
		System.out.println("Total: R$ " + totalGorjeta);
		System.out.println("Cada um paga: R$ " + valorPessoa);
		System.out.println("Todos pagaram?: " + todosPaga);
		System.out.println("Pode sair?: " + podeSair);

	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}