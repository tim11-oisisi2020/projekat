package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;


public class TabelaKorpaPanel extends JPanel {
	public JTabbedPane tabKartica;
	
	public JPanel stanjePanel;
	public JPanel receptPanel;
	public JPanel bezReceptPanel;
	
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
	
	private void addStanjePanel() {
		this.stanjePanel = new JPanel();
		
        Object[] kolone = {"Sifra", "Ime", "Proizvodjac", "Recept", "Cena"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(kolone);

		JTable stanjeTabela = new JTable();
		
		stanjeTabela.setModel(model);
		
		JButton dugmeDodaj = new JButton("Dodaj");
		JButton dugmeBrisi = new JButton("Brisi");
		
		JScrollPane stanjePane = new JScrollPane(stanjeTabela);	
		
		Object[] red = new Object[5];
		
		dugmeDodaj.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
   
                red[0] = "s001";
                red[1] = "Panadol";
                red[2] = "Pera";
                red[3] = true;
                red[4] = 250;
                
                model.addRow(red);
            }
        });
		
        dugmeBrisi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = stanjeTabela.getSelectedRow();
                if(i >= 0){
                    model.removeRow(i);
                }
                else{
                    System.out.println("Delete Error");
                }
            }
        });
        
        this.stanjePanel.add(stanjePane);
        this.stanjePanel.add(dugmeDodaj);
        this.stanjePanel.add(dugmeBrisi);
        
		this.tabKartica.add("Stanje", this.stanjePanel);
		
	}
	
	private void addBezReceptPanel() {
		this.bezReceptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
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
		
		JTextField sifraField1 = new JTextField();
		sifraField1.setPreferredSize(new Dimension(200, 30));
		
		JTextField sifraField2 = new JTextField();
		sifraField2.setPreferredSize(new Dimension(200, 30));
		
		JTextField sifraField3 = new JTextField();
		sifraField3.setPreferredSize(new Dimension(200, 30));
		
		JTextField sifraField4 = new JTextField();
		sifraField4.setPreferredSize(new Dimension(200, 30));
		
		JTextField kolicinaField = new JTextField();
		kolicinaField.setPreferredSize(new Dimension(75, 30));
		
		JTextField kolicinaField1 = new JTextField();
		kolicinaField1.setPreferredSize(new Dimension(75, 30));
		
		JTextField kolicinaField2 = new JTextField();
		kolicinaField2.setPreferredSize(new Dimension(75, 30));
		
		JTextField kolicinaField3 = new JTextField();
		kolicinaField3.setPreferredSize(new Dimension(75, 30));
		
		JTextField kolicinaField4 = new JTextField();
		kolicinaField4.setPreferredSize(new Dimension(75, 30));
		
		JButton dodajLekove = new JButton("Dodaj lekove");
		dodajLekove.setPreferredSize(new Dimension(275, 30));
		
		dodajLekove.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(sifraField.getText());
            	System.out.println(kolicinaField.getText());
            }
        });
		
		noviPanel.add(sifraLabel);
		noviPanel.add(kolicinaLabel);

		noviPanel.add(sifraField);
		noviPanel.add(kolicinaField);
		
		noviPanel.add(sifraField1);
		noviPanel.add(kolicinaField1);
		
		noviPanel.add(sifraField2);
		noviPanel.add(kolicinaField2);

		noviPanel.add(sifraField3);
		noviPanel.add(kolicinaField3);
		
		noviPanel.add(sifraField4);
		noviPanel.add(kolicinaField4);
		
		noviPanel.add(dodajLekove);
		
		this.bezReceptPanel.add(noviPanel);
		
		this.tabKartica.add("Bez recepta", this.bezReceptPanel);
		
	}
	
	private void addReceptPanel() {
		this.receptPanel = new JPanel();
		this.tabKartica.add("Recept", this.receptPanel);
	}
}