package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Racun;

public class IzvestajiTableModel extends AbstractTableModel {
	List<Racun> racuni;
	String nasloviKolona[] = Racun.getTableHeader();
	
	public IzvestajiTableModel(List<Racun> racuni) {
		this.racuni = racuni;
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}
	
	@Override
	public int getRowCount() {
		return racuni.size();
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		Racun racun = racuni.get(row);
		
		switch (column) {
			case 0:
				return racun.getLekovi();
			case 1:
				return racun.getUkupnaCena();
			default:
				return "";
		}
	}
	
	public void iscrtajTabeluSaRacunima(List<Racun> racuni) {
		this.racuni.clear();
		this.racuni.addAll(racuni);
		this.fireTableDataChanged();
	}
	
	public Racun nadjiRacun(int row) {
		return racuni.get(row);
	}
	
	public String getColumnName(int col) {
		return nasloviKolona[col];
	}
	
	public void forceIzvestajiTableRefresh(List<Racun> racuni) {
		this.racuni.clear();
		this.racuni.addAll(racuni);
		this.fireTableDataChanged();
	}
	
}
