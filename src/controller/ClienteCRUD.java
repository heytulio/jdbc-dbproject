package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import exceptions.DomainException;
import util.Validacao;

public class ClienteCRUD implements ICRUD {

	private static Scanner input = new Scanner(System.in);
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// temporario
	List<Cliente> clientes = new ArrayList<>();

	@Override
	public void cadastrar() {

		String cpf;
		String nome;
		LocalDate dataNascimento;
		String agenciaMatricula;
		String cep;

		while (true) {
			try {
				System.out.print("Informe o CPF: ");
				cpf = input.nextLine();
				Validacao.validaCpf(cpf);
				break;
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Informe o nome: ");
				nome = input.nextLine();
				Validacao.validaNome(nome);
				break;
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		while (true) {
			try {
				System.out.print("Informe a data de nascimento (dd/mm/aaaa): ");
				dataNascimento = LocalDate.parse(input.nextLine(), dtf);
				break;
			} catch (DateTimeParseException e) {
				System.out.println(e.getMessage());
			}
		}
		// aqui tem que fazer uma consulta no BD pra
		// retornar a lista das academias cadastradas
		// TODO criar um DAO de Academia e um service de academia tbm
		while (true) {
			try {
				System.out.print("Informe o numero da matricula da academia: ");
				agenciaMatricula = input.nextLine();
				Validacao.validaAgencia(agenciaMatricula);
				break;
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.print("Informe o logradouro: ");
		var logradouro = input.nextLine();
		System.out.print("Informe o numero do endereço: ");
		var numeroEnd = input.nextLine();
		System.out.print("Informe a cidade: ");
		var cidade = input.nextLine();
		System.out.print("Informe o bairro: ");
		var bairro = input.nextLine();
		while (true) {
			try {
				System.out.print("Informe o CEP: ");
				cep = input.nextLine();
				Validacao.validaCep(cep);
				break;
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		Cliente c = new Cliente(cpf, nome, dataNascimento, agenciaMatricula, numeroEnd, logradouro, cidade, bairro,
				cep);
		System.out.print("Informe um telefone: ");
		while (true) {
			try {
				String telefone = input.nextLine();
				Validacao.validaTelefone(telefone);
				System.out.print("Deseja cadastrar outro telefone? (S/N) ");
				char op = input.next().charAt(0);
				if (Character.toUpperCase(op) == 'S') {
					c.addTelefone(telefone);
					input.nextLine();
					continue;
				} else {
					c.addTelefone(telefone);
					break;
				}
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("--------------------------");
		System.out.println("Cliente Cadastrado!");
		clientes.add(c);
		//clienteService.inserir(c);
	}

	@Override
	public void atualizar() {

		// vou fazer aqui, mas esperando que tenha um retorno de List<Cliente>
		List<Cliente> clientesDB = clientes; // aqui meter um clienteService.listar();
		if (clientesDB.size() == 0) {
			System.out.println("Sem clientes cadastrados;");
		} else {
			input.nextLine();
			System.out.println("Clientes cadastrados no banco: ");
			clientesDB.stream().map(x-> x.getCpf()+" - "+x.getNome()).forEach(System.out::println);
			System.out.print("Informe o CPF do Cliente para a atualizacao: ");
			String cpf = input.nextLine();
			for (Cliente c : clientesDB) {
				if (c.getCpf().equals(cpf)) {
					System.out.println("--------------------------");
					System.out.println("Dados do Cliente: ");
					System.out.println(c);
					System.out.println("--------------------------");
					while (true) {
						System.out.println("CAMPOS:\n"
								+ "NOME; NASCIMENTO; AGENCIA; LOGRADOURO; NUMERO; CIDADE; BAIRRO; CEP; TELEFONE;\n"
								+ "Digite SAIR para voltar ao menu;");
						System.out.print("Informe qual campo deseja atualizar: ");
						String campo = input.nextLine();
						if (campo.equalsIgnoreCase("NOME")) {
							while (true) {
								try {
									System.out.print("Informe o nome: ");
									String nome = input.nextLine();
									Validacao.validaNome(nome);
									if (c.getNome().equalsIgnoreCase(nome)) {
										System.out.println("PARAMETRO IGUAL;");
										break;
									}
									c.setNome(nome);
									System.out.println("CAMPO ATUALIZADO;");
									System.out.println("--------------------------");
									break;
								} catch (DomainException e) {
									System.out.println(e.getMessage());
								}
							}
						} else if (campo.equalsIgnoreCase("NASCIMENTO")) {
							while (true) {
								try {
									System.out.print("Informe a data de nascimento (dd/mm/aaaa): ");
									LocalDate dataNascimento = LocalDate.parse(input.nextLine(), dtf);
									if (c.getDataNascimento().isEqual(dataNascimento)) {
										System.out.println("PARAMETRO IGUAL;");
										break;
									}
									c.setDataNascimento(dataNascimento);
									System.out.println("CAMPO ATUALIZADO;");
									System.out.println("--------------------------");
									break;
								} catch (DateTimeParseException e) {
									System.out.println(e.getMessage());
								}
							}
						} else if (campo.equalsIgnoreCase("AGENCIA")) {
							System.out.println("Campo não disponivel;");
							System.out.println("--------------------------");
							// isso da B.O. no Banco?
						} else if (campo.equalsIgnoreCase("LOGRADOURO")) {
							System.out.print("Informe o logradouro: ");
							var logradouro = input.nextLine();
							if (c.getLogradouro().equalsIgnoreCase(logradouro)) {
								System.out.println("MESMO PARAMETRO;");
								continue;
							}
							c.setLogradouro(logradouro);
							System.out.println("CAMPO ATUALIZADO;");
							System.out.println("--------------------------");
						} else if (campo.equalsIgnoreCase("NUMERO")) {
							System.out.print("Informe o numero do endereço: ");
							var numeroEnd = input.nextLine();
							if (c.getNumeroEnd().equalsIgnoreCase(numeroEnd)) {
								System.out.println("MESMO PARAMETRO;");
								continue;
							}
							c.setNumeroEnd(numeroEnd);
							System.out.println("CAMPO ATUALIZADO;");
							System.out.println("--------------------------");
						} else if (campo.equalsIgnoreCase("CIDADE")) {
							System.out.print("Informe a cidade: ");
							var cidade = input.nextLine();
							if (c.getCidade().equalsIgnoreCase(cidade)) {
								System.out.println("MESMO PARAMETRO;");
								continue;
							}
							c.setCidade(cidade);
							System.out.println("CAMPO ATUALIZADO;");
							System.out.println("--------------------------");
						} else if (campo.equalsIgnoreCase("BAIRRO")) {
							System.out.print("Informe o bairro: ");
							var bairro = input.nextLine();
							if (c.getBairro().equalsIgnoreCase(bairro)) {
								System.out.println("MESMO PARAMETRO;");
								continue;
							}
							c.setBairro(bairro);
							System.out.println("CAMPO ATUALIZADO;");
							System.out.println("--------------------------");
						} else if (campo.equalsIgnoreCase("CEP")) {
							while (true) {
								try {
									System.out.print("Informe o CEP: ");
									String cep = input.nextLine();
									Validacao.validaCep(cep);
									if (c.getCep().equals(cep)) {
										System.out.println("MESMO PARAMETRO;");
										break;
									}
									c.setCep(cep);
									System.out.println("CAMPO ATUALIZADO;");
									System.out.println("--------------------------");
									break;
								} catch (DomainException e) {
									System.out.println(e.getMessage());
								}
							}
						} else if (campo.equalsIgnoreCase("TELEFONE")) {
							List<String> telefones = c.getTelefones();
							System.out.println("Telefones do Cliente: ");
							for (int i = 0; i < telefones.size(); i++) {
								System.out.println(i + "-> " + telefones.get(i));
							}
							try {
								System.out.print("Informe o ID do numero para a atualização: ");
								int match = input.nextInt();
								input.nextLine();
								String telefone;
								while (true) {
									try {
										System.out.print("Informe o telefone para a atualização: ");
										telefone = input.nextLine();
										Validacao.validaTelefone(telefone);
										break;
									} catch (DomainException e) {
										System.out.println(e.getMessage());
									}
								}
								if (match < 0 || match >= telefones.size()) {
									System.out.println("ID INFORMADO É INVALIDO;");
								} else {
									telefones.set(match, telefone);
									System.out.println("CAMPO ATUALIZADO;");
									System.out.println("--------------------------");
								}
							} catch (InputMismatchException e) {
								System.out.println(e.getMessage());
							} catch (IndexOutOfBoundsException e) {
								System.out.println(e.getMessage());
							}
						} else if (campo.equalsIgnoreCase("SAIR")) {
							break;
						} else {
							System.out.println("OPÇÃO SEM CORRESPONDENCIA");
						}
					}
				}
			}
		}
	}

	@Override
	public void listar() {
		if (clientes.size() == 0) {
			System.out.println("cadastra primeiro ze");
		} else {
			System.out.println("Clientes cadastrados: ");
			clientes.stream().forEach(System.out::println);
		}

	}

	@Override
	public void deletar() {
		// TODO implementar a deleção
		// preciso do service.listar()

	}

}
