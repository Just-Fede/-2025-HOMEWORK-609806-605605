package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoFine implements Comando
{
	private IO io;
	public ComandoFine(IO io) {
		this.io=io;
	}
	@Override
	public boolean esegui(Partita partita)
	{
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		return true;
	}
	@Override
	public String getNome()
	{
		return "fine";
	}
	@Override
	public String getParametro()
	{
		return null;
	}
}
