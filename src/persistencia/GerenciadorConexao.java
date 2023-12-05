package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "org.postgresql.Driver";  
			static final String DB_URL = "jdbc:postgresql://localhost:5432/bd.jdbc";

			//  Database credentials
			static final String USER = "postgres";
			static final String PASS = "6528";
			
			private static GerenciadorConexao instance = null;
			
			protected GerenciadorConexao(){}
			
			public static GerenciadorConexao getInstance() throws ClassNotFoundException{
				if(instance == null){
					//Passo 1
					//Aqui eu estou fazendo a carga do Driver
					//Ap�s a execu��o desse comando o driver estar� registrado
					Class.forName("org.postgresql.Driver");
					
					//criar a inst�ncia do gerenciador
					instance = new GerenciadorConexao();
				}
				return instance;
			}
				
			public Connection getConexao(){		
				Connection con = null;		
				try {	
					//Passo 2 
					//Obtendo a conex�o usando a classe DriverManager
					//Perceba que na url de conex�o eu passo onde est� instalado o SGBD: no meu caso em localhost
					//Passo o nome do meu banco de dados: no meu caso teste
					//Passo o nome do usu�rio do banco: postgres
					//Passo a senha do usu�rio admin
					con = DriverManager.getConnection(DB_URL, USER, PASS);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				return con;
}
}
