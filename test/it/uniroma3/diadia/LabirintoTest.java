package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest 
{
	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;
	Labirinto labirintoTest;

//	@BeforeEach
//	public void setUp()
//	{
//		labirintoTest = creaBilocale();
//	}
	
//	public Labirinto creaBilocale() {
//		Labirinto bilocale=new LabirintoBuilder()
//				.addStanzaIniziale("Atrio")
//				.addStanzaVincente("Corridoio")
//				.addAdiacenza("Atrio", "Corridoio", "nord")
//				.getLabirinto();
//		return bilocale;
//	}
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
//				Labirinto.newBuilder()
//				.addStanzaIniziale("Atrio")
//				.addAttrezzo("martello", 3)
//				.addStanzaVincente("Biblioteca")
//				.addAdiacenza("Atrio", "Biblioteca", "nord")
//				.getLabirinto();
		
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
		
	}


	@Test
	public void testGetStanzaVincete()
	{
		assertEquals(l.getStanzaVincente().getNome(), "Biblioteca");
	}

	@Test
	public void testGetStanzaIniziale()
	{
		assertEquals(l.getStanzaIniziale().getNome(), "Atrio");
	}
}
