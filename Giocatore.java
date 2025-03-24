public class Giocatore
{
	/* Nome? */
	static final private int CFU_INIZIALI = 2;
	private int cfu=CFU_INIZIALI;

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	public int getCFUIniziali()
	{
		return this.CFU_INIZIALI;
	}

}