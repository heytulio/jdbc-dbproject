package persistencia;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<C,E> {
	public void inserir(E Cliente) throws SQLException;
	public void remover(C cpf) throws SQLException;
	public void atualizar(E Cliente) throws SQLException;
	public List<E> listar() throws SQLException;
	public E recuperar(C cpf) throws SQLException;
	public void removerTodos() throws SQLException;
}
