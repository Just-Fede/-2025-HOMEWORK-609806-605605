package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import it.uniroma3.diadia.comandi.*;
import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest 
{
	private FabbricaDiComandiFisarmonica fabbricaTest;
	IO io = new IOConsole();

	@BeforeEach
	void setUp()
	{
		fabbricaTest = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	void testVai() 
	{
		Comando comando = fabbricaTest.costruisciComando("vai nord");
		assertEquals(comando.getNome(),"vai");
		assertEquals(comando.getParametro(),"nord");
		
		comando = fabbricaTest.costruisciComando("vai");
		assertEquals(comando.getNome(),"vai");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testPrendi() 
	{
		Comando comando = fabbricaTest.costruisciComando("prendi AIDS");
		assertEquals(comando.getNome(),"prendi");
		assertEquals(comando.getParametro(),"AIDS");
		
		comando = fabbricaTest.costruisciComando("prendi");
		assertEquals(comando.getNome(),"prendi");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testPosa() 
	{
		Comando comando = fabbricaTest.costruisciComando("posa Oldrek");
		assertEquals(comando.getNome(),"posa");
		assertEquals(comando.getParametro(),"Oldrek");
		
		comando = fabbricaTest.costruisciComando("posa");
		assertEquals(comando.getNome(),"posa");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testNonValido() 
	{
		Comando comando = fabbricaTest.costruisciComando("gfyuafgiagfyuadgfuayg");
		assertEquals(comando.getNome(),"nonValido");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testFine() 
	{
		Comando comando = fabbricaTest.costruisciComando("fine");
		assertEquals(comando.getNome(),"fine");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testGuarda() 
	{
		Comando comando = fabbricaTest.costruisciComando("guarda");
		assertEquals(comando.getNome(),"guarda");
		assertEquals(comando.getParametro(),null);
	}
	
	@Test
	void testAiuto() 
	{
		Comando comando = fabbricaTest.costruisciComando("aiuto");
		assertEquals(comando.getNome(),"aiuto");
		assertEquals(comando.getParametro(),null);
	}

}
