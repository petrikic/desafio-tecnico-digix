package dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private double renda;
	private Date dataNascimento;
	
	private Pessoa(String nome, String cpf, double renda, Date dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
		this.dataNascimento = dataNascimento;
	}
	
	public static Pessoa cria(String nome, String cpf, double renda, Date dataNascimento) {
		ValidadorPessoa.valida(nome, cpf, renda, dataNascimento);
		return new Pessoa(nome, cpf, renda, dataNascimento);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public double getRenda() {
		return this.renda;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
	}
	
	public int idade() {
		LocalDate dataNascimentoLocalDate = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Period.between(dataNascimentoLocalDate, LocalDate.now()).getYears();
	}
	
	public boolean isMenorDeIdade() {
		return idade() < 18;
	}

}
