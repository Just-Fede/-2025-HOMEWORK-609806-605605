package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Personaggio.Cane;
import it.uniroma3.diadia.Personaggio.Mago;
import it.uniroma3.diadia.Personaggio.Strega;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe gestisce la creazione del labirinto
 *
 * @author  Arturo Gattola
 * @see Stanza
 * @version base
 */





public class Labirinto 
{

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	//	public void creaStanze() {
	//
	//		/* crea gli attrezzi */
	//		Attrezzo lanterna = new Attrezzo("lanterna",3);
	//		Attrezzo osso = new Attrezzo("osso",1);
	//
	//		/* crea stanze del labirinto */
	//		StanzaMagica atrio = new StanzaMagica("Atrio",1);
	//		Stanza aulaN11 = new Stanza("Aula N11");
	//		Stanza aulaN10 = new Stanza("Aula N10");
	//		Stanza laboratorio = new Stanza("Laboratorio Campus");
	//		Stanza biblioteca = new Stanza("Biblioteca");
	//
	//		/* collega le stanze */
	//		atrio.impostaStanzaAdiacente("nord", biblioteca);
	//		atrio.impostaStanzaAdiacente("est", aulaN11);
	//		atrio.impostaStanzaAdiacente("sud", aulaN10);
	//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
	//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
	//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
	//		aulaN10.impostaStanzaAdiacente("nord", atrio);
	//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
	//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
	//		laboratorio.impostaStanzaAdiacente("est", atrio);
	//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
	//		biblioteca.impostaStanzaAdiacente("sud", atrio);
	//
	//		/* pone gli attrezzi nelle stanze */
	//		aulaN10.addAttrezzo(lanterna);
	//		atrio.addAttrezzo(osso);
	//
	//		// il gioco comincia nell'atrio
	//		stanzaIniziale = atrio;  
	//		stanzaVincente = biblioteca;
	//	}
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =	new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}

	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}


	public void setStanzaVincente(Stanza stanza) {
		this.stanzaVincente=stanza;
	}

	public void setStanzaIniziale(Stanza stanza) {
		this.stanzaIniziale=stanza;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}


	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}





	//static nested class LabirintoBuilder
	public static class LabirintoBuilder {
		
		public static  class Pippo {
			//another useless nested class
		}
		
		private Labirinto labirinto;
		private Stanza ultimaStanzaAggiunta;
		private Map<String, Stanza> nome2stanza;

		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto = new Labirinto(labirinto);
			this.nome2stanza = new HashMap<>();
		}

		public Map<String, Stanza> getNome2stanza() {
			return nome2stanza;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza i = new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(i);
			this.UltimaStanzaAggiuntaEAggiorna(i);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s = new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}

		public LabirintoBuilder addStanza(String stanza) {
			Stanza s = new Stanza(stanza);
			this.UltimaStanzaAggiuntaEAggiorna(s);
			return this;
		}	

		//		public LabirintoBuilder addPersonaggio(String nome, String presentazione) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//			AbstractPersonaggio p = null;
		//
		//			StringBuilder nomeClasse
		//			= new StringBuilder("it.uniroma3.diadia.personaggi.");
		//			nomeClasse.append( nome.substring(1) ) ;
		//			p = (AbstractPersonaggio)Class.forName(nomeClasse.toString()).newInstance();
		//			p.setNome(nome);
		//			p.setPresentazione(presentazione);
		//			if(this.ultimaStanzaAggiunta==null)
		//				return this;
		//			this.ultimaStanzaAggiunta.setPersonaggio(p);
		//			return this;
		//		}

		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione) {
			Cane c = new Cane(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
			Attrezzo a = new Attrezzo(attrezzo, peso);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
			Stanza c = this.nome2stanza.get(stanzaCorrente);
			Stanza a = this.nome2stanza.get(stanzaAdiecente);
			c.impostaStanzaAdiacente(direzione, a);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, Direzione.valueOf(direzioneBloccata), attrezzoSbloccante);
			this.UltimaStanzaAggiuntaEAggiorna(stanza);
			return this;
		}

		public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}
		
	
	}
}
