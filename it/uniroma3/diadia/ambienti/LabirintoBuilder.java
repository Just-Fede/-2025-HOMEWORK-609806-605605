package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder{
	private Labirinto labirinto;
	private Stanza ultimaStanzaAggiunta;
	private Map<String, Stanza> stanze;

	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
		this.stanze=new HashMap<>();
	}

	public LabirintoBuilder addStanzaIniziale(String nome) {
		Stanza stanzatemp=new Stanza(nome);
		labirinto.setStanzaIniziale(stanzatemp);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nome) {
		Stanza stanzatemp=new Stanza(nome);
		labirinto.setStanzaVincente(stanzatemp);
		stanze.put(nome,stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		if (ultimaStanzaAggiunta!=null) {
			Attrezzo attrezzo=new Attrezzo(nome, peso);
			ultimaStanzaAggiunta.addAttrezzo(attrezzo);
		}
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		Stanza stanzatemp=new Stanza(nome);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanza1nome, String stanza2nome, String direzione) {
		Stanza stanza1=stanze.get(stanza1nome);
		Stanza stanza2=stanze.get(stanza2nome);
		stanza1.impostaStanzaAdiacente(direzione, stanza2);
		if (direzione.equals("nord")) 
			stanza2.impostaStanzaAdiacente("sud", stanza1);
		else if(direzione.equals("est"))
			stanza2.impostaStanzaAdiacente("ovest", stanza1);
		else if (direzione.equals("sud"))
			stanza2.impostaStanzaAdiacente("nord", stanza1);
		else 
			stanza2.impostaStanzaAdiacente("est", stanza1);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String key) {
		Stanza stanzatemp=new StanzaBloccata(nome,key,direzione);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome,  String key) {
		Stanza stanzatemp=new StanzaBuia(nome,key);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanzatemp=new StanzaMagica(nome);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome, int limite) {
		Stanza stanzatemp=new StanzaMagica(nome,limite);
		stanze.put(nome, stanzatemp);
		this.ultimaStanzaAggiunta=stanzatemp;
		return this;
	}

	public Stanza getStanzaVincente() {
		return this.labirinto.getStanzaVincente();
	}


	public Stanza getStanzaIniziale() {
		return this.labirinto.getStanzaIniziale();
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public Map<String,Stanza> getListaStanze(){
		//	List<Stanza> stanzetemp=new ArrayList<>(stanze.values());
		return stanze;
	}

	public int getSize() {
		return stanze.size();
	}
}
