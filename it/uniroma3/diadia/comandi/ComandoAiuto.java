package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoAiuto implements Comando
{
	IOConsole io = new IOConsole();
	
	@Override
	public boolean esegui(Partita partita)
	{
		final String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
		
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
		return true;
	}
	
	@Override
	public String getNome()
	{
		return "aiuto";
	}
	@Override
	public String getParametro()
	{
		return null;
	}
	
}
