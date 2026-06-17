package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/DBESTACIONAMENTO";
	private static final String usuario = "root";
	private static final String senha = "root";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
		}
	}
}
