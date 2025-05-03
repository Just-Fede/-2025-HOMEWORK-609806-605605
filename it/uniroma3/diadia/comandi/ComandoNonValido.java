package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando
{
	private IO io;	
	public ComandoNonValido(IO io) {
		this.io=io;
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
	public String getParametro()
	{
		return null;
	}
}
