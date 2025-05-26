package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe gestisce la creazione del personaggio principale
 *
 * @author  Federico Cerilli
 * @see Partita
 * @version base
 */
public class Giocatore
{
	/* Nome? */
	static final private int CFU_INIZIALI = 20;
	private int cfu=CFU_INIZIALI;
	private Borsa inventario = new Borsa(10); 

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getInventario()
	{
		return this.inventario;
	}

	public boolean aggiungiAllaBorsa(Attrezzo attrezzo)
	{
		if( (inventario.getPeso() + attrezzo.getPeso() <= inventario.getPesoMax())/* && (inventario.getNumeroAttrezzi() <= inventario.getGrandezza())*/)
		{
			inventario.addAttrezzo(attrezzo);
			return true;
		}
		else
			return false;
	}

}
