package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import persistencia.GenericDao;
import persistencia.GerenciadorConexao;

public class ClienteDAO implements GenericDao<String, Cliente>{

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
	public static final String NUMERO_COLUMN_NAME  = "numero";
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
			s.setString(1, cliente.getCpf());
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

	@Override
	public void remover(String cpf) throws SQLException {
		Connection con = null;
		PreparedStatement s = null;
		
		try {
			
			con = gerenciador.getConexao();
			
			String sql = "delete from cliente where cpf = ?";
			
			s = con.prepareStatement(sql);
			s.setString(1, cpf);
			int qtd = s.executeUpdate();
			
			if (qtd == 0) throw new SQLException("Tupla n�o encontrada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(con != null)con.close();
			if(s != null)s.close();
		}		
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {
		Connection con = null;
		PreparedStatement s = null;
		
		try {
			con = gerenciador.getConexao();
			
			String sql = "update cliente set nome = ?,data_nascimento = ?,Agencia_matricula = ?,numero = ?,logradouro = ?,cidade = ?,bairro = ?,cep = ? where cpf = ?";
			s = con.prepareStatement(sql);
			s.setString(1, cliente.getNome());
			s.setDate(2, new Date(cliente.getDataNascimento().getTime()));
			s.setString(3, cliente.getAgenciaMatricula());
			s.setString(4, cliente.getNumeroEnd());
			s.setString(5, cliente.getLogradouro());
			s.setString(6, cliente.getCidade());
			s.setString(7, cliente.getBairro());
			s.setString(8, cliente.getCep());
			s.setString(9, cliente.getCpf());

			int qtd = s.executeUpdate();
			
			if (qtd == 0) throw new SQLException("Tupla n�o encontrada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(con != null)con.close();
			if(s != null) s.close();
		}		
	}

	@Override
	public List<Cliente> listar() throws SQLException {
		Connection con = null;
		Statement s = null;
		ResultSet rs = null;
		List<Cliente> clientes = null;
		
		try {
			
			con = gerenciador.getConexao();
			
			String sql = "select * from cliente";
			
			s = con.createStatement();	
			rs = s.executeQuery(sql);
			
			clientes = new ArrayList<Cliente>();
			
			while(rs.next()){
				String cpf = rs.getString(CPF_COLUMN_NAME);
				String nome = rs.getString(NOME_COLUMN_NAME);
				Date data = rs.getDate(DATA_NASCIMENTO_COLUMN_NAME);
				String agencia = rs.getString(AGENCIA_MATRICULA_COLUMN_NAME);
				String numero = rs.getString(NUMERO_COLUMN_NAME);
				String logradouro = rs.getString(LOGRADOURO_COLUMN_NAME);
				String cidade = rs.getString(CIDADE_COLUMN_NAME);
				String bairro = rs.getString(BAIRRO_COLUMN_NAME);
				String cep = rs.getString(CEP_COLUMN_NAME);
				clientes.add(new Cliente(cpf,nome,new java.util.Date(data.getTime()),agencia,numero,logradouro,cidade,bairro,cep));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null)con.close();
			if(s != null)s.close();
			if(rs != null) rs.close();
		}
		
		return clientes;
	}

	@Override
	public Cliente recuperar(String cpf) throws SQLException {
		Connection con = null;
		PreparedStatement s = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			
			con = gerenciador.getConexao();
			
			String sql = "select * from cliente where cpf = ?";
			
			s = con.prepareStatement(sql);	
			s.setString(1, cpf);
			rs = s.executeQuery();
			
			if(rs.next()){
				String cpf_ = rs.getString(CPF_COLUMN_NAME);
				String nome = rs.getString(NOME_COLUMN_NAME);
				Date data = rs.getDate(DATA_NASCIMENTO_COLUMN_NAME);
				String agencia = rs.getString(AGENCIA_MATRICULA_COLUMN_NAME);
				String numero = rs.getString(NUMERO_COLUMN_NAME);
				String logradouro = rs.getString(LOGRADOURO_COLUMN_NAME);
				String cidade = rs.getString(CIDADE_COLUMN_NAME);
				String bairro = rs.getString(BAIRRO_COLUMN_NAME);
				String cep = rs.getString(CEP_COLUMN_NAME);
				cliente = new Cliente(cpf_,nome,new java.util.Date(data.getTime()),agencia,numero,logradouro,cidade,bairro,cep);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null)con.close();
			if(s != null)s.close();
			if(rs != null) rs.close();
		}
		
		return cliente;
	}

	@Override
	public void removerTodos() throws SQLException {
		Connection con = null;
		Statement s = null;
		
		try {
			
			con = gerenciador.getConexao();
			
			String sql = "delete from cliente";
			
			s = con.createStatement();
			s.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(con != null)con.close();
			if(s != null)s.close();
		}		
	}
}
