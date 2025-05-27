package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;
import java.util.*;

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

	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		Attrezzo arbusto=new Attrezzo("Arbusto",5);
		Attrezzo bonsai=new Attrezzo("Bonsai",5);
		inventarioTest.addAttrezzo(bonsai);
		inventarioTest.addAttrezzo(arbusto);
		Attrezzo[] ordinati=inventarioTest.getSortedSetOrdinatoPerPeso().toArray(new Attrezzo[0]);
		assertEquals("Arbusto",ordinati[0].getNome());
		assertEquals("Bonsai",ordinati[1].getNome());
		assertEquals(2, ordinati.length);
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Attrezzo arbusto=new Attrezzo("Arbusto",3);
		Attrezzo bonsai=new Attrezzo("Bonsai",3);
		Attrezzo cazzuola=new Attrezzo("Cazzuola",1);
		inventarioTest.addAttrezzo(bonsai);
		inventarioTest.addAttrezzo(cazzuola);
		inventarioTest.addAttrezzo(arbusto);
		Attrezzo[] ordinati=inventarioTest.getContenutoOrdinatoPerPeso().toArray(new Attrezzo[0]);
		assertEquals("Cazzuola",ordinati[0].getNome());
		assertEquals("Arbusto",ordinati[1].getNome());
		assertEquals("Bonsai",ordinati[2].getNome());
		assertEquals(3, ordinati.length);
	}

	@Test 
	public void testGetContenutoOrdinatoPerNome() {
		Attrezzo arbusto=new Attrezzo("Arbusto",3);
		Attrezzo bonsai=new Attrezzo("Arbusto",4);
		Attrezzo cazzuola=new Attrezzo("Cazzuola",1);
		inventarioTest.addAttrezzo(bonsai);
		inventarioTest.addAttrezzo(cazzuola);
		inventarioTest.addAttrezzo(arbusto);
		Attrezzo[] ordinati=inventarioTest.getContenutoOrdinatoPerNome().toArray(new Attrezzo[0]);
		assertEquals("Arbusto",ordinati[0].getNome());
		assertTrue(ordinati[0].getPeso()==4);
		assertEquals("Cazzuola",ordinati[1].getNome());
		assertEquals(2, ordinati.length);
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo spada = new Attrezzo("Spada", 4);
		Attrezzo scudo = new Attrezzo("Scudo", 4);
		Attrezzo pozione = new Attrezzo("Pozione", 1);
		inventarioTest.addAttrezzo(spada);
		inventarioTest.addAttrezzo(scudo);
		inventarioTest.addAttrezzo(pozione);
		Map<Integer, Set<Attrezzo>> mappa = inventarioTest.getContenutoRaggruppatoPerPeso();
		assertEquals(2, mappa.size());
		assertTrue(mappa.containsKey(4));
		assertTrue(mappa.containsKey(1));
		Set<Attrezzo> gruppoPeso4 = mappa.get(4);
		assertEquals(2, gruppoPeso4.size());
		assertTrue(gruppoPeso4.contains(spada));
		assertTrue(gruppoPeso4.contains(scudo));
		Set<Attrezzo> gruppoPeso1 = mappa.get(1);
		assertEquals(1, gruppoPeso1.size());
		assertTrue(gruppoPeso1.contains(pozione));
	}

}