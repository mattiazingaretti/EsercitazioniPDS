package esercizio1;

import java.util.*;

public class Operazioni {

	public static double totaleOrdine(Ordine ord) {
		HashMap<Prodotto,Integer> ordini = ord.getOrdini();
		double ris = 0;
		for( Prodotto p : ordini.keySet()) {
			ris += p.getPrezzoVendita()*ordini.get(p);
		}
		return ris;
		
	}

	public static List<Prodotto> prodottiNonDisponibili(Ordine ord, List<Prodotto> dbProdotti) {
		return null;
	}

}
