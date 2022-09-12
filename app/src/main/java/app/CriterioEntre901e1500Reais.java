package app;

import dominio.Familia;

public class CriterioEntre901e1500Reais implements ICriterioAvaliacao{

	@Override
	public boolean isValido(Familia familia) {
		return familia.rendaFamiliar() > 900 && familia.rendaFamiliar() <= 1500;
	}

	@Override
	public int pontos() {
		return 3;
	}

}
