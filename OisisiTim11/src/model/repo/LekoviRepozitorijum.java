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
import model.Lek;

public class LekoviRepozitorijum {
	
	private final String lekoviJson;
	private final String direktorijum;
	private final Gson gson;
	
	public LekoviRepozitorijum(Gson gson, String direktorijum) {
		this.gson = gson;
		this.direktorijum = direktorijum;
		this.lekoviJson = "lekovi.json";
	}
	
	public List<Lek> ucitajLekove() {
		List<Lek> lekovi = new ArrayList<Lek>();
		
		try {
			java.lang.reflect.Type lekType = new TypeToken<List<Lek>>(){}.getType();
			lekovi = gson.fromJson(new FileReader(direktorijum + lekoviJson), lekType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return lekovi;
	}
	
	public boolean insertujLek(Lek noviLek) {
		List<Lek> lekovi = ucitajLekove();
		
		boolean postoji = false;
		for (Lek lek : lekovi) {
			if (lek.getSifra().equals(noviLek.getSifra())) {
				postoji = true;
				break;
			}
		}
		
		if (postoji) {
			return false;
		}
		
		lekovi.add(noviLek);
		try {
			sacuvajNovoStanje(lekovi);
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean izmeniLek(Lek lekZaIzmenu, String staraSifra) {
		List<Lek> lekovi = ucitajLekove();
		int indeksPronadjenog = -1;
		for (int i=0; i < lekovi.size(); i++) {
			Lek lek = lekovi.get(i);
			if (lek.getSifra().equals(staraSifra)) {
				indeksPronadjenog = i;
				break;
			}
					
		}
		if (indeksPronadjenog ==-1) {
			return false;
		}
		lekovi.set(indeksPronadjenog, lekZaIzmenu);
		try {
			sacuvajNovoStanje(lekovi);
		}catch(IOException e) {
			return false;
		}
		
		return true;
	}
	
	private void sacuvajNovoStanje(List<Lek> lekovi) throws IOException {
		String listaLekova = gson.toJson(lekovi);
	     
	    BufferedWriter writer = new BufferedWriter(new FileWriter(direktorijum + lekoviJson));
	    writer.write(listaLekova);
	    writer.close();
	}
}
