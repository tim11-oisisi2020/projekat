package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Korisnik;
import model.Lek;
import model.repo.LekoviRepozitorijum;
import view.MainFrame;
import view.TabelaKorisnikaPanel;
import view.TabelaLekovaPanel;
import view.dialog.DodajLekDialog;

public class DodajIzmeniLekAction implements ActionListener{
	
	private DodajLekDialog dodajLekDialog;
	
	public DodajIzmeniLekAction(DodajLekDialog dodajLekDialog) {
		this.dodajLekDialog = dodajLekDialog;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String sifra = dodajLekDialog.getSifraPolje().getText();
		String ime = dodajLekDialog.getImePolje().getText();
		String proizvodjac = dodajLekDialog.getProizvodjacPolje().getText();
		
		String naReceptSelektovano = dodajLekDialog.getNaReceptComboBox().getSelectedItem().toString();
		boolean naRecept = false;
		if (naReceptSelektovano == "Da") {
			naRecept = true;
		}
		
		String cenaString = dodajLekDialog.getCenaPolje().getText();
		float cena = 0.0f;
		try {
			cena = Float.parseFloat(cenaString);
		} catch (Exception e) {
			String poruka = "Format cene ["+ cenaString +"] nije ispravan.";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
			return;
		}
		
		Lek noviLek = new Lek(sifra, ime, proizvodjac, naRecept, cena);
		
		LekoviRepozitorijum lekoviRepozitorijum = MainFrame.getInstance().getLekRepozitorijum();
		boolean uspesno;
		//ako je null onda je dodavanje, ako nije onda je izmena
		if (dodajLekDialog.getLek() == null) {
			uspesno = lekoviRepozitorijum.insertujLek(noviLek);
		}else {
			String staraSifra = dodajLekDialog.getLek().getSifra();
			uspesno = lekoviRepozitorijum.izmeniLek(noviLek, staraSifra);
			
		}
		if (!uspesno) {
			String poruka = "Cuvanje novog leka nije uspesno.";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
		} else {
			dodajLekDialog.setVisible(false);
			JPanel selektovaniPanel = MainFrame.getInstance().getMainPanel().vratiTrenutnoPrikazanuTabelaPanel();
			
			if (selektovaniPanel != null && selektovaniPanel instanceof TabelaLekovaPanel) {
				TabelaLekovaPanel tabelaLekovaPanel = (TabelaLekovaPanel) selektovaniPanel;
				List<Lek> lekovi = lekoviRepozitorijum.ucitajLekove();
				tabelaLekovaPanel.getTableModel().iscrtajTabeluSaLekovima(lekovi);
			} else {
				String poruka = "Ponovno popunjavanje tabele neuspesno.";
				JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
			}
		
		}
	}
}
