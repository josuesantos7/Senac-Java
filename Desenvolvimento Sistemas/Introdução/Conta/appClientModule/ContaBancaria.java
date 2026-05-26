
public class ContaBancaria {

	private String nome;
	private double saldo;
	
	public ContaBancaria(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	@Override
	public String toString() {
		return "ContaBancaria [nome=" + nome + ", saldo=" + saldo + "]";
	}
	
	
	// Métodos
	public void depositar(double valor) {
		if(valorValido(valor)) {
			this.saldo += valor;
			System.out.println("Depósito de R$" + valor + " realizado!");
		}else {
			System.err.println("ERRO: Valor do depósito inválido.");
		}
	}
	
	public void sacar(double valor) {
		if(valorValido(valor) && valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque de R$" + valor + " realizado com sucesso!");
		}else {
			System.err.println("ERRO: Saldo insuficiente ou valor inválido.");
		}
	}
	
	
	private boolean valorValido(double valor) {
		if(valor > 0) {
			return true;
		}else {
			return false;
		}
	}
}
