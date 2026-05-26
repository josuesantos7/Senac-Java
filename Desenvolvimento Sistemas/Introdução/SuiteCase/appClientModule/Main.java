
public class Main {
	public static void main(String[] args) {
		String dia = "domingo";
		
		switch (dia) {
			case "segunda":
			case "terça":
			case "quarta":
			case "quinta":
			case "sexta":
				System.out.println("Dia útil");
				break;
			case "sabado":
			case "domingo":
				System.out.println("final de semana");
				break;
				
			default:
				System.err.println("Dia inválido!");
				break;
			}
	}
				
				
		// Outra forma:
//		switch(dia) {
//		case "segunda", "terça", "quarta", "quinta", "sexta" -> System.out.println("Dia útil");
//		case "sábado", "domingo" -> System.out.println("Final de semana");
//		default -> System.out.println("Dia Inválido!!");
//		}


	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}