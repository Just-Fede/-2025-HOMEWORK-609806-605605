package it.uniroma3.diadia;
import java.util.Scanner;
import it.uniroma3.diadia.ambienti.*;

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

	private IOConsole io;

	private Partita partita;

	public DiaDia(IOConsole io) {
		this.io=io;
		this.partita = new Partita();
	}

	public void gioca() 
	{
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiriga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) 
		{
			partita.fine.fine(io);
			return true;
		} 

		else if (comandoDaEseguire.getNome().equals("vai"))
			partita.vai.vaiDIrezione(comandoDaEseguire.getParametro(), partita, io);

		else if (comandoDaEseguire.getNome().equals("aiuto"))
			partita.aiuto.ElencoComandi(io);

		else if (comandoDaEseguire.getNome().equals("prendi")) 
			partita.prendi.prendi(comandoDaEseguire.getParametro(), partita, io);

		else if (comandoDaEseguire.getNome().equals("posa")) 
			partita.posa.posa(comandoDaEseguire.getParametro(), partita, io);
		
		else if(comandoDaEseguire.getNome().equals("guarda"))
			partita.guarda.guarda(partita, io);

		else
			io.mostraMessaggio("Comando sconosciuto");

		if (this.partita.vinta()) 
		{
			io.mostraMessaggio("Hai vinto!");
			return true;
		} 

		else if(partita.persa()) 
		{
			io.mostraMessaggio("Hai perso!");
			return true;
		}
		else
			return false;
	}   

	public static void main(String[] argc) 
	{
		IOConsole io=new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}