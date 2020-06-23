package view;

import java.awt.Color;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.TipKorisnika;
import model.repo.KorisnikRepozitorijum;

public class MainFrame extends JFrame {
	
	private MainPanel mainPanel;
	
	private LoginFrame loginFrame;
	
	private String aktivniKorisnik;
	private TipKorisnika tipKorisnika;
	
	private Color zelenaPozadina = new Color(184, 220, 210);
	private Color dugmeZelena = new Color(150, 213, 196);
	private Color akcenatCrvena = new Color(171, 150, 129);
	
	private KorisnikRepozitorijum korisnikRepozitorijum;
	
	private static MainFrame instance = null;
	private final Gson gson;
	
	private MainFrame() {
		gson = new GsonBuilder().setPrettyPrinting().create();
		
		String direktorijum = Paths.get("").toAbsolutePath() + "\\resources\\database\\";
		this.korisnikRepozitorijum = new KorisnikRepozitorijum(gson, direktorijum);
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		
		return instance;
	}
	
	public String getAktivniKorisnik() {
		return aktivniKorisnik;
	}

	public void setAktivniKorisnik(String aktivniKorisnik) {
		this.aktivniKorisnik = aktivniKorisnik;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public void setAkcenatCrvena(Color akcenatCrvena) {
		this.akcenatCrvena = akcenatCrvena;
	}

	public static void setInstance(MainFrame instance) {
		MainFrame.instance = instance;
	}

	public void sakrijLoginFrame() {
		loginFrame.setVisible(false);
		this.iscrtajKomponente();
		this.setVisible(true);
	}
	
	public void prikaziLoginFrame() {
		this.loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

	public Color getZelenaPozadina() {
		return zelenaPozadina;
	}

	public Color getDugmeZelena() {
		return dugmeZelena;
	}

	public Color getAkcenatCrvena() {
		return akcenatCrvena;
	}

	public Gson getGson() {
		return gson;
	}

	public KorisnikRepozitorijum getKorisnikRepozitorijum() {
		return korisnikRepozitorijum;
	}
	
	private void iscrtajKomponente() {
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("Pharmacy Team 11");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.mainPanel = new MainPanel();
		this.add(mainPanel);
	}
	
}
