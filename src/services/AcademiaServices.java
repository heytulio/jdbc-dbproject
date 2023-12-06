package services;

import java.sql.SQLException;
import java.util.List;

import Dao.AcademiaDAO;
import entities.Academia;

public class AcademiaServices {

	private AcademiaDAO dao;

	public AcademiaServices() throws ClassNotFoundException {
		this.dao = new AcademiaDAO();
	}

	
	public List<Academia> listarAcademias() {
		try {
			return dao.listar();
		} catch (SQLException e) {
			return null;
		}
	}
}
