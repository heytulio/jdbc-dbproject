package Dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<C,O> {
	void adicionar(O objeto) throws SQLException;
	List<O> listar() throws SQLException;
	void remover(C chave) throws SQLException;
	void atualizar(O objeto) throws SQLException;
}
