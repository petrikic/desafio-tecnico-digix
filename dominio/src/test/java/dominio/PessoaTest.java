package dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PessoaTest {
	
	@Test
	public void testaCriacao() {
		
		Pessoa pessoa = assertDoesNotThrow(() -> {
			return Pessoa.cria("Fulano de Souza", "12345678921", 0, Utils.getDate(01, 01, 1988));
		}, "Execução não deveria gerar exceção.");
		
		assertNotNull("Deveria retornar a instância da pessoa.", pessoa);
	}
	
	@Test
	public void testaContagemDeIdadeParaMesQueJaPassou() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, Utils.getDate(01, 01, 1988));
		
		assertEquals(34, pessoa.idade(), "O calculo de idade deveria retornar 34 anos.");
	}
	
	@Test
	public void testaContagemDeIdadeParaMesQueNaoPassou() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, Utils.getDate(01, 12, 1988));
		
		assertEquals(33, pessoa.idade(), "O calculo de idade deveria retornar 33 anos.");
	}
	
	@Test
	public void testaMenoridade() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, Utils.getDate(01, 12, 2013));
		
		assertTrue("O método isMenorDeIdade deveria retornar true", pessoa.isMenorDeIdade());
	}
	
	@Test
	public void testaMaioridade() {
		Pessoa pessoa = Pessoa.cria("Fulano de Souza", "12345678921", 0, Utils.getDate(01, 12, 2000));
		
		assertFalse("O método isMenorDeIdade deveria retornar false", pessoa.isMenorDeIdade());
	}
	
	

}
