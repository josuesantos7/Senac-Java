
public class Cachorro extends Animal {
	private String raca;
	
	public Cachorro(String nome, int idade, double peso, String raca) {
		super(nome, idade, peso);
		this.raca = raca;
	}
	
	public void latir() {
		System.out.println(this.nome + " está latindo: Au au!");
	}
	
	public void buscarBola(){
		System.out.println(this.nome + " foi buscar a bola!");
	}
	
	
}
