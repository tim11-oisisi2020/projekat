package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.LekoviSearchActions;
import model.Lek;
import model.table.DrugsTableModel;

import javax.swing.JScrollPane;

public class TabelaLekovaPanel extends JPanel {
	private TableModel model;

	public TabelaLekovaPanel() {
		JLabel wellcomeMessage = new JLabel();
		wellcomeMessage.setText("Tabela Lekova");
		wellcomeMessage.setFont(new Font("Serif", Font.BOLD, 40));
		wellcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		wellcomeMessage.setVerticalAlignment(JLabel.CENTER);

		this.setBackground(MainFrame.getInstance().getZelenaPozadina());
		this.add(wellcomeMessage);

		this.addTable();
	}

	private void addTable() {
		JPanel panel = new JPanel();

		// Create table
		List<Lek> drugs = MainFrame.getInstance().getLekRepozitorijum().ucitajLekove();

		this.model = new DrugsTableModel(drugs);

		final JTable table = new JTable(this.model);

		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.model);

		table.setRowSorter(sorter);

		// Create Combo box for search
		final JComboBox<String> searchableColumnsCb = new JComboBox<String>(Lek.getTableHeader());
		searchableColumnsCb.setVisible(true);

		// Create input
		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(150, 25));  
		
		// Set actions
		LekoviSearchActions lekoviSearchActions = new LekoviSearchActions(searchField, searchableColumnsCb, sorter);

		searchField.addKeyListener(lekoviSearchActions.processKeyReleased());
		searchableColumnsCb.addActionListener(lekoviSearchActions.processSelection());
		
		// Pack GUI
		panel.add(searchableColumnsCb);
		panel.add(searchField);
		panel.add(new JScrollPane(table));
		this.add(panel);
	}

}

