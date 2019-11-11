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
	
	//Necessario override del metodo equals in Prodotto.

	public static List<Prodotto> prodottiNonDisponibili(Ordine ord, List<Prodotto> dbProdotti) {
		HashMap<Prodotto , Integer > map = ord.getOrdini();
		List<Prodotto> notAvailable = new LinkedList<Prodotto>();

		for(Prodotto p: map.keySet()) {
			//Controllo la molteplicità nel db
			int counter = 0;
			ListIterator<Prodotto> it = dbProdotti.listIterator(dbProdotti.size());
			while(it.hasNext()) {
				Prodotto iesimo = it.next();
				if(iesimo.confronto(p)) {
					counter++;
				}
			}
			//Confronto la molteplicità disponibile con quella richiesta
			if(counter < map.get(p)) {
				//Se non è disponibile lo appendo
				notAvailable.add(p);
			}
		}
		return notAvailable;
	}

}
