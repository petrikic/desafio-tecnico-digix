package app;

import dominio.Familia;

public class Criterio3ouMaisDependentes implements ICriterioAvaliacao{

	@Override
	public boolean isValido(Familia familia) {
		return familia.numeroDeDependentesMenores() >= 3;
	}

	@Override
	public int pontos() {
		return 3;
	}

}
