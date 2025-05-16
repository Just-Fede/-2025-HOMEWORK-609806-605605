package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.util.*;

public class Borsa 
{
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private int numeroAttrezzi;
	private int pesoMax;

	//Dichiaro una lista di attrezzi
	private List<Attrezzo> borsa;

	public Borsa() 
	{
		this(DEFAULT_PESO_MAX_BORSA);
		this.borsa = new ArrayList<>();
	}

	public Borsa(int pesoMax) 
	{
		this.pesoMax = pesoMax;
		this.borsa = new ArrayList<>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) 
	{
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		borsa.add(attrezzo);
		return true;
	}

	public int getPesoMax() 
	{
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) 
	{
		for (Attrezzo a : borsa)
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		return null;
	}

	public int getPeso() 
	{
		int peso = 0;

		for (Attrezzo a:borsa)
			peso+=a.getPeso();

		return peso;
	}

	public int getNumeroAttrezzi()
	{
		return borsa.size();
	}

	public boolean isEmpty() 
	{
		return borsa.size() == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) 
	{
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) 
	{

		for(Attrezzo a:borsa)
			if(a.getNome().equals(nomeAttrezzo))
			{
				borsa.remove(a);
				return true;
			}
		return false;
	}

	public String toString() 
	{
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) 
		{
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for (Attrezzo a:borsa)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}