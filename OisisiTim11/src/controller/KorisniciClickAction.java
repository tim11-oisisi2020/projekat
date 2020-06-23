package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.MainFrame;

public class KorisniciClickAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Color dugmePozadina = MainFrame.getInstance().getDugmeZelena();
		Color akcenatCrvena = MainFrame.getInstance().getAkcenatCrvena();
		
		JButton lekoviDugme = MainFrame.getInstance().getMainPanel().getLekoviDugme();
		lekoviDugme.setBackground(dugmePozadina);
		
		JButton receptiDugme = MainFrame.getInstance().getMainPanel().getReceptiDugme();
		receptiDugme.setBackground(dugmePozadina);
		
		JButton korisniciDugme = MainFrame.getInstance().getMainPanel().getKorisniciDugme();
		korisniciDugme.setBackground(akcenatCrvena);
		
		JButton izvestajDugme = MainFrame.getInstance().getMainPanel().getIzvestajDugme();
		izvestajDugme.setBackground(dugmePozadina);
		
		JButton korpaDugme = MainFrame.getInstance().getMainPanel().getKorpaDugme();
		korpaDugme.setBackground(dugmePozadina);
		
		JPanel tabelarniPrikazi = MainFrame.getInstance().getMainPanel().getTabelarniPrikaziCard();
		
		CardLayout cl = (CardLayout)(tabelarniPrikazi.getLayout());
	    cl.show(tabelarniPrikazi, "KORISNICI_PANEL");
		
	}

}
