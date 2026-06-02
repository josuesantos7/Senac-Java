// OBS: Classe abstrata não pode criar "new Forma()";

public abstract class Forma {
	protected String cor;
	
	public Forma(String cor) {
		this.cor = cor;
	}
	
	// Método ABSTRATO - só declara, não implementa
	// Cada forma filha Deve implementar esse método
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	
	// Método CONCRETO - já tem implementação pronta.
	public void exibirInfo() {
		System.out.println("Forma de cor " + cor);
		System.out.println("Área " + calcularArea());
		System.out.println("Perímetro " + calcularPerimetro());
	}
}
