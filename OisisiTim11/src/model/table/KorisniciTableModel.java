package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Korisnik;

public class KorisniciTableModel extends AbstractTableModel{
	
	private List<Korisnik> korisnici;
	private String[] kolone = {"Korisnicko ime", "Ime", "Prezime", "Tip korisnika"};
	
	public KorisniciTableModel(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		
		return this.korisnici.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Korisnik korisnik = korisnici.get(row);

		switch (col) {
			case 0:
				return korisnik.getKorisnickoIme();
			case 1:
				return korisnik.getIme();
			case 2:
				return korisnik.getPrezime();
			case 3:
				return korisnik.getTipKorisnika().name();
			default:
				return "";
		}
	}
	
	public void iscrtajTabeluSaKorisnicima(List<Korisnik> korisnici) {
		this.korisnici.clear();
		this.korisnici.addAll(korisnici);
		this.fireTableDataChanged();
	}
	
	public Korisnik nadjiKorisnika(int row) {
		return korisnici.get(row);
	}

	public String[] getKolone() {
		return kolone;
	}
	
	public String getColumnName(int col) {
		return kolone[col];
	}
}