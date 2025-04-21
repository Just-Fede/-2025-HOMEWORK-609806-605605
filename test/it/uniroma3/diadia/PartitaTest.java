package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartitaTest 
{
	private Partita partita;

	@BeforeEach
	public void setUp()
	{
		partita = new Partita();
	}

	@Test
	public void testIsFinita()
	{
		assertFalse(partita.isFinita());
		partita.player.setCfu(0);
		assertTrue(partita.isFinita());		
	}
	
	@Test
	public void testVinta()
	{
		assertFalse(partita.vinta());
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testLabirinto()
	{
		assertNotNull(partita.getLabirinto());
	}

}