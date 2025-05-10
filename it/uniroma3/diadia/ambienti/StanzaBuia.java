package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza
{
	
	String oggettoNecessario="lanterna";
	public StanzaBuia(String nome) 
	{
		super(nome);
	}
	
	@Override
	public String getDescrizione() 
	{
		if (this.hasAttrezzo(oggettoNecessario))
			return super.getDescrizione();
		else
			return ("qui c'è buio pesto");
	}
}
