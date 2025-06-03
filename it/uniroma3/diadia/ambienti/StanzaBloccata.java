package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza
{
	String oggettoNecessario;
	String direzioneBloccata;


	public StanzaBloccata(String nome,String key, String direzioneBloccata)
	{
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.oggettoNecessario=key;
	}

	@Override
	public Stanza getStanzaAdiacente(String dir) 
	{	
		if ((dir.equals(direzioneBloccata))) {
			if (this.hasAttrezzo(oggettoNecessario)) 
			{
				return super.getStanzaAdiacente(dir);
			}
		}
		else {
			return super.getStanzaAdiacente(dir);
		}
			return this;
	}

	@Override
	public String getDescrizione() {
		String descrizioneBase=super.getDescrizione();
		if (this.hasAttrezzo(oggettoNecessario))
			return descrizioneBase+"\nLa stanza è bloccata, lato "+direzioneBloccata+", ma grazie a "+oggettoNecessario+" puoi passare";
		else 
			return descrizioneBase+"\nLa stanza è bloccata, lato "+direzioneBloccata+", per passare ti serve "+oggettoNecessario;
	}

}
