package model;

public class Lek {
	
	private String sifra;
	
	private String ime;
	
	private String proizvodjac;
	
	private boolean naRecept;
	
	private float cena;
	
	public Lek() {
		
	}

	public Lek(String sifra, String ime, String proizvodjac, boolean naRecept, float cena) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.proizvodjac = proizvodjac;
		this.naRecept = naRecept;
		this.cena = cena;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public boolean isNaRecept() {
		return naRecept;
	}

	public void setNaRecept(boolean naRecept) {
		this.naRecept = naRecept;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Lek [sifra=" + sifra + ", ime=" + ime + ", proizvodjac=" + proizvodjac + ", naRecept=" + naRecept
				+ ", cena=" + cena + "]";
	}
	
}
