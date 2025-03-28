import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

public class TestGiocatore 
{
	Giocatore testPlayer;
	
	@BeforeEach
	public void setUp()
	{
		testPlayer = new Giocatore();
	}
	
	@Test
	public void testGetCfu()
	{
		assertEquals(testPlayer.getCfu(),20);
	}
	
	@Test
	public void testSetCfu()
	{
		int CFU = 99;
		testPlayer.setCfu(CFU);
		assertEquals(testPlayer.getCfu(),CFU);
	}
	
	public void testAggiungiAllaBorsa()
	{
		Attrezzo computerQuantistico = new Attrezzo("Computer Quantistico",10);
		assertTrue(testPlayer.aggiungiAllaBorsa(computerQuantistico));
		
		Attrezzo OldreacIlNano = new Attrezzo("Oldraec",2000);
		assertFalse(testPlayer.aggiungiAllaBorsa(OldreacIlNano));
		
	}
}
