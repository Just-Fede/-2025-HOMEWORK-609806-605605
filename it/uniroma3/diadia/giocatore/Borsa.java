package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	//	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<Attrezzo>();
		//		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		attrezzi.add(attrezzo);
		//		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) 
	{
		Attrezzo a = null;
		for (Attrezzo stampa: attrezzi){
			if (stampa.getNome().equals(nomeAttrezzo))
				a = stampa;
		}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (Attrezzo conta:attrezzi) {
			if(conta != null)
				peso += conta.getPeso();
			else peso +=0;
		}
		return peso;
	}

	public int getNumeroAttrezzi()
	{return this.getGrandezza();}

	public int getGrandezza(){
		return attrezzi.size();
	}

	public boolean isEmpty() {
		return this.getGrandezza() == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) 
	{
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		if (this.hasAttrezzo(nomeAttrezzo)) {
			attrezzi.remove(this.getAttrezzo(nomeAttrezzo));
			return true;
		}

		return false;	
	}

	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo>ordinati = new ArrayList<Attrezzo>(this.attrezzi);
		ordinati.sort(Comparator.comparing(Attrezzo::getPeso).thenComparing(Attrezzo::getNome));
		return ordinati;
	}

	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> ordinati= new TreeSet<>(Comparator.comparing(Attrezzo::getNome));
		ordinati.addAll(this.attrezzi);
		return ordinati;
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa=new HashMap<>();
		for (Attrezzo a:this.attrezzi) {
			int peso=a.getPeso();
			if(!mappa.containsKey(peso)) {
				mappa.put(peso, new HashSet<>());
			}
			mappa.get(peso).add(a);
		}
		return mappa;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo stampa:attrezzi) {
				s.append(stampa.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}