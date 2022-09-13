package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dominio.Familia;
import dominio.ICalculadorDePontuacao;
import dominio.Pessoa;

class CalculadorDePontuacaoTest {

	private ICalculadorDePontuacao calculador;
	
	@BeforeEach
	private void prepara() {
		calculador = new CalculadorDePontuacao();
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe2000ReaisESemDependentes() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 1200, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Beltrano de Souza", "12345678921", 800, LocalDate.of(1992, 10, 27));
		
		Familia familia = new Familia(pretendente, conjuge, Collections.emptyList());
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(0, valorCalculado, "O valor calculado para a família deveria ser de 0 pontos.");
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe800ReaisESemDependentes() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Beltrana da Silva", "12345678921", 200, LocalDate.of(1993, 10, 15));
		
		Familia familia = new Familia(pretendente, conjuge, Collections.emptyList());
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(5, valorCalculado, "O valor calculado para a família deveria ser de 5 pontos.");
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe800ReaisEDoisDependentesMenores() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 200, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclano de Souza", "12345678921", 0, LocalDate.of(2007, 01, 01))
				);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(7, valorCalculado, "O valor calculado para a família deveria ser de 7 pontos.");
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe800ReaisEQuatroDependentesMenores() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 600, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 200, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2018, 01, 01)),
					Pessoa.cria("Beltraninho de Souza", "12345678921", 0, LocalDate.of(2010, 10, 21)),
					Pessoa.cria("Ciclaninha de Souza", "12345678921", 0, LocalDate.of(2015, 06, 13))
				);
		
		Familia familia = new Familia(pretendente, null, dependentes);
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(8, valorCalculado, "O valor calculado para a família deveria ser de 8 pontos.");
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe2000ReaisEUmDependenteMenor() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 0, LocalDate.of(2012, 04, 12))
				);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(2, valorCalculado, "O valor calculado para a família deveria ser de 2 pontos.");
	}
	
	@Test
	public void calculaPontuacaoFamiliaComRendaDe2000ReaisETresDependentesMenores() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 2000, LocalDate.of(1988, 01, 01));
	
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 0, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclaninho de Souza", "12345678921", 0, LocalDate.of(2010, 01, 01)),
					Pessoa.cria("Beltraninho de Souza", "12345678921", 0, LocalDate.of(2015, 10, 21))
				);
		
		Familia familia = new Familia(pretendente, dependentes);
		
		int valorCalculado = calculador.calcula(familia);
		assertEquals(3, valorCalculado, "O valor calculado para a família deveria ser de 2 pontos.");
	}

}
