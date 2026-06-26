package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;

import Connection.ConectFactory;
import Model.Veiculo;

public class VeiculoDAO {
	
	public boolean veiculoEstaNoEstacionamento(String placa) {
	    String sql = "SELECT COUNT(*) FROM Veiculo WHERE placa = ? AND saida IS NULL";

	    try (
	        Connection conn = ConectFactory.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql)
	    ) {
	        stmt.setString(1, placa);

	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            return rs.getInt(1) > 0;
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar veículo", e);
	    }

	    return false;
	}
	
	public void inserir(Veiculo veiculo) {
		
		 if (veiculoEstaNoEstacionamento(veiculo.getPlaca())) {
		        throw new IllegalArgumentException("Este veículo já está no estacionamento.");
		    }
		
		String sql = "INSERT INTO Veiculo (placa, entrada, saida) VALUES (?,?,?)";
		
		try (
				Connection conn = ConectFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				) {
			stmt.setString(1, veiculo.getPlaca());
			stmt.setObject(2, veiculo.getEntrada());
			stmt.setObject(3, veiculo.getSaida());
			
			stmt.execute();
			
			System.out.println("Veículo: " + veiculo.getPlaca() + ", cadastrado com sucesso!");
			
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
				return veiculo ;		
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar veiculo", e);
		}
		
		return null;
	}
	
	public void registrarSaida(Veiculo veiculo) {

	    String sql = "UPDATE Veiculo SET saida = ? WHERE placa = ? AND saida IS NULL";

	    try (
	        Connection conn = ConectFactory.getConnection();
	        PreparedStatement stmt = conn.prepareStatement(sql);
	    ) {

	        stmt.setTimestamp(1, java.sql.Timestamp.valueOf(veiculo.getSaida()));
	        stmt.setString(2, veiculo.getPlaca());
	        
	        int linhas = stmt.executeUpdate();

	        if (linhas > 0) {
	            System.out.println("");
	        } else {
	            System.out.println("Veículo não encontrado.");
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao registrar saída.", e);
	    }
	}
	
	public Veiculo retornarPermanencia(String placa) {
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
				
				veiculo.setSaida(rs.getTimestamp("saida").toLocalDateTime());
				
				System.out.println(veiculo.getEntrada());
				System.out.println(veiculo.getSaida());
				
				// Calcular intervalo de hora!
				LocalDateTime dataInicio = rs.getTimestamp("entrada").toLocalDateTime();
                LocalDateTime dataFim = rs.getTimestamp("saida").toLocalDateTime();
				
                Duration intervalo = Duration.between(dataInicio, dataFim);
                long horas = intervalo.toHours();
                long minutos = intervalo.toMinutes() % 60;
                
                System.out.println("Intervalo: " + horas + " horas e " + minutos + " minutos.");
                
				return veiculo ;	
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar veiculo", e);
		}
	
		return null;
	}
	
	public void RegistarIntervaloDB(String placa) {
		
		String sql = "SELECT"
				+ "	PLACA"
				+ "    , ENTRADA"
				+ "	, SAIDA"
				+ "    , TEMPO"
				+ "    , HOUR(TEMPO) + (MINUTE(TEMPO) / 60) + (SECOND(TEMPO) / 3600) AS TEMPO_HORA"
				+ "    , (HOUR(TEMPO) * 60) + MINUTE(TEMPO) + (SECOND(TEMPO) / 60) AS TEMPO_MINUTO"
				+ "    , (SELECT MAX(VALOR_HORA) FROM PRECO_HORA) AS VALOR_HORA"
				+ " FROM ("
				+ "	SELECT"
				+ "		PLACA"
				+ "        , ENTRADA"
				+ "		, SAIDA"
				+ "		, TIMEDIFF(SAIDA, ENTRADA) AS TEMPO"
				+ "	FROM"
				+ "		VEICULO"
				+ "	WHERE"
				+ "		PLACA = ?"
				+ ") as sub";
		
		try {
			Connection conn = ConectFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
				
			stmt.setString(1, placa);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Veiculo veiculo = new Veiculo(
						rs.getString("placa"),
						rs.getTimestamp("entrada").toLocalDateTime()
				);
				
				veiculo.setSaida(rs.getTimestamp("saida").toLocalDateTime());
				veiculo.setTempoHora(rs.getFloat("TEMPO_HORA"));
				veiculo.setTempoMin(rs.getFloat("TEMPO_MINUTO"));
				float valorHora = rs.getFloat("VALOR_HORA");
				if (rs.getFloat("TEMPO_MINUTO") > 15 ) {
					veiculo.setValor(rs.getFloat("TEMPO_HORA") * valorHora);
				}else {
					veiculo.setValor(0);					
				}	
				
				sql = "UPDATE Veiculo SET TEMPO_PERMANENCIA = ?, TOTAL_A_PAGAR = ? WHERE PLACA = ?";
				stmt = conn.prepareStatement(sql);
				
				stmt.setFloat(1, veiculo.getTempoHora());
				stmt.setFloat(2, veiculo.getValor());
		        stmt.setString(3, veiculo.getPlaca());
		        
		        int linhas = stmt.executeUpdate();

		        if (linhas > 0) {
		            
		        	LocalDateTime dataInicio = rs.getTimestamp("entrada").toLocalDateTime();
	                LocalDateTime dataFim = rs.getTimestamp("saida").toLocalDateTime();
					
	                Duration intervalo = Duration.between(dataInicio, dataFim);
	                long horas = intervalo.toHours();
	                long minutos = intervalo.toMinutes() % 60;
	                
	                // System.out.println("Intervalo: " + horas + " horas e " + minutos + " minutos.");
	                
	                System.out.println("================= Resumo =====================");
	                System.out.println("Placa informada: " + veiculo.getPlaca());
	                System.out.println("Entrada: " + veiculo.getEntrada());
	                System.out.println("Saída: " + veiculo.getSaida());
	                System.out.println("Permanência: " + horas + " horas e " + minutos + " minutos.");
	                System.out.println("Valor a pagar: R$" + veiculo.getValor());
	                System.out.println("=============================================");
	                
		        } else {
		            System.out.println("Veículo não encontrado.");
		        }
		
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar veiculo", e);
		}
		
	}
}