package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole 
{
	public void mostraMessaggio(String msg) 
	{
		if(msg == null)
			System.out.println("[STRINGA VUOTA]");
		
		System.out.println(msg);
	}
	
	public String leggiriga() 
	{
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga=scannerDiLinee.nextLine();
		//scannerDiLinee.close(); RIGA MOMENTANEAMENTE OMESSA
		return riga;
	}
}
