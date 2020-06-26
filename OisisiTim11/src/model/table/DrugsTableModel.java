package model.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Lek;

public class DrugsTableModel extends AbstractTableModel {

	List<Lek> drugs;
	String headerList[] = Lek.getTableHeader();

	public DrugsTableModel(List<Lek> drugs) {
		this.drugs = drugs;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return drugs.size();
	}

	// This method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Lek medicine = drugs.get(row);

		switch (column) {
			case 0:
				return medicine.getSifra();
			case 1:
				return medicine.getIme();
			case 2:
				return medicine.getProizvodjac();
			case 3:
				return medicine.isNaRecept();
			case 4:
				return medicine.getCena();
			default:
				return "";
		}
	}

	// This method will be used to display the name of columns
	public String getColumnName(int col) {
		return headerList[col];
	}
}

