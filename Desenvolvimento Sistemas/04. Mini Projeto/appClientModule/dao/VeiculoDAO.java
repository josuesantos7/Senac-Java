package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

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
			ResultSet rs = stmt.getGeneratedKeys();
			
			System.out.println("Veículo cadastrado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao cadastrar o veículo", e);
		}
	}
	
	public void mostrarHoras(String placa) {
		String sql = "select placa, entrada, saida from Veiculo where placa = ?";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
			
			stmt.setString(1, placa);
			

			ResultSet rs = stmt.executeQuery();
			
			    while (rs.next()) {
			        Object entrada = rs.getObject("entrada");
			        Object saida = rs.getObject("saida");
			
			        System.out.println("Placa: " + placa);
			        System.out.println("Entrada: " + entrada);
			        System.out.println("Saída: " + saida);
			    }
			
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
				veiculo.setSaida(LocalDateTime.now());
				//veiculo.setSaida(rs.getTimestamp("saida").toLocalDateTime());
				
				System.out.println("a placa é: " + veiculo.getPlaca());
				return veiculo ;		
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar veiculo", e);
		}
		
		return null;
	}
}
