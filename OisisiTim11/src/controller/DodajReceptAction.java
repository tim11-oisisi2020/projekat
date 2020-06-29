package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Lek;
import model.Recept;
import model.repo.ReceptiRepozitorijum;
import view.MainFrame;
import view.TabelaRecepataPanel;
import view.dialog.DodajReceptDialog;

public class DodajReceptAction implements ActionListener {

	private DodajReceptDialog dodajReceptDialog;
	private Lek lek;
	
	List<Lek> drugs = MainFrame.getInstance().getLekRepozitorijum().ucitajLekove();
	
	public DodajReceptAction(DodajReceptDialog dodajReceptDialog) {
		this.dodajReceptDialog = dodajReceptDialog;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String datum = dodajReceptDialog.getDatumPolje().getText();
		String sifra = dodajReceptDialog.getSifraPolje().getText();
		String lekar = dodajReceptDialog.getLekarPolje().getText();
		String jmbg = dodajReceptDialog.getjmbgPolje().getText();
		
		String lekoviTemp = dodajReceptDialog.getLekoviPolje().getText();
		String delioc = ", ";
		String[] lekoviArray = lekoviTemp.split(delioc);
		
		List<Lek> lekoviList = new ArrayList<Lek>();
		
		for (String lekSingle : lekoviArray) {
			for (Lek lek : drugs) {
				if (lek.getSifra().equals(lekSingle)) {
					lekoviList.add(lek);
				}
			}
		}
		
		Lek[] lekovi = new Lek[lekoviList.size()];
		lekovi = lekoviList.toArray(lekovi);
		
		Recept noviRecept = new Recept(datum, sifra, lekar, jmbg, lekovi);
		
		ReceptiRepozitorijum receptiRepozitorijum = MainFrame.getInstance().getReceptiRepozitorijum();
		boolean uspesno = false;
		
		if (dodajReceptDialog.getRecept() == null) {
			uspesno = receptiRepozitorijum.insertujRecept(noviRecept);
		}
		
		if (!uspesno) {
			String poruka = "Cuvanje novog recepta nije uspesno";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
		} else {
			dodajReceptDialog.setVisible(false);
			JPanel selektovaniPanel = MainFrame.getInstance().getMainPanel().vratiTrenutnoPrikazanuTabelaPanel();
			
			if (selektovaniPanel != null && selektovaniPanel instanceof TabelaRecepataPanel) {
				TabelaRecepataPanel tabelaRecepataPanel = (TabelaRecepataPanel) selektovaniPanel;
				List<Recept> recepti = receptiRepozitorijum.ucitajRecepte();
				tabelaRecepataPanel.getTableModel().forceDrugTableRefresh(recepti);
			} else {
				String poruka = "Ponovno popunjavanje tabele neuspesno.";
				JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
			}
			
		}
	}
	
}
