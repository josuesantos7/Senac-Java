
public class Main {
	public static void main(String[] args) {
		Forma circulo = new Circulo("vermelho", 5.0);
		Forma retangulo = new Retangulo("azul", 4.0, 6.0);
		
		circulo.exibirInfo();
		/*
	 	Forma de cor vermelho
		Área 78.53981633974483
		Perímetro 31.41592653589793
	 */
		
		System.out.println("----");
		
		
		retangulo.exibirInfo();
		/*
		Forma de cor azul
		Área 24.0
		Perímetro 20.0
		 */
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}