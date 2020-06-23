package controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.MainFrame;

public class LekoviClickAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Color dugmePozadina = MainFrame.getInstance().getDugmeZelena();
		Color akcenatCrvena = MainFrame.getInstance().getAkcenatCrvena();
		
		JButton lekoviDugme = MainFrame.getInstance().getMainPanel().getLekoviDugme();
		lekoviDugme.setBackground(akcenatCrvena);
		
		JButton receptiDugme = MainFrame.getInstance().getMainPanel().getReceptiDugme();
		receptiDugme.setBackground(dugmePozadina);
		
		JButton korisniciDugme = MainFrame.getInstance().getMainPanel().getKorisniciDugme();
		korisniciDugme.setBackground(dugmePozadina);
		
		JButton izvestajDugme = MainFrame.getInstance().getMainPanel().getIzvestajDugme();
		izvestajDugme.setBackground(dugmePozadina);
		
		JButton korpaDugme = MainFrame.getInstance().getMainPanel().getKorpaDugme();
		korpaDugme.setBackground(dugmePozadina);
		
		JPanel tabelarniPrikazi = MainFrame.getInstance().getMainPanel().getTabelarniPrikaziCard();
		
		CardLayout cl = (CardLayout)(tabelarniPrikazi.getLayout());
	    cl.show(tabelarniPrikazi, "LEKOVI_PANEL");
	    
	}

}
