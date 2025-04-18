package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPosaTest 
{

	@Test
	void test() 
	{
		Attrezzo manualeJava = new Attrezzo("Manuale Java",5);
		Attrezzo oldreakIlNano = new Attrezzo("Oldrek Il Nano",2000);

		Stanza atrio = new Stanza("Atrio");
		atrio.addAttrezzo(manualeJava);
		atrio.addAttrezzo(oldreakIlNano);

		Partita partita = new Partita();
		partita.setStanzaCorrente(atrio);

		Comando comando = new ComandoPrendi("");

		assertFalse(comando.esegui(partita));

		comando = new ComandoPrendi("Oldreak Il Nano");
		assertFalse(comando.esegui(partita));

		comando = new ComandoPrendi("Manuale Java");
		assertTrue(comando.esegui(partita));
	}

}
