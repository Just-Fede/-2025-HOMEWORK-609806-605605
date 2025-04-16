package it.uniorma3.comandi;
import it.uniroma3.diadia.*;

public class Prendi 
{
	/**
	 * Cerca di raccogliere un attrezzo presente nella stanza corrente.
	 * se l'attrezzo esiste e c'è spazio nella borsa, viene rimosso dalla stanza
	 * e aggiunto all'inventario del giocatore.
	 *
	 * @param nome: il nome dell'attrezzo da raccogliere 
	 */

	public boolean prendi(String nome, Partita partita, IOConsole io) 
	{
		if (nome==null) 
		{
			io.mostraMessaggio("Cosa vuoi raccogliere?");
			return false;
		}
		else if (partita.getStanzaCorrente().hasAttrezzo(nome)) 
		{
			if(partita.player.aggiungiAllaBorsa(partita.getStanzaCorrente().getAttrezzo(nome)))
				io.mostraMessaggio("Oggetto aggiunto all'inventario e ... ");

			if(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nome))) 
			{
				io.mostraMessaggio("Ora non è più per terra!");
				partita.guarda.guarda(partita, io);
				return true;
			}

			else 
			{
				io.mostraMessaggio("Oggetto non trovato");
				return false;
			}
		}

		else 
		{
			io.mostraMessaggio("Questo attrezzo non è quì presente...");
			return true;
		}
	}
}
