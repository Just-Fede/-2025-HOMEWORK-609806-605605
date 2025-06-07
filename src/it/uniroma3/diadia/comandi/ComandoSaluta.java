package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	@Override
	public boolean esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
		return true;
	}
	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}

}
