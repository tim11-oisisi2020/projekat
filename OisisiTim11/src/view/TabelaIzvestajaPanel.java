package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Racun;
import model.table.IzvestajiTableModel;

public class TabelaIzvestajaPanel extends JPanel {
	
	public IzvestajiTableModel tableModel;
	public JTable tabelaRacuna;
	public JPanel panelIzvestaja;
	
	public JPanel buttonBox;
	public JLabel ukupnaCenaLabel = new JLabel("Ukupna zarada: ");
	
	public float ukupnaZarada = 0;
	
	public TabelaIzvestajaPanel() {	
		
		this.setBackground(MainFrame.getInstance().getZelenaPozadina());
		
		this.addTable();
		this.ukupnaZarada();
		this.addBottomPanel();	
		
	}
	
	private void addTable() {
		this.panelIzvestaja = new JPanel();
		
		List<Racun> racuni = MainFrame.getInstance().getRacuniRepozitorijum().ucitajRacune();
		
		this.tableModel = new IzvestajiTableModel(racuni);
		this.tabelaRacuna = new JTable(this.tableModel);
		
		JScrollPane scrollPane = new JScrollPane(tabelaRacuna);
		scrollPane.setPreferredSize(new Dimension(600, 500));
		
		this.panelIzvestaja.add(scrollPane);
		this.add(this.panelIzvestaja);
	}
	
	public IzvestajiTableModel getTableModel() {
		this.ukupnaZarada();
		return tableModel;
	}
	
	public void ukupnaZarada() {	
		
		float ukupnaZaradaTemp = 0;
		
		for (int i = 0; i < this.tabelaRacuna.getRowCount(); i++) {
			ukupnaZaradaTemp = ukupnaZaradaTemp + (float) this.tabelaRacuna.getValueAt(i, 1);
		}
		
		this.ukupnaZarada = ukupnaZaradaTemp;
		
		this.ukupnaCenaLabel.setText("Ukupna zarada: " + ukupnaZaradaTemp + " RSD");
		
	}
	
	private void addBottomPanel() {
		this.buttonBox = new JPanel();
		this.buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		this.buttonBox.setPreferredSize(new Dimension(100, 100));
		this.buttonBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		//this.ukupnaCenaLabel = new J
		this.ukupnaCenaLabel.setText("Ukupna zarada: " + this.ukupnaZarada + " RSD");
		
		this.ukupnaCenaLabel.setPreferredSize(new Dimension(250, 25));
		this.buttonBox.add(this.ukupnaCenaLabel);
		
		this.buttonBox.setPreferredSize(new Dimension(600, 150));
		this.add(this.buttonBox, BorderLayout.SOUTH);
	}

}