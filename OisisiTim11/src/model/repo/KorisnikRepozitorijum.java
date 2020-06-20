package model.repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Korisnik;

public class KorisnikRepozitorijum {
	
	private final String korisniciJson;
	private final String direktorijum;
	private final Gson gson;
	
	public KorisnikRepozitorijum(Gson gson, String direktorijum) {
		this.gson = gson;
		this.direktorijum = direktorijum;
		this.korisniciJson = "korisnici.json";
	}
	
	public List<Korisnik> ucitajKorisnike() {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		
		try {
			java.lang.reflect.Type korisnikType = new TypeToken<List<Korisnik>>(){}.getType();
			korisnici = gson.fromJson(new FileReader(direktorijum + korisniciJson), korisnikType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return korisnici;
	}

}
