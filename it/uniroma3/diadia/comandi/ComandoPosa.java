package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoPosa implements Comando
{
	IOConsole io = new IOConsole();
	private String cosaPosare;

	public ComandoPosa(String parametro)
	{
		this.cosaPosare = parametro;
	}

	@Override
	public boolean esegui(Partita partita)
	{
		if (partita.player.getInventario().isEmpty()==true) 
		{
			io.mostraMessaggio("Il tuo inventario è vuoto");
			return false;
		}

		else if(partita.getStanzaCorrente().contaAttrezzi()==10)
			io.mostraMessaggio("La stanza è piena");

		if (cosaPosare==null) 
		{
			io.mostraMessaggio("Cosa vuoi posare?");
			return false;
		}

		else if(partita.player.getInventario().hasAttrezzo(cosaPosare)) 
		{
			if (partita.getStanzaCorrente().contaAttrezzi()<partita.getStanzaCorrente().getNumeroMassimoAttrezzi()) 
			{
				partita.getStanzaCorrente().addAttrezzo(partita.player.getInventario().getAttrezzo(cosaPosare));
				partita.player.getInventario().removeAttrezzo(cosaPosare);
				io.mostraMessaggio("Hai posato "+ cosaPosare);
				io.mostraMessaggio(partita.player.getInventario().toString());
				return true;
			}

		}
		else 
		{
			io.mostraMessaggio("Non possiedi questo oggetto");
			return false;
		}
		return false;
	}
	@Override
	public String getNome()
	{
		return "posa";
	}
	@Override
	public String getParametro()
	{
		return cosaPosare;
	}
}
