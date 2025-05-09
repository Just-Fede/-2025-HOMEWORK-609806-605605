package test.it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	@Test
	public void testSenzaLanterna() {
		StanzaBuia buia=new StanzaBuia("cripta");
		assertEquals("qui c'è buio pesto", buia.getDescrizione());
	}

	@Test
	public void testConLanterna() {
		StanzaBuia buia=new StanzaBuia("cripta");	
		Attrezzo lanterna=new Attrezzo("lanterna",1);
		buia.addAttrezzo(lanterna);
		assertEquals(buia.toString(), buia.getDescrizione());
	}
}
