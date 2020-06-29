package model;

public class Racun {
	
	private float ukupnaCena;
	
	private Lek[] lekovi;
	
	public Racun() {
		
	}
	
	public Racun(float ukupnaCena, Lek[] lekovi) {
		super();
		this.ukupnaCena = ukupnaCena;
		this.lekovi = lekovi;
	}
	
	public float getUkupnaCena() {
		return ukupnaCena;
	}
	 
	public Lek[] getLekovi() {
		return lekovi;
	}
	
	@Override
	public String toString() {
		return "Racun [ukupnaCena=" + ukupnaCena + ", lekovi=[" + lekovi +"]]";
	}

}
