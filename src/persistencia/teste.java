package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class teste {

	public static void main(String[] args) {
		//TODO tira esse void main daqui e corrige baseado no sigleton

		try {
			Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bd.jdbc", "postgres",
					"6528");
			if (conexao != null) {
				System.out.println("banco conectado");
				Statement stm = conexao.createStatement();
				consultaDados(stm);
			} else {
				System.out.println("erro!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void consultaDados(Statement stm) {
		try {
		String query = "select nome from cliente";
		ResultSet result = stm.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString("nome"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
