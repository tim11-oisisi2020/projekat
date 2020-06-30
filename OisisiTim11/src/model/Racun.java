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
	 
	public String getLekovi() {
		String lekoviIspis = "";
		
		for (int i = 0; i < lekovi.length; i++) {
			if (i == 0) {
				lekoviIspis = lekovi[i].getIme();
			} else {
				lekoviIspis = lekoviIspis + ", " + lekovi[i].getIme();
			}
		}
		
		return lekoviIspis;
	}
	
	public Lek[] getLekoviArray() {
		return lekovi;
	}
	
	public static String[] getTableHeader() {
		return new String[]{"Lekovi", "Ukupna cena"};
	}
	
	@Override
	public String toString() {
		return "Racun [ukupnaCena=" + ukupnaCena + ", lekovi=[" + lekovi +"]]";
	}

}
