package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest 
{

	Partita partitaTest;
	Stanza stanzaInizialeTest;
	Stanza stanzaFinaleTest;
	Attrezzo lanterna;
	
	@BeforeEach
	public void setUp()
	{
		stanzaInizialeTest = new StanzaBuia("Stanza Iniziale Test","lanterna");
		stanzaFinaleTest = new Stanza("Stanza Finale");

		partitaTest = new Partita(creaBilocale());
		partitaTest.setStanzaCorrente(stanzaInizialeTest);

		stanzaInizialeTest.impostaStanzaAdiacente("nord", stanzaFinaleTest);
		stanzaFinaleTest.impostaStanzaAdiacente("sud", stanzaInizialeTest);

		lanterna = new Attrezzo("lanterna",1);
	}
	
	public Labirinto creaBilocale() {
		Labirinto bilocale=new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Corridoio")
				.addAdiacenza("Atrio", "Corridoio", "nord")
				.getLabirinto();
		return bilocale;
	}
	
	@Test
	public void testStanzaBuia() 
	{
		assertEquals(partitaTest.getStanzaCorrente().getDescrizione(),"qui c'è buio pesto");
		partitaTest.getStanzaCorrente().addAttrezzo(lanterna);
		assertNotEquals(partitaTest.getStanzaCorrente().getDescrizione(),"qui c'è buio pesto");
	}
}
