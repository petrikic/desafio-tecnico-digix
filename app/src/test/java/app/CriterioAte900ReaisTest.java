package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Familia;
import dominio.Pessoa;

class CriterioAte900ReaisTest {
	
	private ICriterioAvaliacao criterio;
	
	@BeforeEach
	private void prepara() {
		criterio = new CriterioAte900Reais();
	}
	
	@Test
	public void testaPontuacaoCriterio() {
		assertEquals(5, criterio.pontos(), "A pontuação do critério deveria ser 5.");
	}

	@Test
	public void testaFamiliaComRenda800Reais() {
		List<Pessoa> solicitantes = Arrays.asList(
				Pessoa.cria("Fulano de Souza", "12345678921", 500, LocalDate.of(1988, 01, 01)),
				Pessoa.cria("Beltrano da Silva", "12345678921", 300, LocalDate.of(1986, 01, 01))
			);
		
		Familia familia = new Familia(solicitantes, Collections.emptyList());
		
		assertTrue(criterio.isValido(familia), "Familia com renda de 800 rais deveria ser válida pelo critério.");
	}
	
	@Test
	public void testaFamiliaComRenda1500Reais() {
		List<Pessoa> solicitantes = Arrays.asList(
				Pessoa.cria("Fulano de Souza", "12345678921", 500, LocalDate.of(1988, 01, 01)),
				Pessoa.cria("Beltrano da Silva", "12345678921", 300, LocalDate.of(1986, 01, 01)),
				Pessoa.cria("Ciclano de Souza", "12345678921", 700, LocalDate.of(1986, 01, 01))
			);
		
		Familia familia = new Familia(solicitantes, Collections.emptyList());
		
		assertFalse(criterio.isValido(familia), "Familia com renda de 1500 reais deveria ser inválida pelo critério.");
	}

}