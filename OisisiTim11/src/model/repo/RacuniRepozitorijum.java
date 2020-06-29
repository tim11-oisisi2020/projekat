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

import model.Racun;

public class RacuniRepozitorijum {
	
	private final String racuniJson;
	private final String direktorijum;
	private final Gson gson;
	
	public RacuniRepozitorijum(Gson gson, String direktorijum) {
		this.gson = gson;
		this.direktorijum = direktorijum;
		this.racuniJson = "racuni.json";
	}
	
	
	public List<Racun> ucitajRacune() {
		List<Racun> recepti = new ArrayList<Racun>();
		
		try {
			java.lang.reflect.Type racunType = new TypeToken<List<Racun>>(){}.getType();
			recepti = gson.fromJson(new FileReader(direktorijum + racuniJson), racunType);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return recepti;
	}
	
	public boolean insertujRacun(Racun noviRacun) {
		List<Racun> racuni = ucitajRacune();
		
		racuni.add(noviRacun);
		try {
			sacuvajNovoStanje(racuni);
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
	
	private void sacuvajNovoStanje(List<Racun> racuni) throws IOException {
		String listaRacuna = gson.toJson(racuni);
	     
	    BufferedWriter writer = new BufferedWriter(new FileWriter(direktorijum + racuniJson));
	    writer.write(listaRacuna);
	    writer.close();
	}
}
