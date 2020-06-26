package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Lek;
import model.repo.LekoviRepozitorijum;
import view.MainFrame;
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
		boolean uspesno = lekoviRepozitorijum.insertujLek(noviLek);
		
		if (!uspesno) {
			String poruka = "Cuvanje novog leka nije uspesno.";
			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
		} else {
			dodajLekDialog.setVisible(false);
		}
		
	}

}
