package model.repo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
}
