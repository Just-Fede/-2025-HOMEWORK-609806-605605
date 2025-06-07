package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	private IO io;

	@Override
	public boolean esegui(Partita partita) {
		Attrezzo attrezzo = partita.getGiocatore().getInventario().getAttrezzo(this.getParametro());
		io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		partita.getGiocatore().getInventario().removeAttrezzo(this.getParametro());
		return true;
	}

	@Override
	public void setIO(IO io) {
		this.io=io;		
	}

}
