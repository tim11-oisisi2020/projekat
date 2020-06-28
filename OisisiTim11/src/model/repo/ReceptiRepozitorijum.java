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

import model.Recept;

public class ReceptiRepozitorijum {
	
	private final String receptiJson;
	private final String direktorijum;
	private final Gson gson;
	
	public ReceptiRepozitorijum(Gson gson, String direktorijum) {
		this.gson = gson;
		this.direktorijum = direktorijum;
		this.receptiJson = "recepti.json";
	}
	
	public List<Recept> ucitajRecepte() {
		List<Recept> recepti = new ArrayList<Recept>();
		
		try {
			java.lang.reflect.Type receptType = new TypeToken<List<Recept>>(){}.getType();
			recepti = gson.fromJson(new FileReader(direktorijum + receptiJson), receptType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return recepti;
	}
	
	public boolean insertujRecept(Recept noviRecept) {
		List<Recept> recepti = ucitajRecepte();
		
		boolean postoji = false;
		for (Recept recept : recepti) {
			if (recept.getSifra().equals(noviRecept.getSifra())) {
				postoji = true;
				break;
			}
		}
		
		if (postoji) {
			return false;
		}
		
		recepti.add(noviRecept);
		try {
			sacuvajNovoStanje(recepti);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	public boolean izmeniRecept(Recept receptZaIzmenu, String staraSifra) {
		List<Recept> recepti = ucitajRecepte();
		
		int indeksPronadjenog = -1;
		for (int i = 0; i < recepti.size(); i++) {
			Recept recept = recepti.get(i);
			if (recept.getSifra().equals(staraSifra)) {
				indeksPronadjenog = i;
				break;
			}
		}
		
		if (indeksPronadjenog == -1) {
			return false;
		}
		
		recepti.set(indeksPronadjenog, receptZaIzmenu);
		try {
			sacuvajNovoStanje(recepti);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	private void sacuvajNovoStanje(List<Recept> recepti) throws IOException {
		String listaLekova = gson.toJson(recepti);
	     
	    BufferedWriter writer = new BufferedWriter(new FileWriter(direktorijum + receptiJson));
	    writer.write(listaLekova);
	    writer.close();
	}

}
