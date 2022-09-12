package dominio;

import java.util.List;

public class Familia {
	
	private Pessoa pretendente;
	private Pessoa conjuge;
	private List<Pessoa> dependentes;
	
	public Familia(Pessoa pretendente, Pessoa conjuge, List<Pessoa> dependentes) {
		this.pretendente = pretendente;
		this.conjuge = conjuge;
		this.dependentes = dependentes;
	}
	
	public Pessoa getPretendente() {
		return this.pretendente;
	}
	
	public Pessoa getConjuge() {
		return this.conjuge;
	}
	
	public List<Pessoa> getDependentes() {
		return this.dependentes;
	}
	
	public double rendaFamiliar() {
		return rendaDoPretendente() + rendaDoConjuge() + rendaDosDependentes();
	}
	
	public Double rendaDoPretendente() {
		return pretendente != null ? pretendente.getRenda() : 0d;
	}
	
	public Double rendaDoConjuge() {
		return conjuge != null ? conjuge.getRenda() : 0d;
	}
	
	public double rendaDosDependentes() {
		double rendaAcumulada = 0;
		for(Pessoa dependente : dependentes) {
			rendaAcumulada += dependente.getRenda();
		}
		
		return rendaAcumulada;
	}
	
	public int numeroDeDependentesMenores() {
		int quantidadeDependentesMenores = 0;
		for(Pessoa dependente : dependentes) {
			if(dependente.isMenorDeIdade())
				quantidadeDependentesMenores++;
		}
		
		return quantidadeDependentesMenores;
	}
}
