package services;

import java.sql.SQLException;
import java.util.List;

import Dao.ClienteDAO;
import entities.Cliente;

public class ClienteServices {

	private ClienteDAO dao;

	public ClienteServices() throws ClassNotFoundException {
		this.dao = new ClienteDAO();
	}

	public boolean salvarCliente(Cliente cliente) {
		try {
			this.dao.inserir(cliente);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean removerCliente(String cpf) {
		try {
			dao.remover(cpf);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean atualizarCliente(Cliente cliente) {
		try {
			dao.atualizar(cliente);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public List<Cliente> listarClientes() {
		try {
			return dao.listar();
		} catch (SQLException e) {
			return null;
		}
	}
	public Cliente recuperarCliente(String cpf) {
		try {
			return dao.recuperar(cpf);
		} catch (SQLException e) {
			return null;
		}
	}
	public void removerTodos() {
		try {
			dao.removerTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
