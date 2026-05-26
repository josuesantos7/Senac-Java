
public class Animal {
	
	protected String nome;
	protected int idade;
	protected double peso;
	
	public Animal(String nome, int idade, double peso) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
	}
	
	public void comer() {
		System.out.println(this.nome + " está comendo!");
	}
	
	public void dormir() {
		System.out.println(this.nome + " está dormindo!");
	}
	
	public void exibirInfo() {
		System.out.println("Nome: " + this.nome + " | Idade: " + this.idade + "| Peso: " + this.peso + "Kg");
	}
	
	
	
}