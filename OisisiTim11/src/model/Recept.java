package model;

public class Recept {
	
	private int sifra;
	private String lekar;
	private String jmbg;
	private String datum;
	private String vreme;
	private String lek;
	private float cena;
	
	public Recept(int sifra, String lekar, String jmbg, String datum, String vreme, String lek, float cena) {
		super();
		this.sifra = sifra;
		this.lekar = lekar;
		this.jmbg = jmbg;
		this.datum = datum;
		this.vreme = vreme;
		this.lek = lek;
		this.cena = cena;
	}

}
