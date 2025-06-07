package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;

public class ComandoNonValido extends AbstractComando
{
	private IO io;	

	@Override
	public void setParametro(String parametro) {
		// Ignorato perché non serve
	}
	@Override
	public boolean esegui(Partita partita)
	{
		io.mostraMessaggio("Comando Inesistente");
		return true;
	}
	@Override
	public String getNome()
	{
		return "nonValido";
	}

	@Override
	public void setIO(IO io) {
		this.io=io;
	}
}
