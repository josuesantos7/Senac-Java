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
			/*
			if(rs.next()) {
				cliente.setId(rs.getInt(1));
			}
			*/
			System.out.println("Veículo cadastrado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao cadastrar o veículo", e);
		}
	}
}
