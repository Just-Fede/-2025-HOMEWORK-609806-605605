package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public interface Comando 
{
	public boolean esegui(Partita partita);
	public String getNome();
	public String getParametro();
	public void setParametro(String parametro);
	public void setIO(IO io);
}
