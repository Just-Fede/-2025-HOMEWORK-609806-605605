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

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	
	private IOConsole io;

	private Partita partita;

	public DiaDia(IOConsole io) {
		this.io=io;
		this.partita = new Partita();
	}

	public void gioca() {
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

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi")) 
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa")) 
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} 
		else if(partita.persa()) {
			io.mostraMessaggio("Hai perso!");
			return true;
		}
		else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) 
	{
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.player.getCfu();
			this.partita.player.setCfu(cfu-1);
		}
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("CFU: "+partita.player.getCfu());
		if (partita.isFinita() == true) {
			partita.setFinita();
		}
	}

	/**
	 * Cerca di raccogliere un attrezzo presente nella stanza corrente.
	 * se l'attrezzo esiste e c'è spazio nella borsa, viene rimosso dalla stanza
	 * e aggiunto all'inventario del giocatore.
	 *
	 * @param nome: il nome dell'attrezzo da raccogliere 
	 */

	private void prendi(String nome) {
		if (nome==null) {
			io.mostraMessaggio("Cosa vuoi raccogliere?");
			return;
		}
		else if (partita.getStanzaCorrente().hasAttrezzo(nome)) {
			if(partita.player.aggiungiAllaBorsa(partita.getStanzaCorrente().getAttrezzo(nome)))
				io.mostraMessaggio("Oggetto aggiunto all'inventario e ... ");

			if(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nome))) 
				io.mostraMessaggio("Ora non è più per terra!\n" + partita.player.getInventario().toString());

			else 
				io.mostraMessaggio("Oggetto non trovato");
		}
		else 
			io.mostraMessaggio("Questo attrezzo non è quì presente...");
	}

	private void posa(String nome) {
		if (partita.player.getInventario().isEmpty()==true) {
			io.mostraMessaggio("Il tuo inventario è vuoto");
			return;
		}
		else if(partita.getStanzaCorrente().contaAttrezzi()==10)
			io.mostraMessaggio("La stanza è piena");
		if (nome==null) {
			io.mostraMessaggio("Cosa vuoi posare?");
			return;
		}
		else if(partita.player.getInventario().hasAttrezzo(nome)) {
			if (partita.getStanzaCorrente().contaAttrezzi()<partita.getStanzaCorrente().getNumeroMassimoAttrezzi()) {
				partita.getStanzaCorrente().addAttrezzo(partita.player.getInventario().getAttrezzo(nome));
				partita.player.getInventario().removeAttrezzo(nome);
				io.mostraMessaggio("Hai posato "+nome);
			}

		}
		else 
			io.mostraMessaggio("Non possiedi questo oggetto");

	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole io=new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}