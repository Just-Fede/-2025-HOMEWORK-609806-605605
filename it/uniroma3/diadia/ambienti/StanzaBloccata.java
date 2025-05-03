package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	String oggettoNecessario="piede di porco";
	String direzioneBloccata;
	public StanzaBloccata(String nome, String direzioneBloccata){
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
	}
	public Stanza getStanzaAdiacente(String dir) {
		if ( this.hasAttrezzo(oggettoNecessario)) {
			return super.getStanzaAdiacente(dir);
		}
		else {
			return this;
		}
	}
}
