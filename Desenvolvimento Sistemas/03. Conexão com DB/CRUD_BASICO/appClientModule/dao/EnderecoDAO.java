package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Connetion.ConectFactory;
import Model.Endereco;

public class EnderecoDAO {
	public void inserir(Endereco endereco) {
		String sql = "INSERT INTO Endereco ("
				+ "logradouro, numero, complemento, bairro,"
				+ " cidade, estado, cep, pais, CLIENTE_ID)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			stmt.setString(1, endereco.getLogradouro());
			stmt.setInt(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getBairro());
			stmt.setString(5, endereco.getCidade());
			stmt.setString(6, endereco.getEstado());
			stmt.setInt(7, endereco.getCep());
			stmt.setString(8, endereco.getPais());
			stmt.setInt(9, endereco.getCliente_id());
			
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				endereco.setId(1);
			}
			
			System.out.println("Endereço cadastrado com sucesso!.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
