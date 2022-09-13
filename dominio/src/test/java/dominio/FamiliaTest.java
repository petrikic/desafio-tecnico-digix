package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamiliaTest {

	private Familia familia;
	
	@BeforeEach
	public void prepara() {

		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 500, LocalDate.of(1988, 01, 01));
		Pessoa conjuge = Pessoa.cria("Ciclana da Silva", "12345678921", 600, LocalDate.of(1986, 07, 06));
		
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 100, LocalDate.of(2009, 04, 12)),
					Pessoa.cria("Ciclano de Souza", "12345678921", 250, LocalDate.of(2000, 01, 01)),
					Pessoa.cria("Fulana da Silva", "12345678921", 0, LocalDate.of(2014, 12, 14)),
					Pessoa.cria("Juninho de Souza", "12345678921", 0, LocalDate.of(2007, 05, 27)),
					Pessoa.cria("Beltraninha da Silva", "12345678921", 0, LocalDate.of(2015, 07, 13))
				);
		
		familia = new Familia(pretendente, conjuge, dependentes);
	}
	
	@Test
	public void testaCalculoDeRendaDoPretendente() {
		assertEquals(500, familia.rendaDoPretendente(), "A método rendaDosSolicitantes deveria retornar o valor 500.");
	}
	
	@Test
	public void testaCalculoDeRendaDoConjuge() {
		assertEquals(600, familia.rendaDoConjuge(), "A método rendaDosSolicitantes deveria retornar o valor 600.");
	}
	
	@Test
	public void testaCalculoDeRendaDosDependentes() {
		assertEquals(350, familia.rendaDosDependentes(), "A método rendaDosDependentes deveria retornar o valor 350.");
	}
	
	@Test
	public void testaCalculoDeRendaFamiliar() {
		assertEquals(1450, familia.rendaFamiliar(), "A método rendaFamiliar deveria retornar o valor 1450.");
	}
	
	@Test void testaCalculoNumeroDeDependentesMenores() {
		assertEquals(4, familia.numeroDeDependentesMenores(), "O método numeroDeDependentesMenores deveria retornar 4.");
	}

}
