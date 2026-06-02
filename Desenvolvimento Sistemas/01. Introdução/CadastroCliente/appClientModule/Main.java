
public class Main {
	public static void main(String[] args) {
		String nomeCompleto = "Josué Santos";
		int idade = 26;
		double altura = 1.69;
		char sexo = 'M';
		boolean clienteVip = true;
		double valor = 95.50;
		
		// declaração dos dados constantes
		final String NOME_LOJA = "Js Imports";
		final double TAXA_ENTREGA = 9.90;
		
		
		System.out.println("Loja: " + NOME_LOJA);
		System.out.println("Cliente: " + nomeCompleto + ", " + idade + " anos");
		System.out.println("Altura: " + altura + " | " + "Sexo: " + sexo);
		System.out.println("Valor do produto: R$ " + valor);
		System.out.println("Taxa de entrega; R$ " + TAXA_ENTREGA);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}