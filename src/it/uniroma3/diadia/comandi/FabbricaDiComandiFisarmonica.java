package it.uniroma3.diadia.comandi;
import java.util.Scanner;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi 
{
	private IO io;
	public FabbricaDiComandiFisarmonica(IO io) {
		this.io=io;
	}
	@Override
	public Comando costruisciComando(String istruzione) 
	{
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();// prima parola: nome del comando

		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale param.

		if (nomeComando == null)
			comando = new ComandoNonValido(io);
		
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(parametro,io);
		
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(parametro,io);
		
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(parametro,io);
		
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(io);
		
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine(io);
		
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(io);
		
		else comando = new ComandoNonValido(io);

		return comando;
	}
}