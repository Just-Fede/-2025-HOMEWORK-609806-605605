package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando
{
	IOConsole io = new IOConsole();
	@Override
	public void esegui(Partita partita)
	{
		io.mostraMessaggio("Comando Inesistente");
	}
}
