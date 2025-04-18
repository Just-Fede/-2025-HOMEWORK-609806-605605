package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest 
{
	private Stanza stanzaTest1;
	private Stanza stanzaTest2;
	
	@BeforeEach
	public void setUp()
	{
	stanzaTest1 = new Stanza("Backrooms");
	stanzaTest2 = new Stanza("Testroom");
	}
	
	@Test
	public void testImpostaStanzaAdiacente()
	{
		
		stanzaTest1.impostaStanzaAdiacente("sud",stanzaTest2);
		assertNotNull(stanzaTest1.getDirezioni());
	}
	
	@Test
	public void testGetStanzaAdiacente()
	{
		stanzaTest1.impostaStanzaAdiacente("sud",stanzaTest2);
		assertEquals(stanzaTest1.getStanzaAdiacente("sud"),stanzaTest2);

	}
	
	@Test
	public void testStanzaAttrezzi()
	{
		assertNotNull(stanzaTest1.getAttrezzi());
		assertEquals(stanzaTest1.contaAttrezzi(),0);

		
		Attrezzo computerQuantistico = new Attrezzo("Computer Quantistico",10);
		assertTrue(stanzaTest1.addAttrezzo(computerQuantistico));
		assertEquals(stanzaTest1.contaAttrezzi(),1);
	}
}
