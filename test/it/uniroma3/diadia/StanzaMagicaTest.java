package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaMagica;

public class StanzaMagicaTest 
{

	private StanzaMagica stanzaDiPidppy;
	private Attrezzo OldrekIlNano;
	
	@BeforeEach
	public void setUp()
	{
		stanzaDiPidppy = new StanzaMagica("Stanza Di Pidppy",1);
		OldrekIlNano = new Attrezzo("Oldrek Il Nano",1000);
	}
	
	@Test
	public void testAttrezzoModificaAttrezzo() 
	{
		assertEquals(OldrekIlNano.getNome(),"Oldrek Il Nano");
		assertNotEquals(OldrekIlNano.getNome(),stanzaDiPidppy.modificaAttrezzo(OldrekIlNano));
		assertNotEquals("onaN lI kerdlo",stanzaDiPidppy.modificaAttrezzo(OldrekIlNano));
	}
}
