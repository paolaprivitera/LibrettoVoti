package it.polito.tdp.libretto;
import java.time.LocalDate; // java.time permette di lavorare con le date

public class Voto {
	
	private int punti;
	private String corso;
	private LocalDate data; // non si usa una stringa per definire una data!!
	
	// Tutte le funzionalita' di controllo versione su eclipse
	// sono sotto la voce Team (tasto dx sul nome del progetto)
	// CREARE UN REPOSITORY
	// Team -> Share Project (per creare un nuovo repository)
	// spuntare Use or create repository in parent folder of project
	// cliccare Create Repository (e si mette la spunta nel nome del progetto)
	
	// Si puo' visualizzare una finestra Git Repository dove ci sono tutti
	// i repository salvati sul nostro pc
	// Window -> show view -> other -> Git Repository
	
	// COMMIT (salvo localmente) oppure COMMIT AND PUSH (salvo anche su GitHub)
	// tast dx sul nome del progetto -> Team -> Share Project -> Commit (che apre Git Staging)
	// portare i file che si vogliono committare da unstaged changes -> staged changes
	// oppure premere ++ per prenderli tutti
	// a dx si inserisce il Commit Message
	// infine si clicca commit
	
	// Team -> Show in History
	// compare un tag con la storia del progetto
	// dove ogni riga indica un commit
	
	// La versione che presenta l'etichetta HEAD e' la piu' recente di tutte
	// L'etichetta master indica qual è il ramo di sviluppo
	
	// Per tornare alla versione vecchia si va nella History,
	// si clicca sulla riga relativa alla versione in cui si vuole andare
	// tasto dx -> check out
	
	// Si puo' tornare alla versione nuova
	// Team -> Switch to -> master
	
	// Per pushare il file su GitHub
	// Team -> Push Branch 'master' 
	// Nell'URl si mette l'indirizzo copiato da GitHub
	// Bisogna inserire le credenziali di GitHub
	
	// Team -> Commit -> Commit and Push (lo salva direttamente su GitHub)
	
	// CLONAZIONE
	// Operazione di scaricamento iniziale da un repository remoto
	// per creare un repository locale
	
	// FORK
	// Si utilizza per clonare il progetto sul proprio profilo
	
	public Voto(int voto, String corso, LocalDate data) {
		this.punti = voto;
		this.corso = corso;
		this.data = data;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int voto) {
		this.punti = voto;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	// Per visualizzare nel debug il voto in un formato leggibile
	// e non visualizzare il riferimento
	
	@Override
	public String toString() {
		return String.format("Voto [punti=%s, corso=%s, data=%s]", punti, corso, data);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
	public Voto clone() {
		return new Voto(this.punti, this.corso, this.data);
	}
	
	
}
