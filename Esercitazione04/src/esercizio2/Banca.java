package esercizio2;

public class Banca {
	private Conto[] listaConti;
	private String nome;
	private String indirizzo;
	
	
	public Banca(Conto[] listaConti , String nome, String indirizzo) {
		this.listaConti = listaConti;
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

	public Conto[] getListaConti() {
		return listaConti;
	}

	public void setListaConti(Conto[] listaConti) {
		this.listaConti = listaConti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
}
