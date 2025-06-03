package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagica extends Stanza 
{
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	private boolean isMagica;

	public StanzaMagica(String nome) 
	{
		this(nome, SOGLIA_MAGICA_DEFAULT);
		isMagica=true;
	}

	public StanzaMagica(String nome, int soglia) 
	{
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
		isMagica=true;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) 
	{
		this.contatoreAttrezziPosati++;
		
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);
	}

	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) 
	{
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;

		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
	
	public boolean isMagica() {
		return isMagica;
	}
}