package dominio;

import java.util.List;

public class Familia implements Comparable<Familia>{
	
	private Pessoa pretendente;
	private Pessoa conjuge;
	private List<Pessoa> dependentes;
	private int pontuacao;
	
	public Familia(Pessoa pretendente, Pessoa conjuge, List<Pessoa> dependentes) {
		this.pretendente = pretendente;
		this.conjuge = conjuge;
		this.dependentes = dependentes;
		this.pontuacao = 0;
	}
	
	public Familia(Pessoa pretendente, List<Pessoa> dependentes) {
		this(pretendente, null, dependentes);
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
	
	public int getPontuacao() {
		return this.pontuacao;
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
		return dependentes.stream()
				.map(dependente -> dependente.getRenda())
				.reduce(0d, Double::sum);
	}
	
	public int numeroDeDependentesMenores() {
		return dependentes.stream()
				.filter(dependente -> dependente.isMenorDeIdade())
				.toList()
				.size();
	}
	
	public void calculaPontuacao(ICalculadorDePontuacao calculador) {
		this.pontuacao = calculador.calcula(this);
	}

	@Override
	public int compareTo(Familia outraFamilia) {
		return Integer.compare(getPontuacao(), outraFamilia.getPontuacao());
	}
}
