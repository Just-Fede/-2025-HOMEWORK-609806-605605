package it.uniorma3.comandi;
import it.uniroma3.diadia.*;

public class Guarda 
{
	public void guarda(Partita partita, IOConsole io)
	{
		io.mostraMessaggio("\n[STANZA]\n"+partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU: "+partita.player.getCfu());
		
		io.mostraMessaggio("- - - - - - \n[INVENTARIO]");
		io.mostraMessaggio(partita.player.getInventario().toString());
	}
}
