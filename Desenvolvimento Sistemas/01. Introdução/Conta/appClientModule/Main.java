
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaBancaria conta = new ContaBancaria("José", 1000.00);
		
		conta.depositar(500);
		
		System.out.println(conta);
		
		conta.sacar(20.00);
		
		System.out.println(conta);
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}