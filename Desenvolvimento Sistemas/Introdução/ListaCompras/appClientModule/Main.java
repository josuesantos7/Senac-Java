
public class Main {
	public static void main(String[] args) {
		// arrays
		String[] itens = {"Arroz","Feijão","Leite", "Ovos", "Pão"};
		double[] preco = {22.90, 8.50, 6.30, 15.00, 7.00};
		
		double total = 0;
		
		for (int i = 0; i <= 4; i++) {
			System.out.println(itens[i] + " - R$" + preco[i]) ;
			total += preco[i];
		}
		System.out.printf("Total = R$ %.2f", total);
		System.out.println("\n**************************");
		
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}