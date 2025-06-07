package it.uniroma3.diadia.comandi;

import Personaggio.AbstractPersonaggio;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoInteragisci extends AbstractComando{
	
	private static final String MESSAGGIO_CON_CHI="Con chi dovrei interagire?...";
	private String messaggio;
	private IO io;
	
	@Override 
	public boolean esegui (Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio=partita.getStanzaCorrente().getPersonaggio();
		if(personaggio!=null) {
			this.messaggio=personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);
		}
		else 
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
		return true;
	}
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public void setParametro(String parametro) {}
	@Override
	public void setIO(IO io) {
		this.io=io;		
	}

}
