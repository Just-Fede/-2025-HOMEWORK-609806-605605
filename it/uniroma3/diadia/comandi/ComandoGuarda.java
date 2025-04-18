package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoGuarda implements Comando
{
	IOConsole io = new IOConsole();

	@Override
	public boolean esegui(Partita partita)
	{
		io.mostraMessaggio("\n[STANZA]\n"+partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU: "+partita.player.getCfu());

		io.mostraMessaggio("- - - - - - \n[INVENTARIO]");
		io.mostraMessaggio(partita.player.getInventario().toString());
		
		return true;
	}
}
