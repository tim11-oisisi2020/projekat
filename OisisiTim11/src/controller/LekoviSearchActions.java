package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class LekoviSearchActions {
	
	private JTextField searchField;
	private JComboBox<String> searchableColumnsCb;
	private TableRowSorter<TableModel> sorter;
	
	public LekoviSearchActions(JTextField searchField, JComboBox<String> searchableColumnsCb, TableRowSorter<TableModel> sorter) {
		this.searchField = searchField;
		this.searchableColumnsCb = searchableColumnsCb;
		this.sorter = sorter;
	}


	public ActionListener processSelection () {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchField.setText("");
				sorter.setRowFilter(null);
			}
		};
	}
	
	public KeyAdapter processKeyReleased() {
		return new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				JTextField field = (JTextField) e.getSource();
				String text = field.getText();

				// (?i) set Regular Expression to be case insensitive
				sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, searchableColumnsCb.getSelectedIndex()));
			}

		};
	}

}
