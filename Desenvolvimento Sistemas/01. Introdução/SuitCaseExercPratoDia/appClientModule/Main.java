
public class Main {
	public static void main(String[] args) {
		String dia = "sábado";
		
		switch (dia) {
		case "segunda":
			System.out.println("Macarronada de Camarão.");
			break;
		case "terça":
			System.out.println("Strogonoff.");
			break;
		case "quarta":
			System.out.println("Churrasco.");
			break;
		case "quinta":
			System.out.println("Rodízio de Pastel.");
			break;
		case "sexta":
			System.out.println("Rodízio de Hamburguer.");
			break;
		case "sábado":
			System.out.println("Prato especial da casa.");
			break;
		case "domingo":
			System.out.println("Fechado.");
			break;

		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}