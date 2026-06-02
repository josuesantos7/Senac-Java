package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Connetion.ConectFactory;
import Model.Cliente;

public class ClienteDAO {
	
	//Vamos escrever nessa classe o CRUD de cliente.
	public void inserir(Cliente cliente) {
		String sql = "INSERT INTO Cliente (nome, sexo, dt_nascimento) VALUES (?,?,?)";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, String.valueOf( cliente.getSexo()));
			stmt.setDate(3, Date.valueOf(cliente.getDtNascimento()));
			
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				cliente.setId(rs.getInt(1));
			}
			
			System.out.println("Endereço cadastrado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao cadastrar o cliente", e);
		}
	}
}
