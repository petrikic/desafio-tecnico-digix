package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Familia;
import dominio.Pessoa;

class SelecionadorDeFamiliasAptasTest {
	
	private SelecionadorDeFamiliasAptas selecionador;
	
	@BeforeEach
	public void prepara() {
		selecionador = new SelecionadorDeFamiliasAptas();
	}
	
	@Test
	public void testaSelecionadorDeFamilias() {
		List<Familia> familias = Arrays.asList(
					familia1(),
					familia2(),
					familia3(),
					familia4(),
					familia5(),
					familia6()
				);
		
		List<Familia> familiasSelecionadas = selecionador.seleciona(familias);
		assertEquals(5, familiasSelecionadas.size(), "Deveriam ter sido selecionadas 5 familias.");
		assertEquals(8, familiasSelecionadas.get(0).getPontuacao(), "A pontuação da primeira familia deveria ser 8.");
		assertEquals(7, familiasSelecionadas.get(1).getPontuacao(), "A pontuação da segunda familia deveria ser 7.");
		assertEquals(5, familiasSelecionadas.get(2).getPontuacao(), "A pontuação da terceira familia deveria ser 5.");
		assertEquals(3, familiasSelecionadas.get(3).getPontuacao(), "A pontuação da quarta familia deveria ser 3.");
		assertEquals(2, familiasSelecionadas.get(4).getPontuacao(), "A pontuação da quinta familia deveria ser 2.");
	}

	private Familia familia1() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 1200, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Ciclana de Souza", "12345678921", 800, LocalDate.of(1992, 10, 27));

		return new Familia(pretendente, conjuge, Collections.emptyList());
	}
	
	private Familia familia2() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Beltrana da Silva", "12345678921", 200, LocalDate.of(1993, 10, 15));
		
		return new Familia(pretendente, conjuge, Collections.emptyList());
	}
	
	private Familia familia3() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 200, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclano de Souza", "12345678921", 0, LocalDate.of(2007, 01, 01))
				);
		
		return new Familia(pretendente, dependentes);
	}
	
	private Familia familia4() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 200, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2018, 01, 01)),
					Pessoa.cria("Beltraninho de Souza", "12345678921", 0, LocalDate.of(2010, 10, 21)),
					Pessoa.cria("Ciclaninha de Souza", "12345678921", 0, LocalDate.of(2015, 06, 13))
				);
		
		return new Familia(pretendente, dependentes); 
	}
	
	private Familia familia5() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
		
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 0, LocalDate.of(2012, 04, 12))
				);
		
		return new Familia(pretendente, dependentes);
	}
	
	private Familia familia6() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 0, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2010, 01, 01)),
					Pessoa.cria("Beltraninho de Souza", "12345678921", 0, LocalDate.of(2015, 10, 21))
				);
		
		return new Familia(pretendente, dependentes);
	}

}
