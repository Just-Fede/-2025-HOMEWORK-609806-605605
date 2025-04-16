package it.uniorma3.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;

public class Vai 
{
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */

	public void vaiDIrezione(String direzione, Partita partita, IOConsole io) 
	{
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");

		Stanza prossimaStanza = null;
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);

		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.player.getCfu();
			partita.player.setCfu(cfu-1);
			partita.guarda.guarda(partita, io);
			}
		
		
		if (partita.isFinita() == true) 
			partita.setFinita();
		
	}

}
