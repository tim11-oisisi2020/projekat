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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.DodajIzmeniLekAction;
import controller.DodajReceptAction;
import view.MainFrame;
import javafx.scene.control.DatePicker;
import model.Lek;
import model.Recept;

public class DodajReceptDialog extends JDialog {

	private Recept recept;
	
	private JTextField datumPolje;
	private JTextField sifraPolje;
	private JTextField lekarPolje;
	private JTextField jmbgPolje;
	private JTextField lekoviPolje;
	
	public DodajReceptDialog(Recept recept) {
		super(MainFrame.getInstance());
		this.recept = recept;
		
		this.setSize(new Dimension(450, 600));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		Color pozadina = MainFrame.getInstance().getZelenaPozadina();
		
		JPanel gornjiPanel = new JPanel(new BorderLayout());
		gornjiPanel.setPreferredSize(new Dimension(1000, 70));
		gornjiPanel.setBackground(pozadina);
		
		String naslovString = "Unesite novi recept";
		
		JLabel naslov = new JLabel(naslovString);
		naslov.setFont(new Font("Serif", Font.BOLD, 22));
		naslov.setHorizontalAlignment(JLabel.CENTER);
		naslov.setVerticalAlignment(JLabel.CENTER);
		gornjiPanel.add(naslov);
		
		JPanel glavniFlowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		glavniFlowPanel.setBackground(pozadina);
		
		// DATUM
		
		JPanel datumPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		datumPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		datumPanel.setPreferredSize(new Dimension(400, 50));
		datumPanel.setBackground(pozadina);
		
		JLabel datumLabel = new JLabel("Datum");
		datumLabel.setFont(new Font("Serif", Font.BOLD, 18));
		datumLabel.setPreferredSize(new Dimension(100, 30));
		datumPolje = new JTextField();
		datumPolje.setPreferredSize(new Dimension(200, 30));
		
		datumPanel.add(datumLabel);
		datumPanel.add(datumPolje);
		
		// SIFRA
		
		JPanel sifraPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		sifraPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		sifraPanel.setPreferredSize(new Dimension(400, 50));
		sifraPanel.setBackground(pozadina);
		
		JLabel sifraLabel = new JLabel("Sifra");
		sifraLabel.setFont(new Font("Serif", Font.BOLD, 18));
		sifraLabel.setPreferredSize(new Dimension(100, 30));
		sifraPolje = new JTextField();
		sifraPolje.setPreferredSize(new Dimension(200, 30));
		
		sifraPanel.add(sifraLabel);
		sifraPanel.add(sifraPolje);
		
		// LEKAR
		
		JPanel lekarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		lekarPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lekarPanel.setPreferredSize(new Dimension(400, 50));
		lekarPanel.setBackground(pozadina);
		
		JLabel lekarLabel = new JLabel("Lekar");
		lekarLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lekarLabel.setPreferredSize(new Dimension(100, 30));
		lekarPolje = new JTextField();
		lekarPolje.setPreferredSize(new Dimension(200, 30));
		
		lekarPanel.add(lekarLabel);
		lekarPanel.add(lekarPolje);
		
		// JMBG
		
		JPanel jmbgPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		jmbgPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		jmbgPanel.setPreferredSize(new Dimension(400, 50));
		jmbgPanel.setBackground(pozadina);
		
		JLabel jmbgLabel = new JLabel("JMBG");
		jmbgLabel.setFont(new Font("Serif", Font.BOLD, 18));
		jmbgLabel.setPreferredSize(new Dimension(100, 30));
		jmbgPolje = new JTextField();
		jmbgPolje.setPreferredSize(new Dimension(200, 30));
		
		jmbgPanel.add(jmbgLabel);
		jmbgPanel.add(jmbgPolje);
		
		// LEKOVI
		
		JPanel lekoviPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		lekoviPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lekoviPanel.setPreferredSize(new Dimension(400, 50));
		lekoviPanel.setBackground(pozadina);
		
		JLabel lekoviLabel = new JLabel("Sifra leka");
		lekoviLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lekoviLabel.setPreferredSize(new Dimension(100, 30));
		lekoviPolje = new JTextField();
		lekoviPolje.setPreferredSize(new Dimension(200, 30));
		
		lekoviPanel.add(lekoviLabel);
		lekoviPanel.add(lekoviPolje);
		
		// GLAVMNI PANEL ADD
		
		glavniFlowPanel.add(datumPanel);
		glavniFlowPanel.add(sifraPanel);
		glavniFlowPanel.add(lekarPanel);
		glavniFlowPanel.add(jmbgPanel);
		glavniFlowPanel.add(lekoviPanel);
		
		JPanel buttonBox = new JPanel();
		buttonBox.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonBox.setPreferredSize(new Dimension(1000, 70));
		buttonBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonBox.setBackground(pozadina);
		
		JButton potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new DodajReceptAction(this));
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
		
		this.add(gornjiPanel, BorderLayout.NORTH);
		this.add(glavniFlowPanel, BorderLayout.CENTER);
		this.add(buttonBox, BorderLayout.SOUTH);
	}
	
	public Recept getRecept() {
		return recept;
	}
	
	public JTextField getDatumPolje() {
		return datumPolje;
	}
	
	public JTextField getSifraPolje() {
		return sifraPolje;
	}
	
	public JTextField getLekarPolje() {
		return lekarPolje;
	}
	public JTextField getjmbgPolje() {
		return jmbgPolje;
	}
	
	public JTextField getLekoviPolje() {
		return lekoviPolje;
	}
	
}
