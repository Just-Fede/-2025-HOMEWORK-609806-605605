package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;


public class ComandoPrendi implements Comando
{
	private String cosaPrendere;
	private IO io;
	public ComandoPrendi(String parametro, IO io)
	{
		this.cosaPrendere = parametro;
		this.io=io;
	}

	@Override
	public boolean esegui(Partita partita)
	{
		if (cosaPrendere==null) 
		{
			io.mostraMessaggio("Cosa vuoi raccogliere?");
			return false;
		}

		else if (partita.getStanzaCorrente().hasAttrezzo(cosaPrendere)) 
		{
			if(partita.player.aggiungiAllaBorsa(partita.getStanzaCorrente().getAttrezzo(cosaPrendere)))
			{
				io.mostraMessaggio("Oggetto aggiunto all'inventario e ... ");
			}

			if(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(cosaPrendere))) 
			{
				io.mostraMessaggio("Ora non è più per terra!\n" + partita.player.getInventario().toString());
				partita.getFrame().mostraStanza(partita.getStanzaCorrente());
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
			return false;
		}
	}
	@Override
	public String getNome()
	{
		return "prendi";
	}
	@Override
	public String getParametro()
	{
		return cosaPrendere;
	}
}
