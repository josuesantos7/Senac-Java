// Uma classe pode implementar MÚLTIPAS interfaces!
public class FuncionarioCLT implements Pagavel, Tributavel {
	private String nome;
	private double salarioBruto;
	
	public FuncionarioCLT(String nome, double salarioBruto) {
		this.nome =  nome;
		this.salarioBruto = salarioBruto;
	}
	
	@Override
	public double calcularImposto() {
		return salarioBruto * 0.275;
	}
	@Override
	public double calcularPagamento() {
		return salarioBruto - calcularImposto();
	}
	@Override
	public String gerarRecibo() {
		return "Recibo CLT - " + nome + ": R$" + calcularPagamento();
	}
}
