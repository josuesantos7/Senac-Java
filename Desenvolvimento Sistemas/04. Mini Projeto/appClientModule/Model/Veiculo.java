package Model;

import java.time.LocalDateTime;

public class Veiculo {
	private String placa;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private float tempoHora;
	private float tempoMin;
	private float valor;
	
	public Veiculo(String placa, LocalDateTime entrada) {
		this.placa = placa;
		this.entrada = entrada;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public float getTempoHora() {
		return tempoHora;
	}

	public void setTempoHora(float tempoHora) {
		this.tempoHora = tempoHora;
	}

	public float getTempoMin() {
		return tempoMin;
	}

	public void setTempoMin(float tempoMin) {
		this.tempoMin = tempoMin;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
}