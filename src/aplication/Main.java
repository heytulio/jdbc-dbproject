package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import services.ClienteServices;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, ParseException {
SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
		ClienteServices service = new ClienteServices();
		
		Cliente cliente = new Cliente("11399999999","joartfd ctjcg",sdf.parse("20/04/1990"),"17729823000205","11","dfghj","asdfghj","dfghjk","33333000");

		service.salvarCliente(cliente);
		System.out.println("salvou");
		//service.removerCliente("11399999999");
		//Cliente atualizado = new Cliente("11399999999","atualizado",sdf.parse("20/04/1990"),"17729823000205","11","atualizado","asdfghj","dfghjk","33333000");
		//service.atualizarCliente(atualizado);
		//System.out.println("atualizou");
		List<Cliente> clientes = new ArrayList<>(service.listarClientes());
		for(Cliente i: clientes) {
			System.out.println(i.toString());
		}
		//System.out.println("listou");
		System.out.println(service.recuperarCliente("11399999999"));
		//service.removerTodos();
	}

}










