package it.uniorma3.comandi;
import it.uniroma3.diadia.*;

public class Posa 
{

	public void posa(String nome, Partita partita, IOConsole io) 
	{
		if (partita.player.getInventario().isEmpty()==true) 
		{
			io.mostraMessaggio("Il tuo inventario è vuoto");
			return;
		}
		else if(partita.getStanzaCorrente().contaAttrezzi()==10)
			io.mostraMessaggio("La stanza è piena");
		if (nome==null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		else if(partita.player.getInventario().hasAttrezzo(nome)) 
		{
			if (partita.getStanzaCorrente().contaAttrezzi()<partita.getStanzaCorrente().getNumeroMassimoAttrezzi()) 
			{
				partita.getStanzaCorrente().addAttrezzo(partita.player.getInventario().getAttrezzo(nome));
				partita.player.getInventario().removeAttrezzo(nome);
				io.mostraMessaggio("Hai posato "+nome);
			}

		}
		else 
			io.mostraMessaggio("Non possiedi questo oggetto");

	}
}
