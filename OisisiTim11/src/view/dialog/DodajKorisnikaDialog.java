package view.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DodajIzmeniKorisnikaAction;
import model.Korisnik;
import model.TipKorisnika;
import view.MainFrame;

public class DodajKorisnikaDialog extends JDialog {
	
	private Korisnik korisnik;
	
	private JTextField korisnickoImePolje;
	private JTextField lozinkaPolje;
	private JTextField imePolje;
	private JTextField prezimePolje;
	private JComboBox<String> tipKorisnikaComboBox;
	
	public DodajKorisnikaDialog(Korisnik korisnik) {
		super(MainFrame.getInstance());
		this.korisnik = korisnik;
		
		this.setSize(new Dimension(450, 600));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		Color pozadina = MainFrame.getInstance().getZelenaPozadina();
		
		JPanel gornjiPanel = new JPanel(new BorderLayout());
		gornjiPanel.setPreferredSize(new Dimension(1000, 70));
		gornjiPanel.setBackground(pozadina);
		
		JLabel naslov = new JLabel("Unesite novog korisnika");
		naslov.setFont(new Font("Serif", Font.BOLD, 22));
		naslov.setHorizontalAlignment(JLabel.CENTER);
		naslov.setVerticalAlignment(JLabel.CENTER);
		gornjiPanel.add(naslov);
		
		JPanel glavniFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		glavniFlowPanel.setBackground(pozadina);
		
		//sifra
		JPanel korisnickoImePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		korisnickoImePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		korisnickoImePanel.setPreferredSize(new Dimension(400, 50));
		korisnickoImePanel.setBackground(pozadina);
		
		JLabel korisnickoImeLabela = new JLabel("Korisn. ime");
		korisnickoImeLabela.setFont(new Font("Serif", Font.BOLD, 14));
		korisnickoImeLabela.setPreferredSize(new Dimension(100, 30));
		korisnickoImePolje = new JTextField();
		korisnickoImePolje.setPreferredSize(new Dimension(200, 30));
		
		korisnickoImePanel.add(korisnickoImeLabela);
		korisnickoImePanel.add(korisnickoImePolje);
		
		//lozinka
		JPanel lozinkaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		lozinkaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lozinkaPanel.setPreferredSize(new Dimension(400, 50));
		lozinkaPanel.setBackground(pozadina);
		
		JLabel lozinkaLabela = new JLabel("Lozinka");
		lozinkaLabela.setFont(new Font("Serif", Font.BOLD, 14));
		lozinkaLabela.setPreferredSize(new Dimension(100, 30));
		lozinkaPolje = new JTextField();
		lozinkaPolje.setPreferredSize(new Dimension(200, 30));
		
		lozinkaPanel.add(lozinkaLabela);
		lozinkaPanel.add(lozinkaPolje);
		
		//ime
		JPanel imePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		imePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		imePanel.setPreferredSize(new Dimension(400, 50));
		imePanel.setBackground(pozadina);
		
		JLabel imeLabela = new JLabel("Ime");
		imeLabela.setFont(new Font("Serif", Font.BOLD, 14));
		imeLabela.setPreferredSize(new Dimension(100, 30));
		imePolje = new JTextField();
		imePolje.setPreferredSize(new Dimension(200, 30));
		
		imePanel.add(imeLabela);
		imePanel.add(imePolje);
		
		//prezime
		JPanel prezimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		prezimePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		prezimePanel.setPreferredSize(new Dimension(400, 50));
		prezimePanel.setBackground(pozadina);
		
		JLabel prezimeLabela = new JLabel("Prezime");
		prezimeLabela.setFont(new Font("Serif", Font.BOLD, 14));
		prezimeLabela.setPreferredSize(new Dimension(100, 30));
		prezimePolje = new JTextField();
		prezimePolje.setPreferredSize(new Dimension(200, 30));
		
		prezimePanel.add(prezimeLabela);
		prezimePanel.add(prezimePolje);
		
		//tip korisnika
		JPanel tipKorisnikaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		tipKorisnikaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tipKorisnikaPanel.setPreferredSize(new Dimension(400, 50));
		tipKorisnikaPanel.setBackground(pozadina);
		
		JLabel tipKorisnikaLabela = new JLabel("Tip korisnika: ");
		tipKorisnikaLabela.setFont(new Font("Serif", Font.BOLD, 14));
		tipKorisnikaLabela.setPreferredSize(new Dimension(100, 30));
	
        String naReceptOpcije[] = {TipKorisnika.APOTEKAR.name(), TipKorisnika.LEKAR.name()};
        tipKorisnikaComboBox = new JComboBox<String>(naReceptOpcije); 
        tipKorisnikaComboBox.setPreferredSize(new Dimension(200, 30));
		
        tipKorisnikaPanel.add(tipKorisnikaLabela);
        tipKorisnikaPanel.add(tipKorisnikaComboBox);
				
		glavniFlowPanel.add(korisnickoImePanel);
		glavniFlowPanel.add(lozinkaPanel);
		glavniFlowPanel.add(imePanel);
		glavniFlowPanel.add(prezimePanel);
		glavniFlowPanel.add(tipKorisnikaPanel);
				
		JPanel buttonBox = new JPanel();
		buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonBox.setPreferredSize(new Dimension(1000, 70));
		buttonBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonBox.setBackground(pozadina);
		
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new DodajIzmeniKorisnikaAction(this));
		potvrdi.setPreferredSize(new Dimension(150, 50));
		buttonBox.add(potvrdi);
		
		JButton otkazi = new JButton("Otkazi");
		otkazi.setPreferredSize(new Dimension(150, 50));
		otkazi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		buttonBox.add(otkazi);
		
		//izmena je, popuni polja
		if (korisnik != null) {
			this.korisnickoImePolje.setText(korisnik.getKorisnickoIme());
			this.lozinkaPolje.setText(korisnik.getLozinka());
			this.imePolje.setText(korisnik.getPrezime());
			this.prezimePolje.setText(korisnik.getPrezime());
			this.tipKorisnikaComboBox.setSelectedItem(korisnik.getTipKorisnika().name());
		}
		
		this.add(gornjiPanel, BorderLayout.NORTH);
		this.add(glavniFlowPanel, BorderLayout.CENTER);
		this.add(buttonBox, BorderLayout.SOUTH);
		
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public JTextField getKorisnickoImePolje() {
		return korisnickoImePolje;
	}

	public JTextField getLozinkaPolje() {
		return lozinkaPolje;
	}

	public JTextField getImePolje() {
		return imePolje;
	}

	public JTextField getPrezimePolje() {
		return prezimePolje;
	}

	public JComboBox<String> getTipKorisnikaComboBox() {
		return tipKorisnikaComboBox;
	}

}
