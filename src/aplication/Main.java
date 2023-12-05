package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import entities.Cliente;
import services.ClienteServices;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {
SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
		ClienteServices service = new ClienteServices();
		
		Cliente cliente = new Cliente("11311118711","joa",sdf.parse("20/04/1990"),"17729823000205","11","dfghj","asdfghj","dfghjk","33333000");

		service.salvarCliente(cliente);
	}

}
