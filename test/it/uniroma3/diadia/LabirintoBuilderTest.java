package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilderTest {

	Labirinto.LabirintoBuilder lb;

	@Before
	public void setUp() throws Exception {
		//lb = Labirinto.newBuilder("labirinto.txt");
		lb = new LabirintoBuilder("labirinto.txt");
	} 

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
		assertEquals(Labirinto.class, lb.getLabirinto().getClass());
	}

	@Test
	public void testAddStanza() {
		lb.addStanza("stanzetta");
		Stanza expected = new Stanza("stanzetta");
		assertEquals(expected, lb.getNome2stanza().get("stanzetta"));
	}

	@Test
	public void testAddAttrezzoSenzaUltimaStanzaAggiunta(){
		
		//lb.addAttrezzo("cacciavite", 3);
		//Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(LabirintoBuilder.class, lb.addAttrezzo("cacciavite", 3).getClass());
	}
	
	@Test
	public void testAddAttrezzoConUltimaStanzaAggiunta(){
		lb.addStanzaIniziale("stanzetta").addAttrezzo("cacciavite", 3);
		Attrezzo expected = new Attrezzo("cacciavite", 3);
		assertEquals(expected, lb.getLabirinto().getStanzaCorrente().getAttrezzo("cacciavite"));		
	}

	@Test
    public void testAddAttrezzoConStanza() {
        lb.addStanza("stanzetta");
        lb.addAttrezzo("cacciavite", 3);
        assertTrue(lb.getNome2stanza().get("stanzetta").hasAttrezzo("cacciavite"));
    }
}


