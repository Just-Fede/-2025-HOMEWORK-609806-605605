package it.uniroma3.diadia;
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
		labirintoTest = creaBilocale();
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
	public void testGetStanzaVincete()
	{
		assertEquals(labirintoTest.getStanzaVincente().getNome(), "Corridoio");
	}

	@Test
	public void testGetStanzaIniziale()
	{
		assertEquals(labirintoTest.getStanzaIniziale().getNome(), "Atrio");
	}
}
