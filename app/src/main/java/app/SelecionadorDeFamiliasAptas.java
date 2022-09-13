package app;

import java.util.List;

import dominio.Familia;

public class SelecionadorDeFamiliasAptas {
	
	public List<Familia> seleciona(List<Familia> familiasAAvaliar) {
		
		CalculadorDePontuacao calculador = new CalculadorDePontuacao();
		
		return familiasAAvaliar.stream()
				.map(familia -> familia.calculaPontuacao(calculador))
				.filter(familia -> isFamiliaApta(familia))
				.sorted()
				.toList();
	}
	
	public boolean isFamiliaApta(Familia familia) {
		return familia.getPontuacao() > 0;
	}

}
