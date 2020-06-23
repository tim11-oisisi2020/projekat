package view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TabelaKorpaPanel extends JPanel {
	
	public TabelaKorpaPanel() {
		JLabel wellcomeMessage = new JLabel();
		wellcomeMessage.setText("Tabela Korpa TODO...");
		wellcomeMessage.setFont(new Font("Serif", Font.BOLD, 40));
		wellcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		wellcomeMessage.setVerticalAlignment(JLabel.CENTER);
		
		this.setBackground(MainFrame.getInstance().getZelenaPozadina());
		this.add(wellcomeMessage);
	}

}