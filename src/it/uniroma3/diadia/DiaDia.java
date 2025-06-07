package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaComandiRiflessiva;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private IO io;

	private Partita partita;

	private Labirinto labirinto;

	public DiaDia(Labirinto labirinto,IO io) 
	{
		this.io=io;
		this.labirinto=labirinto;
		this.partita = new Partita(labirinto);

	}

	public void gioca() throws Exception 
	{
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione,io));
	}   

	public Partita getPartita() {
		return partita;
	}
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */

	private boolean processaIstruzione(String istruzione, IO io) throws Exception 
	{
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaComandiRiflessiva(io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(partita);

		if (this.partita.vinta()) 
			io.mostraMessaggio("Hai vinto!");

		if(partita.persa()) 
			io.mostraMessaggio("Hai perso!");

		return this.partita.isFinita();
	}   

	public static void main(String[] argc) throws Exception 
	{
		Scanner scanner = new Scanner(System.in);
		IO io=new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto5.txt").getLabirinto();
//			.addStanzaIniziale("salotto")
//			.addAttrezzo("sturacessi", 2)
//			.addStanza("cucina")
//			.addAttrezzo("pentola",1)// dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
//			.addStanzaVincente("camera")
//			.addAdiacenza("salotto", "cucina", "nord")
//			.addAdiacenza("cucina", "camera", "est")
//			.addStanzaBloccata("bagno","est","sturacessi")
//			.addAdiacenza("bagno","salotto" ,"ovest")
//			.addStanza("sgabuzzino")
//			.addAdiacenza("bagno","sgabuzzino", "est")
//			.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
		scanner.close();
	}
}