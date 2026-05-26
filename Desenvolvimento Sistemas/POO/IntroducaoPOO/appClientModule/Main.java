
public class Main {
	public static void main(String[] args) {
		Pessoa p = new Pessoa("Josué", 26);
		
		
		if(p.getIdade()>=18) {
			System.out.println("Você é maior de idade");
		}else {
			System.out.println("Você é menor de idade");
		}
		
		System.out.println("########-------########");
		
//		p.setIdade(15);
		System.out.println("A sua idade é: " + p.getIdade());
		
		System.out.println(p.getMaioridade(p.getIdade()));
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}