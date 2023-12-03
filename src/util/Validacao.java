package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.*;

public class Validacao {
	
	public static boolean validaCpf(String cpf) throws DomainException {
		if (cpf.length() != 11) {
			throw new DomainException("CPF POSSUI TAMANHO INVALIDO;");
		} else {
			for (int i = 0; i < cpf.length(); i++) {
				var verifica = cpf.charAt(i);
				if (!(Character.isDigit(verifica))) {
					throw new DomainException("CPF POSSUI DIGITOS INVALIDOS, INSIRA UM CPF VALIDO;");
				}
			}
			return true;
		}
	}

	public static boolean validaNome(String nome) throws DomainException {
		nome = nome.replaceAll(" ","");

		if (nome.length() < 3)
			throw new DomainException("NOME TEM QUE POSSUIR MAIS QUE 3 CARACTERES");
		for (int i = 0; i < nome.length(); i++) {
			var verifica = nome.charAt(i);
			if (!(Character.isLetter(verifica)) == true) {
				throw new DomainException("O NOME INVALIDO, POSSUI NUMEROS;");
			}
		}
		return true;
	}

	public static boolean validaCep(String cep) throws DomainException {
		String regexCep = "^\\d{8}$";
		Pattern patternAuth = Pattern.compile(regexCep);
		Matcher matcher = patternAuth.matcher(cep);
		if (matcher.matches() == true)
			return true;
		else
			throw new DomainException("CEP INSERIDO É INVALIDO");
	}
	
	public static boolean validaAgencia(String agencia) throws DomainException {
		if (agencia.length() != 14) {
			throw new DomainException("CNPJ DA Agencia POSSUI TAMANHO INVALIDO;");
		} else {
			for (int i = 0; i < agencia.length(); i++) {
				var verifica = agencia.charAt(i);
				if (!(Character.isDigit(verifica))) {
					throw new DomainException("CNPJ POSSUI DIGITOS INVALIDOS, INSIRA UM CPF VALIDO;");
				}
			}
			return true;
		}
	}
	
	public static boolean validaTelefone(String telefone) throws DomainException {
		String regexCep = "^\\d{12}$";
		Pattern patternAuth = Pattern.compile(regexCep);
		Matcher matcher = patternAuth.matcher(telefone);
		if (matcher.matches() == true)
			return true;
		else
			throw new DomainException("TELEFONE INSERIDO É INVALIDO");
	}
}
