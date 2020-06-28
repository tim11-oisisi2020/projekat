package model;

public class Recept {

	private String datum;
	
	private String sifra;
	
	private String lekar;
	
	private String jmbgPacijenta;
	
	
	public Recept() {
		
	}

	public Recept(String datum, String sifra, String lekar, String jmbgPacijenta) {
		super();
		this.datum = datum;
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbgPacijenta = jmbgPacijenta;
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
	
	public static String[] getTableHeader() {
		return new String[]{"Datum", "Sifra", "Lekar", "JMBG Pacijenta"};
	}

	@Override
	public String toString() {
		return "Recept [datum=" + datum + ", sifra=" + sifra + ", lekar=" + lekar + ", jmbgPacijenta="
				+ jmbgPacijenta + "]";
	}
	
}
