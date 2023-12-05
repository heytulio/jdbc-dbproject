package persistencia;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<C,E> {
	public void inserir(E entity) throws SQLException;
	public void remover(C chave) throws SQLException;
	public void atualizar(E entity) throws SQLException;
	public List<E> listar() throws SQLException;
	public E recuperar(C chave) throws SQLException;
	public void removerTodos() throws SQLException;
}
