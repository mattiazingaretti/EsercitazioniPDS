package esercizio1;

import java.util.*;

public class Ordine {
	private static int numeroProgressivo = 0;
	private Cliente cliente;
	private List<Prodotto> listaProdotti = new LinkedList<Prodotto>();
	private HashMap<Prodotto, Integer> ordini = new HashMap<Prodotto, Integer>();
	
	public Ordine(int n, Cliente cliente) {
		this.setCliente(cliente);
		this.setNumeroProgressivo(n);
		numeroProgressivo++;
	}

	public void inserisciProdotto(Prodotto p, int q) {
		if (this.listaProdotti.contains(p) == false) {
				this.listaProdotti.add(p);
				this.ordini.put(p, q);
		}else {
			this.ordini.put( p , this.ordini.get(p) + q);
		}
	}
	
	@Override
	public String toString() {
		return "ha ordinato i prodotti : "+this.ordini;
	}
	
	public HashMap<Prodotto, Integer> getOrdini() {
		return ordini;
	}

	public void setOrdini(HashMap<Prodotto, Integer> ordini) {
		this.ordini = ordini;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public int getNumeroProgressivo() {
		return numeroProgressivo;
	}

	public void setNumeroProgressivo(int numeroProgressivo) {
		this.numeroProgressivo = numeroProgressivo;
	}

}
