package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IO;

public class ComandoVai extends AbstractComando
{
	private IO io;
	private String direzione;



	@Override
	public boolean esegui(Partita partita)
	{
		Stanza prossimaStanza = null;

		if(direzione==null)
		{
			io.mostraMessaggio("Dove vuoi andare ?");
			io.mostraMessaggio("\n[STANZA]\n"+partita.getStanzaCorrente().getDescrizione());
			return false;
		}

		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);

		if (prossimaStanza == null) 
		{
			io.mostraMessaggio("Direzione inesistente");
			return false;
		}

		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());

		int cfu = partita.player.getCfu();
		partita.player.setCfu(cfu-1);

		io.mostraMessaggio("\n[STANZA]\n"+partita.getStanzaCorrente().getDescrizione());
		return true;
	}
	@Override
	public String getNome()
	{
		return "vai";
	}
	@Override
	public String getParametro()
	{
		return direzione;
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
