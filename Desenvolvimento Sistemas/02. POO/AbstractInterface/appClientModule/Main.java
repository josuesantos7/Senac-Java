
public class Main {
	public static void main(String[] args) {
		// Polimorfismo com interfaces
		Pagavel[] pagamentos = new Pagavel[3];
		pagamentos[0] = new FuncionarioCLT("Ana", 8000.0);
		pagamentos[1] = new Freelancer("Carlos", 5000.0, 40);
		pagamentos[2] = new FuncionarioCLT("Beatriz", 6000.0);
		
		double totalFolha = 0;
		for (Pagavel p : pagamentos) {
			System.out.println(p.gerarRecibo());
			totalFolha += p.calcularPagamento();
		}
		System.out.println("\n Total da folha: R$" + totalFolha);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}