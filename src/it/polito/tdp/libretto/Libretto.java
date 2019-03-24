package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>(); 
	}

	public void add(int voto, String corso, LocalDate data) {

	}
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
	
	public void add(Voto v) {
		voti.add(v);
	}

	/*
	public void StampaVoti(int voto) {
		
	}
	
	public String StampaVoti2(int voto) {
		
	}*/
	
	// Mi conviene utilizzare la terza versione List<Voto>
	// perche' avro' un'interfaccia grafica
	
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
	 * @param punti punteggio da ricercare
	 * @return lista di [{@link Voto} aventi quel punteggio (eventualmente vuota)
	 */
	public List<Voto> cercaVoti(int punti) { 
		
		List<Voto> result = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti()==punti) {
				result.add(v);
				// in questo modo ho aggiunto alla lista
				// un oggetto che gia' c'era
			}
		}
		
		return result;
	}
	
	/**
	 * Ricerca un {@link Voto} relativo al corso di cui e' specificato il nome
	 *
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} corrispondente, oppure {@code null} se non esistente
	 */
	public Voto cercaEsame(String nomeEsame) {
		for(Voto v : this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * Dato un {@link Voto}, determina se esiste gia' un voto con uguale
	 * corso ed uguale punteggio.
	 * 
	 * @param v 
	 * @return {@code true}, se ha trovato un corso e punteggio uguali,
	 * 		   {@code false}, se non ha trovto il corso, oppure l'ha trovato
	 * 		   con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {
		
		Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato==null) {
			return false;
		}
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		}
		else {
			return false;
		}
	}
}
