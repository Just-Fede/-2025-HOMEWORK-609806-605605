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
	public void testCreStanze() //Metodo partita 1
	{
		assertEquals(partita.getStanzaCorrente().getNome(),"Atrio");
	}

	@Test
	public void testIsFinita() //Metodo partita 2
	{
		partita.player.setCfu(0); //imposto i cfu a 0
		assertTrue(partita.isFinita()); //verifico che la funzione mi restituisca True (partita finita)
	}
	
	@Test
	public void testVinta() //Metodo partita 3
	{
		assertFalse(partita.vinta());
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}

	@Test
	public void TestGetNome() //Metodo Stanza 1
	{
		Attrezzo spada = new Attrezzo("spada",5);
		assertEquals(spada.getNome(),"spada");
		assertEquals(spada.getPeso(),5);
	}
	
	@Test
	public void testGetAttrezzo() //Metodo stanza 2
	{
		assertNotNull(partita.getStanzaCorrente().getAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzo() //Metodo stanza 3
	{
		assertTrue(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo("osso")));
	}

}