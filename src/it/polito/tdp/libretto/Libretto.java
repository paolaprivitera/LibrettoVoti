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
	
	
}
