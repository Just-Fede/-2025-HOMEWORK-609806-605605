package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.*;

class ComandoPrendiTest 
{
	
	
	public Labirinto creaBilocale() {
		Labirinto bilocale=new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addStanzaVincente("Corridoio")
				.addAdiacenza("Atrio", "Corridoio", "nord")
				.getLabirinto();
		return bilocale;
	}
	
	@Test
	void test() 
	{
		IO io = new IOConsole();
		Labirinto bilocale=creaBilocale();
		
		Attrezzo manualeJava = new Attrezzo("Manuale Java",5);
		Attrezzo oldreakIlNano = new Attrezzo("Oldrek Il Nano",2000);
		
		
		Partita partita = new Partita(bilocale);
		partita.getStanzaCorrente().addAttrezzo(oldreakIlNano);
		
		Comando comando = new ComandoPosa("",io);
		assertFalse(comando.esegui(partita));
		
		partita.player.aggiungiAllaBorsa(manualeJava);
		
		comando = new ComandoPosa("",io);
		assertFalse(comando.esegui(partita));
		
		comando = new ComandoPosa("Oldreak Il Nano",io);
		assertFalse(comando.esegui(partita));
		
		comando = new ComandoPosa("Manuale Java",io);
		assertTrue(comando.esegui(partita));
		assertFalse(comando.esegui(partita));
	}

}
