
public class Main {
	public static void main(String[] args) {
		int idade = 18;
		boolean terCarro= false;
		boolean temHabilitacao = (idade >= 18 && true);
		
		if(temHabilitacao && terCarro) {
			System.out.println("Pode dirigir");
			
		} else {
			if(!temHabilitacao && idade >= 18) {
				System.out.println("Pode tirar a CNH");
				if (idade < 18) {
					System.out.println("Não pode tirar a CNH");
				}
			} else {
				if (idade >= 18) {
					if (temHabilitacao && !terCarro) {
						System.out.println("Não pode dirigir!");	
					}else {
						System.out.println("Pode tirar a CNH");
					}
				} else {
					System.out.println("Não pode tirar a CNH");
				}
			}
		}
		
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}


