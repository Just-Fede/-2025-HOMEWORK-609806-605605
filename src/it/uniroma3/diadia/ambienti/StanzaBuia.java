package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza
{
	
	String oggettoNecessario;
	public StanzaBuia(String nome,String key) 
	{
		super(nome);
		oggettoNecessario=key;
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
