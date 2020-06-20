package model;

public class Korisnik {

	private String korisnickoIme;
	
	private String lozinka;
	
	private String ime;
	
	private String prezime;
	
	private TipKorisnika tipKorisnika;
	
	public Korisnik() {
		
	}

	public Korisnik(String korisnickoIme, String lozinka, String ime, String prezime, TipKorisnika tipKorisnika) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.tipKorisnika = tipKorisnika;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	@Override
	public String toString() {
		return "Korisnik [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime="
				+ prezime + ", tipKorisnika=" + tipKorisnika + "]";
	}
	
}
