package it.uniorma3.comandi;
import it.uniroma3.diadia.*;


public class Aiuto
{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa","guarda"};
	/**
	 * Stampa informazioni di aiuto.
	 */
	
	public void ElencoComandi(IOConsole io) 
	{
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}
}
