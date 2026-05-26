
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cachorro rex = new Cachorro("Rex", 11, 12.5, "PitBull");
		
		rex.exibirInfo();
		rex.comer();
		rex.dormir();
		rex.latir();
		
		System.out.println("*-----------------------------------------------*");
		
		Gato pantera = new Gato("Pantera", 5, 5.5, true, "preto");
		pantera.arranhar();
		pantera.miar();
		pantera.ExibirSe();
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}