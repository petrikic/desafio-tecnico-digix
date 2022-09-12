package dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FamiliaTest {

	private Familia familia;
	
	@BeforeEach
	public void prepara() {
		Pessoa pretendente = Pessoa.cria("Fulano de Souza", "12345678921", 500, Utils.getDate(01, 01, 1988));
		Pessoa conjuge = Pessoa.cria("Ciclana da Silva", "12345678921", 600, Utils.getDate(07, 06, 1986));
		
		List<Pessoa> dependentes = Arrays.asList(
					Pessoa.cria("Fulaninho de Souza", "12345678921", 100, Utils.getDate(12, 04, 2009)),
					Pessoa.cria("Ciclano de Souza", "12345678921", 250, Utils.getDate(01, 01, 2000)),
					Pessoa.cria("Fulana da Silva", "12345678921", 0, Utils.getDate(14, 12, 2014)),
					Pessoa.cria("Juninho de Souza", "12345678921", 0, Utils.getDate(27, 05, 2007)),
					Pessoa.cria("Beltraninha da Silva", "12345678921", 0, Utils.getDate(13, 07, 2015))
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
