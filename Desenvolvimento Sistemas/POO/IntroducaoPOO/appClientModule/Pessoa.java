
public class Pessoa {
	// Atributos
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	// Métodos
	@Override
	public String toString() {
		return nome + " Agora tem " + idade + " anos!";
	}

	public int getIdade() {
		return idade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getMaioridade(int idade) {
		if(idade >=18) {
			return "Você é maior de idade";
		}else {
			return "Você é menor de idade";
		}
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getDiferencaIdade(int idade1, int idade2) {
		int resultado = 0;
		
		if(idade1 >= idade2) {
			resultado = idade1 - idade2;
		}
		
		return resultado;
	}
	
}