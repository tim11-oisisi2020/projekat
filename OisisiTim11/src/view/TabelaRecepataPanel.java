package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.TabeleSearchActions;
import model.Recept;
import model.table.ReceptiTableModel;

public class TabelaRecepataPanel extends JPanel{
	
	private ReceptiTableModel tableModel;
	private JTable tabelaRecepta;

	public TabelaRecepataPanel() {
		JLabel wellcomeMessage = new JLabel();
		wellcomeMessage.setText("Tabela Recepata");
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
		List<Recept> recepti = MainFrame.getInstance().getReceptiRepozitorijum().ucitajRecepte();

		this.tableModel = new ReceptiTableModel(recepti);

		this.tabelaRecepta = new JTable(this.tableModel);

		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.tableModel);

		this.tabelaRecepta.setRowSorter(sorter);

		// Create Combo box for search
		final JComboBox<String> searchableColumnsCb = new JComboBox<String>(Recept.getTableHeader());
		searchableColumnsCb.setVisible(true);

		// Create input
		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(150, 25));  
		
		// Set actions
		TabeleSearchActions lekoviSearchActions = new TabeleSearchActions(searchField, searchableColumnsCb, sorter);

		searchField.addKeyListener(lekoviSearchActions.processKeyReleased());
		searchableColumnsCb.addActionListener(lekoviSearchActions.processSelection());
		
		// Pack GUI
		panel.add(searchableColumnsCb);
		panel.add(searchField);
		panel.add(new JScrollPane(tabelaRecepta));
		this.add(panel);
	}
}
