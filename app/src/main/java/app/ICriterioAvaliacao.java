package app;

import dominio.Familia;

public interface ICriterioAvaliacao {
	
	public boolean isValido(Familia familia);
	
	public int pontos();
}
