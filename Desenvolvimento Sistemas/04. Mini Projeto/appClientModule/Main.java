import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import Model.Veiculo;
import dao.VeiculoDAO;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VeiculoDAO veiculodao = new VeiculoDAO();
		
		System.out.println("***** Bem vindo ao estacionamento JS *****");
		int opcao = 0;
		
		while (opcao != 3) {
			System.out.println("\n========= MENU ========");
			System.out.println("1 - Emitir ticket Entrada");
			System.out.println("2 - Validar ticket Saída");
			System.out.println("3 - finalizar Programa");
			
			opcao = Integer.parseInt(scanner.nextLine());
			
			LocalDateTime tempoAtual;
			switch (opcao) {
			case 1:
				System.out.println("Informe a placa do seu veículo: ");
				String placa = scanner.nextLine();
				System.out.println(placa);
				
				tempoAtual= LocalDateTime.now();
				
				Veiculo veiculo = new Veiculo(placa, tempoAtual);
				
				veiculodao.inserir(veiculo);
				break;
			case 2:
				System.out.println("Informe a placa do seu veículo: ");
				String placaSaida = scanner.nextLine();
				System.out.println(placaSaida);
				
				tempoAtual= LocalDateTime.now();
				
				// veiculodao.mostrarHoras(placaSaida);
				veiculodao.buscarPorPlaca(placaSaida);
				
				break;
				
				

			default:
				break;
			}
		}
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}