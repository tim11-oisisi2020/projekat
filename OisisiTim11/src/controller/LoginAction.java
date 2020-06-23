package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Korisnik;
import view.MainFrame;

public class LoginAction implements ActionListener {
	
	private JTextField korisnickoImePolje;
	private JTextField lozinkaPolje;
	
	public LoginAction(JTextField korisnickoImePolje, JTextField lozinkaPolje) {
		this.korisnickoImePolje = korisnickoImePolje;
		this.lozinkaPolje = lozinkaPolje;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame mf = MainFrame.getInstance();
		if (mf.getLoginFrame().getBrojLogovanja() >= 3) {
			JOptionPane.showMessageDialog(MainFrame.getInstance().getLoginFrame(), "Uneli ste nevalidne kredencijale vise od 3 puta. ", "Upozorenje", JOptionPane.WARNING_MESSAGE);
			mf.getLoginFrame().setVisible(false);
			return;
		}
		
		String korisnickoIme = korisnickoImePolje.getText();
		String lozinka = lozinkaPolje.getText();
		
		List<Korisnik> korisnici = mf.getKorisnikRepozitorijum().ucitajKorisnike();
		
		boolean postoji = false;
		for (Korisnik korisnik : korisnici) {
			postoji = korisnik.getKorisnickoIme().equals(korisnickoIme) && korisnik.getLozinka().equals(lozinka);
			if (postoji) {
				mf.setAktivniKorisnik(korisnik.getKorisnickoIme());
				mf.setTipKorisnika(korisnik.getTipKorisnika());
				mf.sakrijLoginFrame();
				return;
			}
		}
		
		if (!postoji) {
			mf.getLoginFrame().inkrementirajBrojLogovanja();
		}
		
		JOptionPane.showMessageDialog(MainFrame.getInstance().getLoginFrame(), "Korisnicko ime ili lozinka nisu ispravni", "Upozorenje", JOptionPane.WARNING_MESSAGE);
	}

}
