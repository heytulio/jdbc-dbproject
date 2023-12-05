package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Cliente;
import persistencia.GerenciadorConexao;

public class ClienteDAO {

	public static final int CPF_COLUMN_ORDER  = 1;
	public static final int NOME_COLUMN_ORDER  = 2;
	public static final int DATA_NASCIMENTO_COLUMN_ORDER  = 3;
	public static final int AGENCIA_MATRICULA_COLUMN_ORDER  = 4;
	public static final int NUMERO_COLUMN_ORDER  = 5;
	public static final int LOGRADOURO_COLUMN_ORDER  = 6;
	public static final int CIDADE_COLUMN_ORDER  = 7;
	public static final int BAIRRO_COLUMN_ORDER  = 8;
	public static final int CEP_COLUMN_ORDER  = 9;

	public static final String CPF_COLUMN_NAME  = "cpf";
	public static final String NOME_COLUMN_NAME  = "nome";
	public static final String DATA_NASCIMENTO_COLUMN_NAME  = "data_nascimento";
	public static final String AGENCIA_MATRICULA_COLUMN_NAME  = "Agencia_matricula";
	public static final String NUMERO_COLUMN_ONAME  = "numero";
	public static final String LOGRADOURO_COLUMN_NAME  = "logradouro";
	public static final String CIDADE_COLUMN_NAME  = "cidade";
	public static final String BAIRRO_COLUMN_NAME  = "bairro";
	public static final String CEP_COLUMN_NAME  = "cep";

	private GerenciadorConexao gerenciador;
	public ClienteDAO() throws ClassNotFoundException {
		this.gerenciador = GerenciadorConexao.getInstance();
	}
	
	public void inserir(Cliente cliente) throws SQLException{
		
		Connection con = null;
		PreparedStatement s = null;
		
		try {
			
			con = gerenciador.getConexao();
			
			String sql = "insert into cliente(cpf,nome,data_nascimento,Agencia_matricula,numero,logradouro,cidade,bairro,cep) values (?,?,?,?,?,?,?,?,?)";
			
			s = con.prepareStatement(sql);
			s.setString(1, cliente.getNome());
			s.setString(2, cliente.getNome());
			s.setDate(3, new Date(cliente.getDataNascimento().getTime()));
			s.setString(4, cliente.getAgenciaMatricula());
			s.setString(5, cliente.getNumeroEnd());
			s.setString(6, cliente.getLogradouro());
			s.setString(7, cliente.getCidade());
			s.setString(8, cliente.getBairro());
			s.setString(9, cliente.getCep());

			int qtd = s.executeUpdate();
			
			if (qtd == 0) throw new SQLException("Tupla n�o inserida!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(s != null) s.close();
			if(con != null)con.close();
		}
	}
}
