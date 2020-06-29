package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.dialog.DodajLekDialog;
import view.dialog.DodajReceptDialog;
import controller.TabeleSearchActions;
import model.Lek;
import model.Recept;
import model.table.DrugsTableModel;
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
		//this.add(wellcomeMessage);
		
		this.addTable();
		this.addBottomPanel();
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
		
		JScrollPane scrollPane = new JScrollPane(tabelaRecepta);
		scrollPane.setPreferredSize(new Dimension(600, 500));
		
		
		// Pack GUI
		panel.add(searchableColumnsCb);
		panel.add(searchField);
		panel.add(scrollPane);
		this.add(panel);
	}
	
	private void addBottomPanel() {
		JPanel buttonBox = new JPanel();
		buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		buttonBox.setPreferredSize(new Dimension(100, 100));
		buttonBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JButton insertujRecept = new JButton("Insertuj Recept");
		insertujRecept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajReceptDialog dodajReceptDialog = new DodajReceptDialog(null);
				dodajReceptDialog.setVisible(true);
			}
			
		});
		
		insertujRecept.setPreferredSize(new Dimension(150, 50));
		buttonBox.add(insertujRecept);
		
		buttonBox.setPreferredSize(new Dimension(600, 150));
		this.add(buttonBox, BorderLayout.SOUTH);
	}
	
	public ReceptiTableModel getTableModel() {
		return tableModel;
	}
	
}
