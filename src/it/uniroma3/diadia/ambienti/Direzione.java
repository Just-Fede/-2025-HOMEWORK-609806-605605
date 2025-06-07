package it.uniroma3.diadia.ambienti;

public enum Direzione {
	nord, est, sud, ovest;

	public String getDirezioneComeStringa(Direzione direzione) {
		switch (direzione) {
		case nord:
			return "nord";
		case sud:
			return "sud";
		case est:
			return "est";
		case ovest:
			return "ovest";
		default:
			return "direzione sconosciuta";
		}

	}

}