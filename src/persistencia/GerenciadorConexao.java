package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/bd.jdbc";

	// Database credentials
	static final String USER = "postgres";
	static final String PASS = "6528";

	private static GerenciadorConexao instance = null;

	protected GerenciadorConexao() {
	}

	public static GerenciadorConexao getInstance() throws ClassNotFoundException {
		if (instance == null) {
			Class.forName("org.postgresql.Driver");
			instance = new GerenciadorConexao();
		}
		return instance;
	}

	public Connection getConexao() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
