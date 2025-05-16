package it.uniroma3.grafica;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import java.awt.*;
import javax.swing.*;

public class FinestraPrincipale 
{
	private JFrame f;
	
	public FinestraPrincipale()
	{
		f = new JFrame("DiaDia");
		f.setSize(1200, 720);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.setContentPane(new JLabel(new ImageIcon("img/atrio.png")));
		f.setVisible(true);
	}

	public void mostraStanza(Stanza stanza) 
	{
	    f.setTitle("Gioco - " + stanza.getNome());
	    
	    JLayeredPane layeredPane = new JLayeredPane();
	    layeredPane.setPreferredSize(new Dimension(1000, 700));

	    JLabel sfondo = new JLabel(new ImageIcon("img/" + stanza.getNome().toLowerCase() + ".png"));
	    sfondo.setBounds(0, 0, 1200, 720);
	    layeredPane.add(sfondo, JLayeredPane.DEFAULT_LAYER);

	    for (Attrezzo attrezzo : stanza.getAttrezzi()) 
	    {
	    	if(attrezzo != null)
	    	{
	        JLabel overlay = new JLabel(new ImageIcon("img/" + attrezzo.getNome().toLowerCase() + ".png"));

	        int x = (int)(Math.random() * 800);
	        int y = (int)(Math.random() * 600);

	        overlay.setBounds(x, y, 128, 128);
	        layeredPane.add(overlay, JLayeredPane.PALETTE_LAYER);
	    	}
	    }

	    f.setContentPane(layeredPane);
	    f.revalidate(); 
	    f.repaint();   
	}

	
}
