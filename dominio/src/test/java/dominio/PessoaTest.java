package dominio;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PessoaTest {
	
	@Test
	public void testaCriacao() {
		
		Pessoa pessoa = assertDoesNotThrow(() -> {
			return Pessoa.cria("Fulano de Souza", "12345678921", 0, LocalDate.of(1988, 01, 01));
		}, "Execução não deveria gerar exceção.");
		
		assertNotNull("Deveria retornar a instância da pessoa.", pessoa);
	}
	
	@Test
	public void testaContagemDeIdadeParaMesQueJaPassou() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, LocalDate.of(1988, 01, 01));
		
		assertEquals(34, pessoa.idade(), "O calculo de idade deveria retornar 34 anos.");
	}
	
	@Test
	public void testaContagemDeIdadeParaMesQueNaoPassou() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, LocalDate.of(1988, 12, 01));
		
		assertEquals(33, pessoa.idade(), "O calculo de idade deveria retornar 33 anos.");
	}
	
	@Test
	public void testaMenoridade() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, LocalDate.of(2013, 12, 01));
		
		assertTrue("O método isMenorDeIdade deveria retornar true", pessoa.isMenorDeIdade());
	}
	
	@Test
	public void testaMaioridade() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, LocalDate.of(2000, 12, 01));
		
		assertFalse("O método isMenorDeIdade deveria retornar false", pessoa.isMenorDeIdade());
	}
	
	

}
