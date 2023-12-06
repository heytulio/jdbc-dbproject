package entities;

public class Academia {
	private String agencia;
	private String nome;
	public Academia(String agencia, String nome) {
		super();
		this.agencia = agencia;
		this.nome = nome;
	}
	public Academia() {
		
	}
	@Override
	public String toString() {
		return "agencia = " + agencia + ", nome = " + nome;
	}
	
}
