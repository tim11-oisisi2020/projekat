package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Recept;

public class ReceptiTableModel extends AbstractTableModel {

	List<Recept> recepti;
	String nasloviKolona[] = Recept.getTableHeader();

	public ReceptiTableModel(List<Recept> recepti) {
		this.recepti = recepti;
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return recepti.size();
	}

	// This method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Recept recept = recepti.get(row);

		switch (column) {
			case 0:
				return recept.getDatum();
			case 1:
				return recept.getSifra();
			case 2:
				return recept.getLekar();
			case 3:
				return recept.getJmbgPacijenta();
			default:
				return "";
		}
	}
	
	public Recept nadjiRecpt(int row) {
		return recepti.get(row);
	}

	// This method will be used to display the name of columns
	public String getColumnName(int col) {
		return nasloviKolona[col];
	}
	
	public void forceDrugTableRefresh(List<Recept> recepti) {
		this.recepti.clear();
		this.recepti.addAll(recepti);
		this.fireTableDataChanged();
	}
}

