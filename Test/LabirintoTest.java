import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.*;

public class LabirintoTest 
{
	Labirinto labirintoTest;

	@BeforeEach
	public void setUp()
	{
		labirintoTest = new Labirinto();
		labirintoTest.creaStanze();
	}

	@Test
	public void testGetStanzaVincete()
	{
		assertEquals(labirintoTest.getStanzaVincente().getNome(), "Biblioteca");
	}

	@Test
	public void testGetStanzaIniziale()
	{
		assertEquals(labirintoTest.getStanzaIniziale().getNome(), "Atrio");
	}
}
