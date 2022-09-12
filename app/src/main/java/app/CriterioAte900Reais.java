package app;

import dominio.Familia;

public class CriterioAte900Reais implements ICriterioAvaliacao {

	@Override
	public boolean isValido(Familia familia) {
		return familia.rendaFamiliar() <= 900;
	}

	@Override
	public int pontos() {
		return 5;
	}

}
