package app;

import dominio.Familia;

public class Criterio1ou2Dependentes implements ICriterioAvaliacao{

	@Override
	public boolean isValido(Familia familia) {
		return familia.numeroDeDependentesMenores() == 1 || familia.numeroDeDependentesMenores() == 2;
	}

	@Override
	public int pontos() {
		return 2;
	}

}
