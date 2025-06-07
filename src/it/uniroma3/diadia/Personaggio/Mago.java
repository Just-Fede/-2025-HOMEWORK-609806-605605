package it.uniroma3.diadia.Personaggio;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{
	private static final String MESSAGGIO_DONO="Sei un vero simpaticone, "+"con una mia magica azione, troverai un nuovo oggetto "+"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE="Mi spiace, ma non ho più nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo=attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo=null;
			msg=MESSAGGIO_DONO;
		}
		else {
			msg=MESSAGGIO_SCUSE;
		}
		return msg;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Grazie per avermi regalato ");
		risposta.append(attrezzo.getNome()+".");
		risposta.append(" Lo modificherò e lo lascerò!");
		Attrezzo attrezzoModificato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoModificato);
		return risposta.toString();
	}
}
