
public class Main {
	public static void main(String[] args) {
		double nota1 = 7.5;
		double nota2 = 8.0;
		double nota3 = 5.8;
		double nota4 =6.7;
		
		double media = calcularMedia(nota1, nota2, nota3, nota4);
		String situacao = verificarSituacao(media);
		
		System.out.println("Sua média foi: " + media + ", você está: " + situacao);
		
		
	}
	
	// Método double
	static double calcularMedia(double nota1, double nota2, double nota3, double nota4) {
		return (nota1 + nota2 + nota3 + nota4)/4;
	}
	
	// Método String
	static String verificarSituacao(double media) {
		if(media >=7) {
			return "Aprovado";
		}else if(media >=5) {
			return "Recuperação";
		}else {
			return "Reprovado";
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}