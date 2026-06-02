
public class Freelancer implements Pagavel{
	private String nome;
	private double valorProjeto;
	private int horasTrabalhadas;
	
	public Freelancer(String nome, double valorProjeto, int horasTrabalhadas) {
		this.nome = nome;
		this.valorProjeto = valorProjeto;
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public double calcularPagamento() {
		return valorProjeto;
	}

	@Override
	public String gerarRecibo() {
		return "Recibo Freelancer - " + nome + ":R$" + valorProjeto + " (" + horasTrabalhadas + "h trabalhadas)";
	}
	
	
}
