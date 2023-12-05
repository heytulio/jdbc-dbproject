package services;

import java.sql.SQLException;

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

}
