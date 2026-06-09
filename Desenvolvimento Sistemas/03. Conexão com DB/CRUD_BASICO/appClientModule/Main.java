import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Model.Cliente;
import Model.Endereco;
import dao.ClienteDAO;
import dao.EnderecoDAO;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ClienteDAO clientedao = new ClienteDAO();
		
		System.out.println("*** Cadastro de cliente ***");
		int opcao = 0;
		
		while (opcao != 3) {
			System.out.println("\\n==== MENU ====");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Listar todos os Clientes");
			System.out.println("3 - Sair");
			System.out.print("Opcao: ");
			opcao = Integer.parseInt(scanner.nextLine());
			
			switch (opcao) {
			case 1:
				System.out.println("Nome:");
				String nome = scanner.nextLine();
				
				System.out.println("Sexo (M/F): ");
				char sexo = scanner.nextLine().toUpperCase().charAt(0);
				
				System.out.println("Data de nascimento (dd/mm/aa:)");
				String dataStr = scanner.nextLine();
				
				String[] partes = dataStr.split("/");
				
				LocalDate dataNascimento = LocalDate.of(
						Integer.parseInt(partes[2]), // Ano
						Integer.parseInt(partes[1]), // Mês
						Integer.parseInt(partes[0])); // Dia
				
				
				Cliente cliente = new Cliente(nome, sexo, dataNascimento);
				
//				ClienteDAO clientedao = new ClienteDAO();
				
				
				clientedao.inserir(cliente);
				
				// Add endereço.
				System.out.println("Gostaria de informar um endereço?: s/n");
				String resposta = scanner.nextLine();
				System.out.println(resposta);
				
				if (resposta.equals("s")) {
					System.out.println("Logradouro:");
					String logradouro = scanner.nextLine();
					
					System.out.println("Número:");
					int numero = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Complemento:");
					String complemento = scanner.nextLine();
					
					System.out.println("Bairro:");
					String bairro = scanner.nextLine();
					
					System.out.println("Cidade:");
					String cidade = scanner.nextLine();
					
					System.out.println("Estado:");
					String estado = scanner.nextLine();
					
					System.out.println("CEP:");
					int cep = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Pais:");
					String pais = scanner.nextLine();
					
					
					
					Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, pais);
					endereco.setCliente_id(cliente.getId());
					EnderecoDAO enderecodao = new EnderecoDAO();
					enderecodao.inserir(endereco);
					break;
				}
			case 2:
				listarClientes(clientedao);
				break;
			case 3:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção Inválida!");
			}
		}
		
		
		
		
		
		/*
		
		System.out.println("Nome:");
		String nome = scanner.nextLine();
		
		System.out.println("Sexo (M/F): ");
		char sexo = scanner.nextLine().toUpperCase().charAt(0);
		
		System.out.println("Data de nascimento (dd/mm/aa:)");
		String dataStr = scanner.nextLine();
		
		String[] partes = dataStr.split("/");
		
		LocalDate dataNascimento = LocalDate.of(
				Integer.parseInt(partes[2]), // Ano
				Integer.parseInt(partes[1]), // Mês
				Integer.parseInt(partes[0])); // Dia
		
		
		Cliente cliente = new Cliente(nome, sexo, dataNascimento);
		
		ClienteDAO clientedao = new ClienteDAO();
		
		
		clientedao.inserir(cliente);
		
		
		// Add endereço.
		System.out.println("Gostaria de informar um endereço?: s/n");
		String resposta = scanner.nextLine();
		System.out.println(resposta);
		
		if (resposta.equals("s")) {
			System.out.println("Logradouro:");
			String logradouro = scanner.nextLine();
			
			System.out.println("Número:");
			int numero = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Complemento:");
			String complemento = scanner.nextLine();
			
			System.out.println("Bairro:");
			String bairro = scanner.nextLine();
			
			System.out.println("Cidade:");
			String cidade = scanner.nextLine();
			
			System.out.println("Estado:");
			String estado = scanner.nextLine();
			
			System.out.println("CEP:");
			int cep = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Pais:");
			String pais = scanner.nextLine();
			
			
			
			Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep, pais);
			endereco.setCliente_id(cliente.getId());
			EnderecoDAO enderecodao = new EnderecoDAO();
			enderecodao.inserir(endereco);
			
		*/
			
			
	
		scanner.close();	
	}
	
	
	/*
	public static void cadastrarCliente(Scanner scanner, ClienteDAO clientDao, EnderecoDAO endereDao) {
		System.out.println("***** Cadastro de cliente *****");
		
		System.out.println("Nome:");
		String nome = scanner.nextLine();
		
		System.out.println("Sexo (M/F): ");
		char sexo = scanner.nextLine().toUpperCase().charAt(0);
		
		System.out.println("Data de nascimento (dd/mm/aa:)");
		String dataStr = scanner.nextLine();
		
		String[] partes = dataStr.split("/");
		
		LocalDate dataNascimento = LocalDate.of(
				Integer.parseInt(partes[2]), // Ano
				Integer.parseInt(partes[1]), // Mês
				Integer.parseInt(partes[0])); // Dia
		
		
		Cliente cliente = new Cliente(nome, sexo, dataNascimento);
		
		ClienteDAO clientedao = new ClienteDAO();
		
		
		clientedao.inserir(cliente);
		
	};
	*/
	
	public static void listarClientes(ClienteDAO clienteDAO) {
		List<Cliente> clientes = clienteDAO.listarTodos();
		
		if(clientes.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		};
		
		System.out.println("\n=== Lista de Clientes ===");
		System.out.println("ID\tNome\t\tSexo\tNascimento");
		System.out.println("-".repeat(55));
		
		for (Cliente c :clientes) {
			System.out.println(c.getId() + "\t" + c.getNome() + "\t" + c.getSexo() + "\t" + c.getDtNascimento());
		};
	};
	
	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}