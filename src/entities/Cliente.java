package entities;

import java.time.LocalDate;

public class Cliente {
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	private String agenciaMatricula;
	private String numeroEnd;
	private String logradouro;
	private String cidade;
	private String bairro;
	private String cep;
	
	public Cliente() {}
	public Cliente(String cpf, String nome, LocalDate dataNascimento, String agenciaMatricula, String numeroEnd,
			String logradouro, String cidade, String bairro, String cep) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.agenciaMatricula = agenciaMatricula;
		this.numeroEnd = numeroEnd;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getAgenciaMatricula() {
		return agenciaMatricula;
	}
	public void setAgenciaMatricula(String agenciaMatricula) {
		this.agenciaMatricula = agenciaMatricula;
	}
	public String getNumeroEnd() {
		return numeroEnd;
	}
	public void setNumeroEnd(String numeroEnd) {
		this.numeroEnd = numeroEnd;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", agenciaMatricula="
				+ agenciaMatricula + ", numeroEnd=" + numeroEnd + ", logradouro=" + logradouro + ", cidade=" + cidade
				+ ", bairro=" + bairro + ", cep=" + cep + "]";
	}
	
	
}
