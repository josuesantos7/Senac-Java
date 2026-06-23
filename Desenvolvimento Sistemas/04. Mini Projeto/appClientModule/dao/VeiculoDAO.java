package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Connection.ConectFactory;
import Model.Veiculo;

public class VeiculoDAO {
	public void inserir(Veiculo veiculo) {
		String sql = "INSERT INTO Veiculo (placa, entrada, saida) VALUES (?,?,?)";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			stmt.setString(1, veiculo.getPlaca());
			stmt.setObject(2, veiculo.getEntrada());
			stmt.setObject(3, veiculo.getSaida());
			
			stmt.execute();
			
			System.out.println("Veículo cadastrado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao cadastrar o veículo", e);
		}
	}
	
	public Veiculo buscarPorPlaca(String placa) {
		String sql = "SELECT PLACA, entrada, saida from Veiculo WHERE PLACA = ?";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setString(1, placa);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Veiculo veiculo = new Veiculo(
						rs.getString("placa"),
						rs.getTimestamp("entrada").toLocalDateTime()
				);
				System.out.println("a placa digitada foi: " + veiculo.getPlaca());
				return veiculo ;		
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar veiculo", e);
		}
		
		return null;
	}
	
	public void registrarSaida(Veiculo veiculo) {

	    String sql = "UPDATE Veiculo SET saida = ? WHERE placa = ?";

	    try (
	        Connection conn = ConectFactory.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql);
	    ) {

	        stmt.setTimestamp(1, java.sql.Timestamp.valueOf(veiculo.getSaida()));
	        stmt.setString(2, veiculo.getPlaca());

	        int linhas = stmt.executeUpdate();

	        if (linhas > 0) {
	            System.out.println("Saída registrada com sucesso!");
	        } else {
	            System.out.println("Veículo não encontrado.");
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao registrar saída.", e);
	    }
	}
}
