package dominio;

import java.time.LocalDate;

public class ValidadorPessoaNull implements IValidadorPessoa{

	@Override
	public void validaNome(String nome) {}

	@Override
	public void validaCpf(String cpf) {}

	@Override
	public void validaRenda(double renda) {}

	@Override
	public void validaDataNascimento(LocalDate dataNascimento) {}

}
