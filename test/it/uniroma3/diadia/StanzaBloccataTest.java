package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest 
{

	IO io = new IOConsole();
	
	Partita partitaTest;
	Stanza stanzaInizialeTest;
	Stanza stanzaFinaleTest;
	Attrezzo piedeDiPorco;
	
	
	@BeforeEach
	public void setUp()
	{
		
		stanzaInizialeTest = new StanzaBloccata("Stanza Iniziale Test","piedediporco","nord");
		stanzaFinaleTest = new Stanza("Stanza Finale");
		
		partitaTest = new Partita(creaBilocale());
		partitaTest.setStanzaCorrente(stanzaInizialeTest);
		
		stanzaInizialeTest.impostaStanzaAdiacente("nord", stanzaFinaleTest);
		stanzaFinaleTest.impostaStanzaAdiacente("sud", stanzaInizialeTest);
		
		piedeDiPorco = new Attrezzo("piedediporco",1);
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
	public void testGetStanzaAdiacente() 
	{
		assertEquals(partitaTest.getStanzaCorrente(),stanzaInizialeTest);
		
		//Proviamo senza oggetto
		partitaTest.getStanzaCorrente().getStanzaAdiacente("nord");
		assertEquals(partitaTest.getStanzaCorrente(),stanzaInizialeTest);
		
		//Proviamo con l'oggetto
		partitaTest.getStanzaCorrente().addAttrezzo(piedeDiPorco);
		partitaTest.setStanzaCorrente(partitaTest.getStanzaCorrente().getStanzaAdiacente("nord"));
		assertEquals(partitaTest.getStanzaCorrente(),stanzaFinaleTest);
	}
}
