import java.time.LocalDateTime;
import java.util.Scanner;

import Model.Veiculo;
import dao.VeiculoDAO;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VeiculoDAO veiculodao = new VeiculoDAO();
		
		System.out.println();
		System.out.println("***** Bem vindo ao estacionamento JS *****");
		int opcao = 0;
		
		while (opcao != 3) {
			System.out.println("\n========= MENU =========");
			System.out.println("1 - Emitir ticket Entrada");
			System.out.println("2 - Validar ticket Saída");
			System.out.println("3 - finalizar Programa");
			System.out.println("=========================\n");
			
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
				System.out.println("Placa digitada: " + placaSaida);

				Veiculo veiculo1 = veiculodao.buscarPorPlaca(placaSaida);

				if (veiculo1 != null) {
				    veiculo1.setSaida(LocalDateTime.now());
				    
				    // Envia o objeto atualizado para o DAO salvar no banco de dados
				    veiculodao.registrarSaida(veiculo1);
				   // veiculodao.returnarPermanencia(veiculo1.getSaida());
				    
				} else {
				    System.out.println("Veículo não encontrado.");
				}
				break;
			case 3:
				System.out.println("Programa finalizado com Sucesso !!");
				System.out.println("Informe a placa do seu veículo: ");
				String placaSaidaa = scanner.nextLine();
				System.out.println("Placa digitada: " + placaSaidaa);
				
				Veiculo veiculo2 = veiculodao.retornarPermanencia(placaSaidaa);
				/*
				System.out.println(veiculo2.getSaida());
				
				System.out.println(veiculo2.getEntrada());
				*/
				
		
				break;
			
			default:
				System.out.println("Opção Inválida!");
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