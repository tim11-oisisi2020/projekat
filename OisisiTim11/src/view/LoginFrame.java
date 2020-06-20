package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.LoginAction;

public class LoginFrame extends JFrame {
	
	private int brojLogovanja = 0;
	
	public LoginFrame() {
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Color pozadina = MainFrame.getInstance().getZelenaPozadina();
		Color slova = MainFrame.getInstance().getAkcenatCrvena();
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(pozadina);
		
		JPanel gornjiPanel = new JPanel(new BorderLayout());
		gornjiPanel.setPreferredSize(new Dimension(1000, 60));
		gornjiPanel.setBackground(pozadina);
		
		JLabel naslov = new JLabel("Log In");
		naslov.setForeground(slova);
		naslov.setFont(new Font("Serif", Font.BOLD, 32));
		naslov.setHorizontalAlignment(JLabel.CENTER);
		naslov.setVerticalAlignment(JLabel.CENTER);
		gornjiPanel.add(naslov);
		
		JPanel korisnickoImePanel = new JPanel();
		korisnickoImePanel.setLayout(new BoxLayout(korisnickoImePanel, BoxLayout.X_AXIS));
		korisnickoImePanel.setPreferredSize(new Dimension(350, 100));
		korisnickoImePanel.setBorder(BorderFactory.createEmptyBorder(70, 0, 0, 0));
		
		JLabel korisnickoImeLabela = new JLabel("Korisnicko ime");
		korisnickoImeLabela.setFont(new Font("Serif", Font.BOLD, 18));
		korisnickoImeLabela.setHorizontalAlignment(JLabel.RIGHT);
		
		JTextField korisnickoImePolje = new JTextField();
		
		korisnickoImePanel.add(korisnickoImeLabela);
		korisnickoImePanel.add(Box.createRigidArea(new Dimension(20,0)));
		korisnickoImePanel.add(korisnickoImePolje);
		
		JPanel lozinkaPanel = new JPanel();
		lozinkaPanel.setLayout(new BoxLayout(lozinkaPanel, BoxLayout.X_AXIS));
		lozinkaPanel.setPreferredSize(new Dimension(350, 100));
		lozinkaPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 70, 0));
		
		JLabel lozinkaLabela = new JLabel("Lozinka");
		lozinkaLabela.setFont(new Font("Serif", Font.BOLD, 18));
		lozinkaLabela.setHorizontalAlignment(JLabel.RIGHT);
		
		JTextField lozinkaPolje = new JTextField();
		
		lozinkaPanel.add(lozinkaLabela);
		lozinkaPanel.add(Box.createRigidArea(new Dimension(20,0)));
		lozinkaPanel.add(lozinkaPolje);
		
		JPanel centerPanel = new JPanel();
		centerPanel.add(korisnickoImePanel);
		centerPanel.add(lozinkaPanel);
		
		JPanel donjiPanel = new JPanel(new BorderLayout());
		donjiPanel.setPreferredSize(new Dimension(1000, 60));
		donjiPanel.setBackground(pozadina);
		
		JButton ulogujSe = new JButton("Uloguj se");
		ulogujSe.setBackground(MainFrame.getInstance().getDugmeZelena());
		ulogujSe.setForeground(slova);
		ulogujSe.setFont(new Font("Serif", Font.BOLD, 18));
		ulogujSe.setSize(new Dimension(60, 40));
		ulogujSe.addActionListener(new LoginAction(korisnickoImePolje, lozinkaPolje));
		
		JPanel flowPanel = new JPanel(new FlowLayout());
		flowPanel.setBackground(pozadina);
		flowPanel.add(ulogujSe);
		donjiPanel.add(flowPanel);
		
		panel.add(gornjiPanel, BorderLayout.NORTH);
		panel.add(donjiPanel, BorderLayout.SOUTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		this.add(panel);
	}

	public int getBrojLogovanja() {
		return brojLogovanja;
	}

	public void inkrementirajBrojLogovanja() {
		this.brojLogovanja = brojLogovanja + 1;
	}

}
