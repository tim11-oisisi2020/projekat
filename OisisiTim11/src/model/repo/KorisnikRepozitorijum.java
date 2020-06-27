package model.repo;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public boolean insertujKorisnika(Korisnik noviKorisnik) {
		List<Korisnik> korisnici = ucitajKorisnike();
		
		boolean postoji = false;
		for (Korisnik korisnik : korisnici) {
			if (korisnik.getKorisnickoIme().equals(noviKorisnik.getKorisnickoIme())) {
				postoji = true;
				break;
			}
		}
		
		if (postoji) {
			return false;
		}
		
		korisnici.add(noviKorisnik);
		try {
			sacuvajNovoStanje(korisnici);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean izmeniKorisnika(Korisnik korisnikZaIzmenu, String stariUsername) {
		List<Korisnik> korisnici = ucitajKorisnike();
		
		int indeksPronadjenog = -1;
		for (int i = 0; i < korisnici.size(); i++) {
			Korisnik korisnik = korisnici.get(i);
			if (korisnik.getKorisnickoIme().equals(stariUsername)) {
				indeksPronadjenog = i;
				break;
			}
		}
		
		if (indeksPronadjenog == -1) {
			return false;
		}
		
		korisnici.set(indeksPronadjenog, korisnikZaIzmenu);
		try {
			sacuvajNovoStanje(korisnici);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	private void sacuvajNovoStanje(List<Korisnik> korisnici) throws IOException {
		String listaLekova = gson.toJson(korisnici);
	     
	    BufferedWriter writer = new BufferedWriter(new FileWriter(direktorijum + korisniciJson));
	    writer.write(listaLekova);
	    writer.close();
	}

}
