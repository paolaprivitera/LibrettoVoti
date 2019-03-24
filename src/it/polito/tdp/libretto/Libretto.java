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

	
	
	
}
