
public class Animal {
	protected String nome;
	
	public Animal(String nome) {
		this.nome = nome;
	}
	
	// Método que será SOBRESCRITO pelas filhas
	public void emitirSom() {
		System.out.println(this.nome + " Emite um som genérico");
	}
	
	public void seApresentar() {
		System.out.println("Eu sou " + this.nome);
	}
}
