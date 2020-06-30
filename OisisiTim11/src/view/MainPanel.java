package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.IzvestajClickAction;
import controller.KorisniciClickAction;
import controller.KorpaClickAction;
import controller.LekoviClickAction;
import controller.ReceptiClickAction;
import model.TipKorisnika;

public class MainPanel extends JPanel {
	
	private JPanel tabelarniPrikaziCard;
	
	private JButton lekoviDugme;
	
	private JButton receptiDugme;
	
	private JButton korisniciDugme;
	
	private JButton izvestajDugme;
	
	private JButton korpaDugme;

	public MainPanel() {
		this.setBackground(new Color(204, 238, 255));
		this.setLayout(new BorderLayout());
		
		TipKorisnika tipKorisnika = MainFrame.getInstance().getTipKorisnika();
		
		JPanel glavniToolbar = new JPanel();
		glavniToolbar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
		glavniToolbar.setPreferredSize(new Dimension(300, 1000));
		glavniToolbar.setBackground(new Color(190, 190, 190));
		glavniToolbar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 8));
		
		JPanel logoPanel = new JPanel();
		logoPanel.setPreferredSize(new Dimension(150, 150));
	
		ImagePanel panel = new ImagePanel(new ImageIcon(MainFrame.logoPutanja).getImage());
		
		logoPanel.add(panel);
		
		Color dugmePozadina = MainFrame.getInstance().getDugmeZelena();
		Color akcenatCrvena = MainFrame.getInstance().getAkcenatCrvena();
		
		lekoviDugme = new JButton();
		lekoviDugme.setBackground(akcenatCrvena);
		lekoviDugme.setText("Lekovi");
		lekoviDugme.setPreferredSize(new Dimension(200, 70));
		lekoviDugme.setFont(new Font("Serif", Font.BOLD, 22));
		lekoviDugme.addActionListener(new LekoviClickAction());
		
		receptiDugme = new JButton();
		receptiDugme.setBackground(dugmePozadina);
		receptiDugme.setText("Recepti");
		receptiDugme.setPreferredSize(new Dimension(200, 70));
		receptiDugme.setFont(new Font("Serif", Font.BOLD, 22));
		receptiDugme.addActionListener(new ReceptiClickAction());
		
		korisniciDugme = new JButton();
		korisniciDugme.setBackground(dugmePozadina);
		korisniciDugme.setText("Korisnici");
		korisniciDugme.setPreferredSize(new Dimension(200, 70));
		korisniciDugme.setFont(new Font("Serif", Font.BOLD, 22));
		korisniciDugme.addActionListener(new KorisniciClickAction());
		
		izvestajDugme = new JButton();
		izvestajDugme.setBackground(dugmePozadina);
		izvestajDugme.setText("Izvestaj");
		izvestajDugme.setPreferredSize(new Dimension(200, 70));
		izvestajDugme.setFont(new Font("Serif", Font.BOLD, 22));
		izvestajDugme.addActionListener(new IzvestajClickAction());
		
		korpaDugme = new JButton();
		korpaDugme.setBackground(dugmePozadina);
		korpaDugme.setText("Korpa");
		korpaDugme.setPreferredSize(new Dimension(200, 70));
		korpaDugme.setFont(new Font("Serif", Font.BOLD, 22));
		korpaDugme.addActionListener(new KorpaClickAction());
		
		glavniToolbar.add(logoPanel);
		glavniToolbar.add(lekoviDugme);
		glavniToolbar.add(receptiDugme);
		
		// korisnici trebaju biti prikazani samo administratorima
		if (tipKorisnika.equals(TipKorisnika.ADMINISTRATOR)) {
			glavniToolbar.add(korisniciDugme);
		}
		
		glavniToolbar.add(izvestajDugme);
		glavniToolbar.add(korpaDugme);
		
		tabelarniPrikaziCard = new JPanel(new CardLayout());
		
		//Vrednosti : LEKOVI_PANEL, RECEPTI_PANEL, KORISNICI_PANEL, IZVESTAJ_PANEL, KORPA_PANEL
		tabelarniPrikaziCard.add("LEKOVI_PANEL", new TabelaLekovaPanel());
		tabelarniPrikaziCard.add("RECEPTI_PANEL", new TabelaRecepataPanel());
		tabelarniPrikaziCard.add("KORISNICI_PANEL", new TabelaKorisnikaPanel());
		tabelarniPrikaziCard.add("IZVESTAJ_PANEL", new TabelaIzvestajaPanel());
		tabelarniPrikaziCard.add("KORPA_PANEL", new TabelaKorpaPanel());
		
		this.add(tabelarniPrikaziCard, BorderLayout.CENTER);
		this.add(glavniToolbar, BorderLayout.WEST);
		
	}

	public JButton getLekoviDugme() {
		return lekoviDugme;
	}

	public JButton getReceptiDugme() {
		return receptiDugme;
	}

	public JButton getKorisniciDugme() {
		return korisniciDugme;
	}

	public JButton getIzvestajDugme() {
		return izvestajDugme;
	}

	public JButton getKorpaDugme() {
		return korpaDugme;
	}

	public JPanel getTabelarniPrikaziCard() {
		return tabelarniPrikaziCard;
	}
	
	public JPanel vratiTrenutnoPrikazanuTabelaPanel() {
		JPanel selektovaniPanel = null;

	    for (Component panel : tabelarniPrikaziCard.getComponents() ) {
	        if (panel.isVisible() == true) {
	            selektovaniPanel = (JPanel) panel;
	        }
	    }

	    return selektovaniPanel;
	}
	
	public JPanel getPanelIzvestaja() {
		JPanel selektovaniPanel = null;
		
		Component component = tabelarniPrikaziCard.getComponent(3);
		
		selektovaniPanel = (JPanel) component;
		
		return selektovaniPanel;
	}
	
	
}

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel (String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		 this.img = img;
		 Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		 setPreferredSize(size);
		 setMinimumSize(size);
		 setMaximumSize(size);
		 setSize(size);
		 setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
