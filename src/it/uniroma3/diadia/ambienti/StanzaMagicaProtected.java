package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaMagicaProtected extends Stanza 
{
	final static protected int SOGLIA_MAGICA_DEFAULT = 3;
	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;

	protected StanzaMagicaProtected(String nome) 
	{
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	protected StanzaMagicaProtected(String nome, int soglia) 
	{
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) 
	{
		this.contatoreAttrezziPosati++;
		
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);
	}

	protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) 
	{
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;

		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();

		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}