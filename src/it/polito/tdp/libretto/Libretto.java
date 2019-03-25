package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>(); 
	}

	/*public void add(int voto, String corso, LocalDate data) {

	}*/

	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 * @return {@code true} nel caso normale, {@code false} se non e'
	 * 		   riuscito ad aggiungere il voto.
	 */

	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)) {
			voti.add(v);
			return true;
		}
		else {
			return false;
		}
	}

	// Abbiamo potenziato il metodo add in modo da rifiutare
	// l'inserimento di dati errati

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
		// Esiste gia' una funzione che ha lo stesso compito
		/*for(Voto v : this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}*/

		// Esiste sia l'indexOf che il lastIndexOf a seconda che si voglia cercare
		// dall'inizio oppure dalla fine

		// indexOf() vuole un oggetto della lista quindi della classe voto
		// ma io non ho nessuna informazione di questo oggetto se non il nomeEsame
		// --------> quindi gli fornisco un oggetto costruito con lo stesso nomeEsame
		// ma valori casuali per gli altri attributi
		// perche' indexOf richiama il metodo equals che confrontera' soltanto il nomeEsame
		// quindi gli altri campi non verranno mai consultati

		Voto voto = new Voto(0, nomeEsame, null);

		int posizione = this.voti.indexOf(voto);
		if(posizione == -1)
			return null;
		else
			return this.voti.get(posizione);
	}

	/**
	 * Dato un {@link Voto}, determina se esiste gia' un voto con uguale
	 * corso ed uguale punteggio.
	 * 
	 * @param v 
	 * @return {@code true}, se ha trovato un corso e punteggio uguali,
	 * 		   {@code false}, se non ha trovato il corso, oppure l'ha trovato
	 * 		   con voto diverso
	 */
	public boolean esisteGiaVoto(Voto v) {

		int posizione = this.voti.indexOf(v);
		if(posizione == -1)
			return false;
		else
			return (v.getPunti() == this.voti.get(posizione).getPunti());

		/*else {
			if(v.getPunti() == this.voti.get(posizione).getPunti())
				return true;
			else 
				return false;
		}*/


		/*Voto trovato = this.cercaEsame(v.getCorso());
		if(trovato==null) {
			return false;
		}
		if(trovato.getPunti()==v.getPunti()) {
			return true;
		}
		else {
			return false;
		}*/
	}

	/**
	 * Mi dice se il {@link Voto} {@code v} e' in conflitto con uno dei voti esistenti.
	 * Se il voto non esiste, non c'e' conflitto. Se esiste ed ha punteggio diverso,
	 * c'e' conflitto.
	 * 
	 * @param v
	 * @return {@code true} se il voto esiste ed ha un punteggio diverso,
	 * 		   {@code false} se il voto non esiste, oppure esiste ma ha lo stesso
	 * 		   punteggio.
	 */
	public boolean votoConflitto(Voto v) {
		int posizione = this.voti.indexOf(v);
		if(posizione == -1)
			return false;
		else
			return (v.getPunti() != this.voti.get(posizione).getPunti());
	}

	public String toString() {
		return this.voti.toString();
	}

	public Libretto librettoMigliorato() {
		Libretto nuovo = new Libretto();

		for(Voto v : this.voti) {

			// --------> nuovo.add(v);

			// In questo modo non funziona perche' abbiamo copiato
			// i riferimenti degli oggetti precedenti
			// quindi in questo modo stamperebbe il libretto vecchio
			// uguale a quello nuovo, entrambi incrementati di 1.
			// Questo ha senso se l'oggeto voto e' una quantita' immutabile.

			// nuovo.add(new Voto(v.getPunti(), v.getCorso(), v.getData()));
			nuovo.add(v.clone()); // Factory method -> metodo che costruisce oggetti
		}

		for(Voto v : nuovo.voti) { 

			// nuovo.voti -> ho preso una variabile privata
			// di un oggetto che non sono io, cioe' this
			// Ho creato un nuovo oggetto ma, poiche' questo oggetto
			// e' della mia stessa classe ho accesso
			// anche ai suoi campi privati

			int punti = v.getPunti();
			if(punti<24)
				punti++;
			else if(punti<=28)
				punti = punti + 2;

			v.setPunti(punti);
		}

		return nuovo;
	}

	public void cancellaVotiScarsi() {

		/*for(Voto v : this.voti) {
			if(v.getPunti()<24) {
				this.voti.remove(v);
			}
		}
		// Sto cercando di modificare il contenuto di una lista
		// mentre la sto iterando -> java.util.ConcurrentModificationException
		 */
		
		List<Voto> cancellare = new ArrayList<Voto>();
		
		for(Voto v : this.voti) {
			if(v.getPunti()<24) {
				cancellare.add(v);
			}
		}
		
		// Soltanto dopo che sono fuori dal ciclo for, rimuovo tutti
		// gli elementi della lista cancellare
		
		this.voti.removeAll(cancellare);
	}


}
