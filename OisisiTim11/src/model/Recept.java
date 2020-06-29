package model;

public class Recept {

	private String datum;
	
	private String sifra;
	
	private String lekar;
	
	private String jmbgPacijenta;

	private Lek[] lekovi;
	
	public Recept() {
		
	}

	public Recept(String datum, String sifra, String lekar, String jmbgPacijenta, Lek[] lekovi) {
		super();
		this.datum = datum;
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbgPacijenta = jmbgPacijenta;
		this.lekovi = lekovi;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getLekar() {
		return lekar;
	}

	public void setLekar(String lekar) {
		this.lekar = lekar;
	}

	public String getJmbgPacijenta() {
		return jmbgPacijenta;
	}

	public void setJmbgPacijenta(String jmbgPacijenta) {
		this.jmbgPacijenta = jmbgPacijenta;
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
	
	public void setLekovi(Lek[] lekovi) {
		this.lekovi = lekovi;
	}
	
	public static String[] getTableHeader() {
		return new String[]{"Datum", "Sifra", "Lekar", "JMBG Pacijenta", "Lista lekova"};
	}

	@Override
	public String toString() {
		return "Recept [datum=" + datum + ", sifra=" + sifra + ", lekar=" + lekar + ", jmbgPacijenta="
				+ jmbgPacijenta + ", lekovi=[" + lekovi + "]]";
	}
	
}