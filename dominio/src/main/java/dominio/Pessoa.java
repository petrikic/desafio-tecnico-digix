package dominio;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private double renda;
	private LocalDate dataNascimento;
	
	private Pessoa(String nome, String cpf, double renda, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
		this.dataNascimento = dataNascimento;
	}
	
	public static Pessoa cria(String nome, String cpf, double renda, LocalDate dataNascimento) {
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
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public int idade() {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
	public boolean isMenorDeIdade() {
		return idade() < 18;
	}

}
