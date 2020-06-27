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

import controller.DodajIzmeniLekAction;
import model.Korisnik;
import model.Lek;
import view.MainFrame;

public class DodajLekDialog extends JDialog {
	
	private Lek lek;	
	
	private JTextField sifraPolje;
	private JTextField imePolje;
	private JTextField proizvodjacPolje;
	private JTextField cenaPolje;
	private JComboBox<String> naReceptComboBox;
	
	public DodajLekDialog(Lek lek) {
		super(MainFrame.getInstance());
		this.lek = lek;
		
		this.setSize(new Dimension(450, 600));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		Color pozadina = MainFrame.getInstance().getZelenaPozadina();
		
		JPanel gornjiPanel = new JPanel(new BorderLayout());
		gornjiPanel.setPreferredSize(new Dimension(1000, 70));
		gornjiPanel.setBackground(pozadina);
		
		String naslovString = "Unesite novi lek";
		if (lek != null) {
			naslovString = "Izmenite lek";
		}
		JLabel naslov = new JLabel(naslovString);
		naslov.setFont(new Font("Serif", Font.BOLD, 22));
		naslov.setHorizontalAlignment(JLabel.CENTER);
		naslov.setVerticalAlignment(JLabel.CENTER);
		gornjiPanel.add(naslov);
		
		JPanel glavniFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		glavniFlowPanel.setBackground(pozadina);
		
		//sifra
		JPanel sifraPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		sifraPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		sifraPanel.setPreferredSize(new Dimension(400, 50));
		sifraPanel.setBackground(pozadina);
		
		JLabel sifraLabela = new JLabel("Sifra");
		sifraLabela.setFont(new Font("Serif", Font.BOLD, 18));
		sifraLabela.setPreferredSize(new Dimension(100, 30));
		sifraPolje = new JTextField();
		sifraPolje.setPreferredSize(new Dimension(200, 30));
		
		sifraPanel.add(sifraLabela);
		sifraPanel.add(sifraPolje);
		
		//ime
		JPanel imePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		imePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		imePanel.setPreferredSize(new Dimension(400, 50));
		imePanel.setBackground(pozadina);
		
		JLabel imeLabela = new JLabel("Ime");
		imeLabela.setFont(new Font("Serif", Font.BOLD, 18));
		imeLabela.setPreferredSize(new Dimension(100, 30));
		imePolje = new JTextField();
		imePolje.setPreferredSize(new Dimension(200, 30));
		
		imePanel.add(imeLabela);
		imePanel.add(imePolje);
		
		//proizvodjac
		JPanel proizvodjacPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		proizvodjacPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		proizvodjacPanel.setPreferredSize(new Dimension(400, 50));
		proizvodjacPanel.setBackground(pozadina);
		
		JLabel proizvodjacLabela = new JLabel("Proizvodjac");
		proizvodjacLabela.setFont(new Font("Serif", Font.BOLD, 18));
		proizvodjacLabela.setPreferredSize(new Dimension(100, 30));
		proizvodjacPolje = new JTextField();
		proizvodjacPolje.setPreferredSize(new Dimension(200, 30));
		
		proizvodjacPanel.add(proizvodjacLabela);
		proizvodjacPanel.add(proizvodjacPolje);
		
		//na recept
		JPanel naReceptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		naReceptPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		naReceptPanel.setPreferredSize(new Dimension(400, 50));
		naReceptPanel.setBackground(pozadina);
		
		JLabel naReceptLabela = new JLabel("Na recept?");
		naReceptLabela.setFont(new Font("Serif", Font.BOLD, 18));
		naReceptLabela.setPreferredSize(new Dimension(100, 30));
	
        String naReceptOpcije[] = { "Da", "Ne" };
        naReceptComboBox = new JComboBox<String>(naReceptOpcije); 
        naReceptComboBox.setPreferredSize(new Dimension(200, 30));
		
        naReceptPanel.add(naReceptLabela);
        naReceptPanel.add(naReceptComboBox);
        
		//cena
		JPanel cenaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		cenaPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		cenaPanel.setPreferredSize(new Dimension(400, 50));
		cenaPanel.setBackground(pozadina);
		
		JLabel cenaLabela = new JLabel("Cena");
		cenaLabela.setFont(new Font("Serif", Font.BOLD, 18));
		cenaLabela.setPreferredSize(new Dimension(100, 30));
		cenaPolje = new JTextField();
		cenaPolje.setPreferredSize(new Dimension(200, 30));
		
		cenaPanel.add(cenaLabela);
		cenaPanel.add(cenaPolje);
				
		glavniFlowPanel.add(sifraPanel);
		glavniFlowPanel.add(imePanel);
		glavniFlowPanel.add(proizvodjacPanel);
		glavniFlowPanel.add(naReceptPanel);
		glavniFlowPanel.add(cenaPanel);
				
		JPanel buttonBox = new JPanel();
		buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonBox.setPreferredSize(new Dimension(1000, 70));
		buttonBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonBox.setBackground(pozadina);
		
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new DodajIzmeniLekAction(this));
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
		
		if (lek != null) {
			this.sifraPolje.setText(lek.getSifra());
			this.imePolje.setText(lek.getIme());
			this.proizvodjacPolje.setText(lek.getProizvodjac());
			boolean naRecept = lek.isNaRecept();
			if (naRecept) {
				this.naReceptComboBox.setSelectedItem("Da");
			}else {
				this.naReceptComboBox.setSelectedItem("Ne");
			}
			
			this.cenaPolje.setText(""+lek.getCena());
		}
		
		this.add(gornjiPanel, BorderLayout.NORTH);
		this.add(glavniFlowPanel, BorderLayout.CENTER);
		this.add(buttonBox, BorderLayout.SOUTH);
	}

	public Lek getLek() {
		return lek;
	}



	public JTextField getSifraPolje() {
		return sifraPolje;
	}

	public JTextField getImePolje() {
		return imePolje;
	}

	public JTextField getProizvodjacPolje() {
		return proizvodjacPolje;
	}

	public JTextField getCenaPolje() {
		return cenaPolje;
	}

	public JComboBox<String> getNaReceptComboBox() {
		return naReceptComboBox;
	}
	
	
}
