package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoFine implements Comando
{
	IOConsole io = new IOConsole();

	@Override
	public boolean esegui(Partita partita)
	{
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		return true;
	}
}
