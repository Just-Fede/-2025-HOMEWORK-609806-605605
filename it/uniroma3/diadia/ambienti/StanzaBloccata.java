package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.*;

public class StanzaBloccata extends Stanza
{
	String oggettoNecessario="piedediporco";
	String direzioneBloccata;
	
	private IO io;	
	
	public StanzaBloccata(String nome, String direzioneBloccata,IO io)
	{
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.io=io;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) 
	{	
		if ( this.hasAttrezzo(oggettoNecessario)) 
		{
			io.mostraMessaggio("Utilizzi il ");
			io.mostraMessaggio(oggettoNecessario);
			
			return super.getStanzaAdiacente(dir);
		}
		
		else 
		{	
			io.mostraMessaggio("L'uscita è barricata...");
			return this;
		}
	}
	
}
