
public class Main {
	public static void main(String[] args) {
		
		Animal[] animais = new Animal[4];
		animais[0] = new Cachorro("Rex");
		animais[1] = new Gato("Pantera");
		animais[2] = new Vaca("Mimosa");
		animais[3] = new Cachorro("Thor");
		
		for (Animal animal : animais) {
			animal.seApresentar();
			animal.emitirSom();
			System.out.println("----");
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}