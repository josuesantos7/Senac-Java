package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



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
			
			System.out.println("Cliente cadastrado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Erro ao cadastrar o cliente", e);
		}
	}
	
	public List<Cliente> listarTodos() {
		String sql = "SELECT id_cliente, nome, sexo, dt_nascimento from Cliente";
		List<Cliente>clientes = new ArrayList<>();
		
		try (
			Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()
			)
		
		{
			while (rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("nome"),
						rs.getString("sexo").charAt(0),
						rs.getDate("dt_nascimento").toLocalDate()
				);
				cliente.setId(rs.getInt("id_cliente"));
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar clientes", e);
		}
		
		return clientes;
	}
	
	public void atualizar(Cliente cliente) {
		String sql = "UPDATE Cliente SET nome=?, sexo = ?, dt_nascimento = ? WHERE ID_CLIENTE = ?";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, String.valueOf(cliente.getSexo()));
			stmt.setDate(3, Date.valueOf(cliente.getDtNascimento()));
			stmt.setInt(4, cliente.getId());
			
			stmt.execute();
			System.out.println("Cliente atualizado com sucesso!");
			
		} catch (SQLException e) {
			throw new RuntimeException("error ao atualizar cliente", e);
		}
	}
	
	public Cliente buscarPorId(int id) {
		String sql = "SELECT ID_CLIENTE, nome, sexo, dt_nascimento from Cliente WHERE ID_CLIENTE = ?";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente(
						rs.getString("nome"), 
						rs.getString("sexo").charAt(0), 
						rs.getDate("dt_nascimento").toLocalDate()
				);
				cliente.setId(rs.getInt("ID_CLIENTE"));
				return cliente;		
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar cliente", e);
		}
		
		return null;
	}
	
}
