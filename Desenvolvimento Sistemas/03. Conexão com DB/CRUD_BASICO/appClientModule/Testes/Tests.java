package Testes;

import java.sql.Connection;
import Connetion.ConectFactory;

public class Tests {

	public static void main(String[] args) {
		try( Connection conn = ConectFactory.getConnection()){
			if (conn != null) {
				System.out.println("*Conexão estabelicida com sucesso!!*");
				System.out.println("Banco: " + conn.getCatalog());
			}
		} catch (Exception e) {
			System.err.println("Erro ao conectar no banco de dados " + e.getMessage());
			System.err.println("Causa:" + e.getCause().getMessage());
		}

	}

}
