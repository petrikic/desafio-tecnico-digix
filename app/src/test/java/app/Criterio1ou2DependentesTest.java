package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dominio.Familia;
import dominio.Pessoa;

class Criterio1ou2DependentesTest {

	private ICriterioAvaliacao criterio;
	
	@BeforeEach
	private void prepara() {
		criterio = new Criterio1ou2Dependentes();
	}
	
	@Test
	public void testaPontuacaoCriterio() {
		assertEquals(2, criterio.pontos(), "A pontuação do critério deveria ser 2.");
	}

	@Test
	public void testaFamiliaCom2Dependentes() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 1500, LocalDate.of(1988, 01, 01));
		
		List<Pessoa> dependentes = Arrays.asList(
				Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2013, 07, 14)),
				Pessoa.cria("Beltraninho da Silva", "12345678921", 0, LocalDate.of(2019, 11, 25))
			);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		assertTrue(criterio.isValido(familia), "Familia com 2 dependentes deveria ser válida para critério.");
	}
	
	@Test
	public void testaFamiliaCom3Dependentes() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
		
		List<Pessoa> dependentes = Arrays.asList(
				Pessoa.cria("Fulaninha de Souza", "12345678921", 0, LocalDate.of(2017, 03, 03)),
				Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2013, 07, 14)),
				Pessoa.cria("Beltraninho da Silva", "12345678921", 0, LocalDate.of(2019, 11, 25))
			);
		
		Familia familia = new Familia(pretendente, null, dependentes);
		
		assertFalse(criterio.isValido(familia), "Familia com 3 dependentes deveria ser válida para critério.");
	}

}
