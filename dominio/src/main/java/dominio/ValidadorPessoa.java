package dominio;

import java.time.LocalDate;

public class ValidadorPessoa {
	
	private static IValidadorPessoa validador;
	
	public static IValidadorPessoa getInstancia() {
		if(validador == null)
			validador = new ValidadorPessoaNull();
		return validador;
	}
	
	public static void setInstancia(IValidadorPessoa validador) {
		ValidadorPessoa.validador = validador;
	}
	
	public static void valida(String nome, String cpf, double renda, LocalDate dataNascimento) {
		getInstancia().validaNome(nome);
		getInstancia().validaCpf(cpf);
		getInstancia().validaRenda(renda);
		getInstancia().validaDataNascimento(dataNascimento);
	}

}
