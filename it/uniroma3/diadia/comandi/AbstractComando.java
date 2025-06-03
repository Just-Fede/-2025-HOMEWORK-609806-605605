package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class AbstractComando implements Comando{

	@Override
	public boolean esegui(Partita partita) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		
	}

}
