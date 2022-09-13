package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Familia;
import dominio.Pessoa;

class CriterioEntre901e1500ReaisTest {

private ICriterioAvaliacao criterio;
	
	@BeforeEach
	private void prepara() {
		criterio = new CriterioEntre901e1500Reais();
	}
	
	@Test
	public void testaPontuacaoCriterio() {
		assertEquals(3, criterio.pontos(), "A pontuação do critério deveria ser 3.");
	}
	
	@Test
	public void testaFamiliaComRenda800Reais() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 500, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Beltrano da Silva", "12345678921", 300, LocalDate.of(1986, 01, 01));

		Familia familia = new Familia(pretendente, conjuge, Collections.emptyList());
		
		assertFalse(criterio.isValido(familia), "Familia com renda de 800 rais deveria ser inválida pelo critério.");
	}
	
	@Test
	public void testaFamiliaComRenda1300Reais() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 900, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Ciclana da Silva", "12345678921", 400, LocalDate.of(1986, 01, 01));
		
		Familia familia = new Familia(pretendente, conjuge, Collections.emptyList());
		
		assertTrue(criterio.isValido(familia), "Familia com renda de 1300 reais deveria ser válida pelo critério.");
	}
	
	@Test
	public void testaFamiliaComRenda1700Reais() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 100, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Beltrana da Silva", "12345678921", 700, LocalDate.of(1986, 01, 01));
		
		Familia familia = new Familia(pretendente, conjuge, Collections.emptyList());
		
		assertFalse(criterio.isValido(familia), "Familia com renda de 1700 reais deveria ser inválida pelo critério.");
	}

}
