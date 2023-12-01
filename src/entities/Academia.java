package entities;

import java.time.LocalTime;

public class Academia {
	//TODO arrumar a questão da hora, não sei qual
	//o tipo equivalente do SQL aqui
	private String agencia;
	private String nome;
	private LocalTime horaInicial;
	private LocalTime horaFinal;
	
	public Academia() {}

	public Academia(String agencia, String nome, LocalTime horaInicial, LocalTime horaFinal) {
		super();
		this.agencia = agencia;
		this.nome = nome;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalTime getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(LocalTime horaInicial) {
		this.horaInicial = horaInicial;
	}

	public LocalTime getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(LocalTime horaFinal) {
		this.horaFinal = horaFinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
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
		Academia other = (Academia) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Academia [agencia=" + agencia + ", nome=" + nome + ", horaInicial=" + horaInicial + ", horaFinal="
				+ horaFinal + "]";
	} 
	
}
