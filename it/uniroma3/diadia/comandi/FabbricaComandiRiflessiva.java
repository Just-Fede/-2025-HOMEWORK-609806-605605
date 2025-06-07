package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaComandiRiflessiva implements FabbricaDiComandi {
	
	private IO io;
	public FabbricaComandiRiflessiva(IO io) {
		this.io = io;
	}
	
	public Comando costruisciComando(String istruzione) throws Exception {
		Scanner scannerDiParole = new Scanner(istruzione); 
		String nomeComando = null; 
		String parametro = null; 
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro
		
		StringBuilder nomeClasse
		= new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		nomeClasse.append( nomeComando.substring(1) ) ;
		comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;
	}	
}