package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

class ComandoPrendiTest 
{
	@Test
	void test() 
	{
		Attrezzo manualeJava = new Attrezzo("Manuale Java",5);
		Attrezzo oldreakIlNano = new Attrezzo("Oldrek Il Nano",2000);
		
		Stanza atrio = new Stanza("Atrio");
		atrio.addAttrezzo(oldreakIlNano);
		
		Partita partita = new Partita();
		partita.setStanzaCorrente(atrio);
		
		Comando comando = new ComandoPosa("");
		assertFalse(comando.esegui(partita));
		
		partita.player.aggiungiAllaBorsa(manualeJava);
		
		comando = new ComandoPosa("");
		assertFalse(comando.esegui(partita));
		
		comando = new ComandoPosa("Oldreak Il Nano");
		assertFalse(comando.esegui(partita));
		
		comando = new ComandoPosa("Manuale Java");
		assertTrue(comando.esegui(partita));
		assertFalse(comando.esegui(partita));
	}

}
