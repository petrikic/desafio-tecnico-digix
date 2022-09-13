package app;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Familia;
import dominio.Pessoa;

class Criterio3ouMaisDependentesTest {
	
	private ICriterioAvaliacao criterio;

	@BeforeEach
	private void prepara() {
		criterio = new Criterio3ouMaisDependentes();
	}
	
	@Test
	public void testaPontuacaoCriterio() {
		assertEquals(3, criterio.pontos(), "A pontuação do critério deveria ser 2.");
	}

	@Test
	public void testaFamiliaCom1Dependente() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 1500, LocalDate.of(1988, 01, 01));

		List<Pessoa> dependentes = Arrays.asList(
				Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2013, 07, 14))
			);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		assertFalse(criterio.isValido(familia), "Familia com 1 dependente deveria ser inválida para critério.");
	}
	
	@Test
	public void testaFamiliaCom5Dependentes() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
		
		List<Pessoa> dependentes = Arrays.asList(
				Pessoa.cria("Fulaninha de Souza", "12345678921", 0, LocalDate.of(2017, 03, 03)),
				Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2013, 07, 14)),
				Pessoa.cria("Beltraninho da Silva", "12345678921", 0, LocalDate.of(2019, 11, 25)),
				Pessoa.cria("Ciclaninha de Souza", "12345678921", 0, LocalDate.of(2012, 01, 24)),
				Pessoa.cria("Beltraninha da Silva", "12345678921", 0, LocalDate.of(2017, 06, 05))
			);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		assertTrue(criterio.isValido(familia), "Familia com 5 dependentes deveria ser válida para critério.");
	}

}
