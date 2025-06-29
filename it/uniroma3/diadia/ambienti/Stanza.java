package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.Personaggio.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;

	private List<Attrezzo> attrezzi;
	//	private int numeroAttrezzi;
	private Map<Direzione, Stanza> direzioni2stanze;
	private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	private AbstractPersonaggio personaggio;


	private String[] direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * @param nome il nome della stanza
	 */
	public Stanza(String nome) 
	{
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		//		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new ArrayList<Attrezzo>();
		this.direzioni2stanze = new HashMap<>();
	}

	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean aggiornato = false;
		//		for(int i=0; i<this.direzioni.size(); i++)
		//			if (direzione.equals(this.direzioni.get(i))) {
		//				this.stanzeAdiacenti.add(stanza);
		//				aggiornato = true;
		//			}
		if (direzioni2stanze.containsKey(direzione)) {
			this.direzioni2stanze.put(direzione,stanza);
			aggiornato = true;
		}
		if (!aggiornato)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.direzioni2stanze.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}
	
	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.direzioni2stanze = stanzeAdiacenti;
	}

	public Map<Direzione,Stanza> getMapStanzeAdiacenti(){
		return direzioni2stanze;
	}
	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (this.direzioni2stanze.containsKey(direzione))
			stanza = this.direzioni2stanze.get(direzione);
		return stanza;
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public int getNumeroMassimoAttrezzi() {
		return NUMERO_MASSIMO_ATTREZZI;
	}
	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) 
	{
		if (this.contaAttrezzi() < NUMERO_MASSIMO_ATTREZZI) 
		{
			attrezzi.add(attrezzo);
			return true;
		}
		else return false;
	}

	public int contaAttrezzi() {
		/*		int count=0;
		for (int i=0;i<attrezzi.length;i++) {
			if (attrezzi[i]!=null)
				count++;
		}
		return count;*/
		return attrezzi.size();
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if(attrezzo != null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
		}
		return trovato;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo!=null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzoDaEliminare) {
		if (attrezzi.contains(attrezzoDaEliminare)) {
			attrezzi.remove(attrezzoDaEliminare);
			return true;
		}		
		return false;	
	}


	public List<String> getDirezioni() {
		List<String> direzioni = new ArrayList<>();
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni.add(this.direzioni[i]);
		return direzioni;
	}
	
	public void setPersonaggio(AbstractPersonaggio ap) {
		this.personaggio = ap;
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : direzioni2stanze.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

}