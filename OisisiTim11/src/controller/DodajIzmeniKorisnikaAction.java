package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Korisnik;
import model.TipKorisnika;
import model.repo.KorisnikRepozitorijum;
import view.MainFrame;
import view.TabelaKorisnikaPanel;
import view.dialog.DodajKorisnikaDialog;

public class DodajIzmeniKorisnikaAction implements ActionListener{

	private DodajKorisnikaDialog dodajKorisnikaDialog;
	
	public DodajIzmeniKorisnikaAction (DodajKorisnikaDialog dodajKorisnikaDialog) {
		this.dodajKorisnikaDialog = dodajKorisnikaDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String korisnickoIme = dodajKorisnikaDialog.getKorisnickoImePolje().getText();
		String lozinka = dodajKorisnikaDialog.getLozinkaPolje().getText();
		String ime = dodajKorisnikaDialog.getImePolje().getText();
		String prezime = dodajKorisnikaDialog.getPrezimePolje().getText();
		String tipKorisnikaString = dodajKorisnikaDialog.getTipKorisnikaComboBox().getSelectedItem().toString();
		
		boolean unosiValidni = korisnickoIme != null && korisnickoIme.length() > 0
				&& lozinka != null && lozinka.length() > 0
				&& ime != null && ime.length() > 0
				&& prezime != null && ime.length() > 0
				&& tipKorisnikaString != null && tipKorisnikaString.length() > 0;
				
		if (!unosiValidni) {
			String poruka = "Parametri unosa nisu validni, proverite unete vrednosti.";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
			return;
		}
		
		TipKorisnika tipKorisnika;
		if (tipKorisnikaString.equals(TipKorisnika.APOTEKAR.name())) {
			tipKorisnika = TipKorisnika.APOTEKAR;
		} else {
			tipKorisnika = TipKorisnika.LEKAR;
		}
		
		Korisnik korisnik = new Korisnik(korisnickoIme, lozinka, ime, prezime, tipKorisnika);
		
		KorisnikRepozitorijum korisnikRepozitorijum = MainFrame.getInstance().getKorisnikRepozitorijum();
		boolean uspesno = true;
		
		// ako je null onda je dodavanje, ako nije onda je izmena
		if (dodajKorisnikaDialog.getKorisnik() == null) {
			uspesno = korisnikRepozitorijum.insertujKorisnika(korisnik);
		} else {
			String staroKorisnickoIme = dodajKorisnikaDialog.getKorisnik().getKorisnickoIme();
			uspesno = korisnikRepozitorijum.izmeniKorisnika(korisnik, staroKorisnickoIme);
		}
		
		if (!uspesno) {
			String poruka = "Cuvanje korisnika nije uspesno.";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
		} else {
			dodajKorisnikaDialog.setVisible(false);
			JPanel selektovaniPanel = MainFrame.getInstance().getMainPanel().vratiTrenutnoPrikazanuTabelaPanel();
			
			if (selektovaniPanel != null && selektovaniPanel instanceof TabelaKorisnikaPanel) {
				TabelaKorisnikaPanel tabelaKorisnikaPanel = (TabelaKorisnikaPanel) selektovaniPanel;
				List<Korisnik> korisnici = korisnikRepozitorijum.ucitajKorisnike();
				tabelaKorisnikaPanel.getTableModel().iscrtajTabeluSaKorisnicima(korisnici);
			} else {
				String poruka = "Ponovno popunjavanje tabele neuspesno.";
				JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
			}
		}
		
	}
	
	
}
