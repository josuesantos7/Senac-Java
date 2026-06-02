
public class Gato extends Animal {
	private boolean domestico;
	private String corPelo;
	
	public Gato (String nome, int idade, double peso, boolean domestico, String corPelo) {
		super(nome, idade, peso);
		this.domestico = domestico;
		this.corPelo = corPelo;
	}
	
	public void miar() {
		System.out.println(this.nome + " está miando: Miaaau!");
	}
	
	public void arranhar() {
		System.out.println(this.nome + " está Arranhando o sofá!");
	}
	
	public void ExibirSe() {
		System.out.println(this.nome + " está exibindo os seus belos pelos " + corPelo);
	}
}
