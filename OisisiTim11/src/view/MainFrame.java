package view;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private MainPanel mainPanel;
	
	private String activeUser;
	
	private static MainFrame instance = null;
	
	private MainFrame() {
		this.setSize(1200, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setTitle("Pharmacy Team 11");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.mainPanel = new MainPanel();
		this.add(mainPanel);
		
		this.setVisible(true);
	}
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		
		return instance;
	}

	public String getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(String activeUser) {
		this.activeUser = activeUser;
	}
	
}
