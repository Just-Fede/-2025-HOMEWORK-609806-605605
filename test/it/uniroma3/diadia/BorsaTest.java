package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

public class BorsaTest
{

	private Borsa inventarioTest;

	@BeforeEach
	public void setUp()
	{
		inventarioTest = new Borsa(10);
	}

	@Test
	public void testAddAttrezzo()
	{
		Attrezzo computerQuantistico = new Attrezzo("Computer Quantistico",10);
		assertTrue(inventarioTest.addAttrezzo(computerQuantistico));

		Attrezzo OldreacIlNano = new Attrezzo("Oldraec",2000);
		assertFalse(inventarioTest.addAttrezzo(OldreacIlNano));
	}

	@Test
	public void testGetAttrezzo()
	{
		Attrezzo computerQuantistico = new Attrezzo("Computer Quantistico",10);
		inventarioTest.addAttrezzo(computerQuantistico);
		assertEquals(inventarioTest.getAttrezzo("Computer Quantistico"), computerQuantistico);
	}

	@Test
	public void testRemoveAttrezzo()
	{
		Attrezzo tavolettaDelWater = new Attrezzo("Tavoletta Del Water",5);
		Attrezzo coca = new Attrezzo("Coca",1);
		
		inventarioTest.addAttrezzo(tavolettaDelWater);
		inventarioTest.addAttrezzo(coca);
		
		assertEquals(inventarioTest.getNumeroAttrezzi(),2);
		
		assertTrue(inventarioTest.removeAttrezzo("Tavoletta Del Water"));
		assertFalse(inventarioTest.removeAttrezzo("Tavoletta Del Water"));
		
		assertEquals(inventarioTest.getNumeroAttrezzi(),1);
		
		assertTrue(inventarioTest.removeAttrezzo("Coca"));
		assertFalse(inventarioTest.removeAttrezzo("Coca"));

	}

}
