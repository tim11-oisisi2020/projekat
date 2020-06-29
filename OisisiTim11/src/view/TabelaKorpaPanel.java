package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

import model.Korisnik;
import model.Lek;
import model.Racun;
import model.Recept;
import model.repo.RacuniRepozitorijum;
import model.table.DrugsTableModel;

import com.sun.glass.events.MouseEvent;


public class TabelaKorpaPanel extends JPanel {
	public JTabbedPane tabKartica;
	
	public JPanel stanjePanel;
	public JPanel receptPanel;
	public JPanel bezReceptPanel;
	public DefaultTableModel model = new DefaultTableModel();
	
	public Lek lek;
	public Lek[] lekovi;
	
	public Korisnik korisnik;

	
	public TabelaKorpaPanel() {		
		this.setLayout(new BorderLayout());
		this.setBackground(MainFrame.getInstance().getZelenaPozadina());	
		
		this.glavniPanel();
	}
	
	private void glavniPanel() {		
		this.tabKartica = new JTabbedPane();
		
		this.addStanjePanel();
		this.addReceptPanel();
		this.addBezReceptPanel();
		
		this.add(this.tabKartica);
	}
	
	public void addStanjePanel() {
		this.stanjePanel = new JPanel();

        model.setColumnIdentifiers(Lek.getTableHeader());

		JTable stanjeTabela = new JTable(model);
		
		stanjeTabela.setModel(model);
		
		JButton dugmeKupi = new JButton("Kupi");
		JButton dugmeBrisi = new JButton("Brisi");
		JButton dugmeReset = new JButton("Odustani");
		
		JScrollPane stanjePane = new JScrollPane(stanjeTabela);	
				
        dugmeKupi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	float ukupnaCena = 0;
            	List<Lek> lekoviList = new ArrayList<Lek>();
            
            	for (int i = 0; i < stanjeTabela.getRowCount(); i++){
            		Lek lek = new Lek(
            				(String) stanjeTabela.getValueAt(i, 0), 
            				(String) stanjeTabela.getValueAt(i, 1), 
            				(String) stanjeTabela.getValueAt(i, 2),
            				(boolean) stanjeTabela.getValueAt(i, 3),
            				(float) stanjeTabela.getValueAt(i, 4)
            		);
            		
            		lekoviList.add(lek);
            		ukupnaCena = ukupnaCena + lek.getCena();
            	}
            	
            	Lek[] lekovi = new Lek[lekoviList.size()];
            	lekovi = lekoviList.toArray(lekovi);
            	
             	
            	Racun noviRacun = new Racun(ukupnaCena, lekovi);
           	
            	RacuniRepozitorijum racuniRepozitorijum = MainFrame.getInstance().getRacuniRepozitorijum();
            	boolean uspesno = false;
            	uspesno = racuniRepozitorijum.insertujRacun(noviRacun);
            	
            	if (!uspesno) {
        			String poruka = "Cuvanje novog racuna nije uspesno";
        			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);            		
            	} else {
            		
        			String poruka = "Racun je uspesno zabelezen";
        			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka); 
            		
                    int brojRedova = model.getRowCount();
                    for (int i = brojRedova - 1; i >= 0; i--) {
                    	model.removeRow(i);
                    }
            	}

            }
        });
		
        dugmeBrisi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                int i = stanjeTabela.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    System.out.println("Greska pri brisanju");
                }
            }
        });
        
        dugmeReset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                int brojRedova = model.getRowCount();
                for (int i = brojRedova - 1; i >= 0; i--) {
                	model.removeRow(i);
                }

            }
        });
        
        this.stanjePanel.add(stanjePane);
        
        this.stanjePanel.add(dugmeKupi);
        this.stanjePanel.add(dugmeBrisi);
        this.stanjePanel.add(dugmeReset);
        
        
		this.tabKartica.add("Stanje", this.stanjePanel);
		
	}
	
	public void dodajLekUTabelu(Lek lek) {
		Object[] red = new Object[5];
		
		red[0] = lek.getSifra();
		red[1] = lek.getIme();
		red[2] = lek.getProizvodjac();
		red[3] = lek.isNaRecept();
		red[4] = lek.getCena();
		
		model.addRow(red);

	}
	
	private void addBezReceptPanel() {
		this.bezReceptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		List<Lek> drugs = MainFrame.getInstance().getLekRepozitorijum().ucitajLekove();
		
		JPanel noviPanel = new JPanel();
		noviPanel.setPreferredSize(new Dimension(300, 400));
		
		JLabel sifraLabel = new JLabel("Sifra");
		sifraLabel.setFont(new Font("Serif", Font.BOLD, 18));
		sifraLabel.setPreferredSize(new Dimension(200, 30));
		
		JLabel kolicinaLabel = new JLabel("Kolicina");
		kolicinaLabel.setFont(new Font("Serif", Font.BOLD, 18));
		kolicinaLabel.setPreferredSize(new Dimension(75, 30));
		
		JTextField sifraField = new JTextField();
		sifraField.setPreferredSize(new Dimension(200, 30));
		
		JTextField kolicinaField = new JTextField();
		kolicinaField.setPreferredSize(new Dimension(75, 30));
		
		JButton dodajLekove = new JButton("Dodaj lek");
		dodajLekove.setPreferredSize(new Dimension(275, 30));
		
		dodajLekove.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) { 
            	if (kolicinaField.getText().equals("")) {
            		String poruka = "Polje za kolicinu ne sme biti prazno";
        			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);           		
            	} else if (sifraField.getText().equals("")) {
            		String poruka = "Polje za sifru ne sme biti prazno";
        			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
            	} else {
            		
            		try {
                    	int multiplier = Integer.parseInt(kolicinaField.getText());
                    	
                    	for (Lek lek: drugs){
                    		if (lek.getSifra().equals(sifraField.getText())){
                    			for (int i = 0; i < multiplier; i++) {
                        			dodajLekUTabelu(lek);           				
                    			}
                    		}
                    	}	
                    	
                		String poruka = "Lek je uspesno dodat";
            			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
                    	
                    	sifraField.setText("");
                    	kolicinaField.setText("");
                    	
            		} catch (NumberFormatException error) {
                		String poruka = "Polje za kolicinu mora biti broj!";
            			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);    
            		}

            	}

            }
        });
		
		noviPanel.add(sifraLabel);
		noviPanel.add(kolicinaLabel);

		noviPanel.add(sifraField);
		noviPanel.add(kolicinaField);
		
		noviPanel.add(dodajLekove);
		
		this.bezReceptPanel.add(noviPanel);
		
		this.tabKartica.add("Bez recepta", this.bezReceptPanel);
		
	}
	
	private void addReceptPanel() {
		this.receptPanel = new JPanel();
		
		List<Recept> recepti = MainFrame.getInstance().getReceptiRepozitorijum().ucitajRecepte();
		
		JPanel noviPanel = new JPanel();
		noviPanel.setPreferredSize(new Dimension(300, 400));
		
		JLabel sifraLabel = new JLabel("Sifra");
		sifraLabel.setFont(new Font("Serif", Font.BOLD, 18));
		sifraLabel.setPreferredSize(new Dimension(200, 30));
		
		JTextField sifraField = new JTextField();
		sifraField.setPreferredSize(new Dimension(200, 30));
		
		JButton dodajLekove = new JButton("Dodaj lek");
		dodajLekove.setPreferredSize(new Dimension(275, 30));
		
		dodajLekove.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) { 
            	if (sifraField.getText().equals("")) {
            		String poruka = "Polje za sifru ne sme biti prazno";
        			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
            	} else {
            		
            		try {
                    	
                    	for (Recept recept: recepti){
                    		if (recept.getSifra().equals(sifraField.getText())){
                    			Lek[] lekovi = recept.getLekoviArray();
                    			for (Lek lek: lekovi) {
                        			dodajLekUTabelu(lek);      	
                    			}     				
                    		}
                    	}	
                    	
                		String poruka = "Lek je uspesno dodat";
            			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);
                    	
                    	sifraField.setText("");
                    	
            		} catch (NumberFormatException error) {
                		String poruka = "Polje za kolicinu mora biti broj!";
            			JOptionPane.showMessageDialog(MainFrame.getInstance(), poruka);    
            		}

            	}

            }
        });
		
		noviPanel.add(sifraLabel);
		noviPanel.add(sifraField);
		
		noviPanel.add(dodajLekove);
		
		this.receptPanel.add(noviPanel);
		
		this.tabKartica.add("Recept", this.receptPanel);	
	}
}