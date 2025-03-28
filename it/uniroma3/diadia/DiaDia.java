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

	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
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
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} 
		else if(partita.persa()) {
			System.out.println("Hai perso!");
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
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) 
	{
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.player.getCfu();
			this.partita.player.setCfu(cfu-1);
		}
		System.out.println(partita.getStanzaCorrente().getDescrizione());
		System.out.println("CFU: "+partita.player.getCfu());
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
			System.out.println("Cosa vuoi raccogliere?");
			return;
		}
		else if (partita.getStanzaCorrente().hasAttrezzo(nome)) {
			if(partita.player.aggiungiAllaBorsa(partita.getStanzaCorrente().getAttrezzo(nome)))
				System.out.print("Oggetto aggiunto all'inventario e ... ");

			if(partita.getStanzaCorrente().removeAttrezzo(partita.getStanzaCorrente().getAttrezzo(nome))) 
				System.out.println("Ora non è più per terra!\n" + partita.player.getInventario().toString());

			else 
				System.out.println("Oggetto non trovato");
		}
		else 
			System.out.println("Questo attrezzo non è quì presente...");
	}

	private void posa(String nome) {
		if (partita.player.getInventario().isEmpty()==true) {
			System.out.println("Il tuo inventario è vuoto");
			return;
		}
		else if(partita.getStanzaCorrente().contaAttrezzi()==10)
			System.out.println("La stanza è piena");
		if (nome==null) {
			System.out.println("Cosa vuoi posare?");
			return;
		}
		else if(partita.player.getInventario().hasAttrezzo(nome)) {
			if (partita.getStanzaCorrente().contaAttrezzi()<partita.getStanzaCorrente().getNumeroMassimoAttrezzi()) {
				partita.getStanzaCorrente().addAttrezzo(partita.player.getInventario().getAttrezzo(nome));
				partita.player.getInventario().removeAttrezzo(nome);
				System.out.println("Hai posato "+nome);
			}

		}
		else 
			System.out.println("Non possiedi questo oggetto");

	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}