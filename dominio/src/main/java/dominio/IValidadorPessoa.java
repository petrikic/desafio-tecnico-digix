package dominio;

import java.time.LocalDate;

public interface IValidadorPessoa {
	
	public void validaNome(String nome);
	
	public void validaCpf(String cpf);
	
	public void validaRenda(double renda);
	
	public void validaDataNascimento(LocalDate dataNascimento);

}
