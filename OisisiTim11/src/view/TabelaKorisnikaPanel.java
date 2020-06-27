package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.TabeleSearchActions;
import model.Korisnik;
import model.table.KorisniciTableModel;
import view.dialog.DodajKorisnikaDialog;

public class TabelaKorisnikaPanel extends JPanel {
	
	private KorisniciTableModel tableModel;
	private JTable tabelaKorisnika;
	
	public TabelaKorisnikaPanel() {
		this.setLayout(new BorderLayout());
		Color pozadina = MainFrame.getInstance().getZelenaPozadina();
		List<Korisnik> korisnici = MainFrame.getInstance().getKorisnikRepozitorijum().ucitajKorisnike();
		this.tableModel = new KorisniciTableModel(korisnici);
		
		this.dodajGornjiPanel(pozadina);
		this.dodajTabeluKorisnika(pozadina, korisnici);
		this.dodajDonjiPanel(pozadina);
	}
	
	private void dodajTabeluKorisnika(Color pozadina, List<Korisnik> korisnici) {
		JPanel glavniFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		glavniFlowPanel.setBackground(pozadina);
		
		JPanel pretragaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pretragaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pretragaPanel.setPreferredSize(new Dimension(600, 50));
		pretragaPanel.setBackground(pozadina);
		
		JComboBox<String> parametarPretrageComboBox = new JComboBox<String>(tableModel.getKolone());
		parametarPretrageComboBox.setVisible(true);
		parametarPretrageComboBox.setPreferredSize(new Dimension(150, 30));

		JTextField pretragaPolje = new JTextField();
		pretragaPolje.setPreferredSize(new Dimension(150, 30));
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.tableModel);
		TabeleSearchActions tableSearchActions = new TabeleSearchActions(pretragaPolje, parametarPretrageComboBox, sorter);
		pretragaPolje.addKeyListener(tableSearchActions.processKeyReleased());
		parametarPretrageComboBox.addActionListener(tableSearchActions.processSelection());
		
		pretragaPanel.add(parametarPretrageComboBox);
		pretragaPanel.add(pretragaPolje);
		
		tabelaKorisnika = new JTable(this.tableModel);
		tabelaKorisnika.setPreferredSize(new Dimension(400, 400));
		tabelaKorisnika.setRowSorter(sorter);

		glavniFlowPanel.add(pretragaPanel);
		glavniFlowPanel.add(new JScrollPane(tabelaKorisnika));
		this.add(glavniFlowPanel);
	}
	
	private void dodajGornjiPanel(Color pozadina) {
		JPanel gornjiPanel = new JPanel(new BorderLayout());
		gornjiPanel.setPreferredSize(new Dimension(1000, 70));
		gornjiPanel.setBackground(pozadina);
		
		JLabel naslov = new JLabel("Korisnici");
		naslov.setFont(new Font("Serif", Font.BOLD, 22));
		naslov.setHorizontalAlignment(JLabel.CENTER);
		naslov.setVerticalAlignment(JLabel.CENTER);
		gornjiPanel.add(naslov);
		
		this.add(gornjiPanel, BorderLayout.NORTH);
	}
	
	private void dodajDonjiPanel(Color pozadina) {
		JPanel dugmiciBox = new JPanel();
		dugmiciBox.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
		dugmiciBox.setPreferredSize(new Dimension(100, 100));
		dugmiciBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		dugmiciBox.setBackground(pozadina);
		
		JButton insertujKorisnika = new JButton("Insertuj Korisnika");
		insertujKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajKorisnikaDialog dodajKorisnikaDialog = new DodajKorisnikaDialog(null);
				dodajKorisnikaDialog.setVisible(true);
			}
		});
		insertujKorisnika.setPreferredSize(new Dimension(150, 50));
		dugmiciBox.add(insertujKorisnika);
		
		JButton editujKorisnika = new JButton("Izmeni Korisnika");
		editujKorisnika.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selektovaniIndeks = tabelaKorisnika.getSelectedRow();
				Korisnik korisnik = tableModel.nadjiKorisnika(selektovaniIndeks);
				DodajKorisnikaDialog dodajKorisnikaDialog = new DodajKorisnikaDialog(korisnik);
				dodajKorisnikaDialog.setVisible(true);
			}
		});
		editujKorisnika.setPreferredSize(new Dimension(150, 50));
		dugmiciBox.add(editujKorisnika);
		
		this.add(dugmiciBox, BorderLayout.SOUTH);
	}

	public KorisniciTableModel getTableModel() {
		return tableModel;
	}

}
