package test.it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	@Test
	public void testSenzaPiedeDiPorco() {
		Stanza shangai=new Stanza("shangai");
		StanzaBloccata bloccata1= new StanzaBloccata("barricata","nord");
		bloccata1.impostaStanzaAdiacente("nord", shangai);
		assertEquals(bloccata1, bloccata1.getStanzaAdiacente("nord"));
		StanzaBloccata bloccata2= new StanzaBloccata("barricata","est");
		bloccata2.impostaStanzaAdiacente("est", shangai);
		assertEquals(bloccata2, bloccata2.getStanzaAdiacente("est"));
		StanzaBloccata bloccata3= new StanzaBloccata("barricata","sud");
		bloccata3.impostaStanzaAdiacente("sud", shangai);
		assertEquals(bloccata3, bloccata3.getStanzaAdiacente("sud"));
		StanzaBloccata bloccata4= new StanzaBloccata("barricata","ovest");
		bloccata4.impostaStanzaAdiacente("ovest", shangai);
		assertEquals(bloccata4, bloccata4.getStanzaAdiacente("ovest"));
	}

	public void testConPiedeDiPorco() {
		Stanza shangai=new Stanza("shangai");
		Attrezzo piedeDiPorco=new Attrezzo("piede di porco",1);
		StanzaBloccata bloccata1= new StanzaBloccata("barricata","nord");
		bloccata1.addAttrezzo(piedeDiPorco);
		bloccata1.impostaStanzaAdiacente("nord", shangai);
		assertEquals(shangai, bloccata1.getStanzaAdiacente("nord"));
		StanzaBloccata bloccata2= new StanzaBloccata("barricata","est");
		bloccata2.addAttrezzo(piedeDiPorco);
		bloccata2.impostaStanzaAdiacente("est", shangai);
		assertEquals(shangai, bloccata2.getStanzaAdiacente("est"));
		StanzaBloccata bloccata3= new StanzaBloccata("barricata","sud");
		bloccata3.addAttrezzo(piedeDiPorco);
		bloccata3.impostaStanzaAdiacente("sud", shangai);
		assertEquals(shangai, bloccata3.getStanzaAdiacente("sud"));
		StanzaBloccata bloccata4= new StanzaBloccata("barricata","ovest");
		bloccata4.addAttrezzo(piedeDiPorco);
		bloccata4.impostaStanzaAdiacente("ovest", shangai);
		assertEquals(shangai, bloccata4.getStanzaAdiacente("ovest"));
	}
}
