package application;

import java.util.Scanner;

import controller.ClienteCRUD;

public class Program {

	public static void main(String[] args) {
		
		ClienteCRUD c = new ClienteCRUD();
		Scanner input = new Scanner(System.in);
		System.out.println("--------------------------");
		System.out.println("Bem Vindo a Aplicacao!");
		while (true) {
			menu();
			char op = input.next().charAt(0);
			switch (op){
				case '1': 
					System.out.println("--------------------------");
					System.out.println("Menu de Clientes:");
					System.out.println("--------------------------");
					System.out.println("1 - Cadastrar Cliente;\n"
							+ "2 - Atualizar Cliente;\n"
							+ "3 - Listar Cliente;\n"
							+ "4 - Deletar Cliente;\n"
							+ "0 - Voltar;");
					System.out.print("-> ");
					char cOP = input.next().charAt(0);
					System.out.println("--------------------------");
					if(cOP == '1') c.cadastrar();
					else if(cOP == '2') c.atualizar();
					else if(cOP == '3') c.listar();
					else if(cOP == '4') c.deletar();
					else if (cOP == '0') break;
					break;

				case '2':
					System.out.println("--------------------------");
					System.out.println("Menu de Consultas:");
					System.out.println("--------------------------");
					System.out.println("1 - Listar todos os clientes;\n"
							+ "2 - Consulta por CPF;\n"
							+ "3 - Consulta;\n"
							+ "4 - Consulta;\n"
							+ "0 - Voltar;");
					System.out.print("-> ");
					char cOP1 = input.next().charAt(0);
					System.out.println("--------------------------");
					if (cOP1 == '0') break;
					break;
				case '0':
					break;
				default:
					System.out.println("NO MATCHES");
					break;
			}
			if (op == '0') break;
		}
		System.out.println("ENCERRANDO O PROGRAMA;");
		input.close();
	}
	public static void menu() {
		System.out.println("--------------------------");
		System.out.println("1 - Menu de Clientes;\n"
				+ "2 - Menu de Consultas;\n"
				+ "0 - Encerrar o programa;");
		System.out.print("-> ");
	}

}
