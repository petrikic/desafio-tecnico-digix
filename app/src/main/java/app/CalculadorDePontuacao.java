package app;

import java.util.Arrays;
import java.util.List;

import dominio.Familia;
import dominio.ICalculadorDePontuacao;

public class CalculadorDePontuacao implements ICalculadorDePontuacao {
	
	public int calcula(Familia familia) {
		return criterios().stream()
				.filter(criterio -> criterio.isValido(familia))
				.map(criterio -> criterio.pontos())
				.reduce(0, Integer::sum);
	}
	
	private List<ICriterioAvaliacao> criterios() {
		return Arrays.asList(
					new Criterio1ou2Dependentes(),
					new Criterio3ouMaisDependentes(),
					new CriterioAte900Reais(),
					new CriterioEntre901e1500Reais()
				);
	}
}
