package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Academia;
import persistencia.GenericDao;
import persistencia.GerenciadorConexao;

public class AcademiaDAO implements GenericDao<String, Academia> {
	public static final int AGENCIA_COLUMN_ORDER = 1;
	public static final int NOME_COLUMN_ORDER = 2;

	public static final String AGENCIA_COLUMN_NAME = "agencia";
	public static final String NOME_COLUMN_NAME = "nome";

	private GerenciadorConexao gerenciador;

	public AcademiaDAO() throws ClassNotFoundException {
		this.gerenciador = GerenciadorConexao.getInstance();
	}

	

	@Override
	public List<Academia> listar() throws SQLException {
			Connection con = null;
			Statement s = null;
			ResultSet rs = null;
			List<Academia> academias = null;
			
			try {
				
				con = gerenciador.getConexao();
				
				String sql = "select * from academia";
				
				s = con.createStatement();	
				rs = s.executeQuery(sql);
				
				academias = new ArrayList<Academia>();
				
				while(rs.next()){
					String agencia = rs.getString(AGENCIA_COLUMN_NAME);
					String nome = rs.getString(NOME_COLUMN_NAME);
					
					academias.add(new Academia(agencia,nome));
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(con != null)con.close();
				if(s != null)s.close();
				if(rs != null) rs.close();
			}
			
			return academias;
	}



	@Override
	public void inserir(Academia entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void remover(String chave) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void atualizar(Academia entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Academia recuperar(String chave) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void removerTodos() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

	

}
