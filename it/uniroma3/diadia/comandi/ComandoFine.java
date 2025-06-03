package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoFine extends AbstractComando
{
	private IO io;
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	@Override
	public void setParametro(String parametro) {
		// Ignorato perché non serve
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

}
