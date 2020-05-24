package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	public MainPanel() {
		this.setBackground(new Color(204, 238, 255));
		
		JLabel wellcomeMessage = new JLabel();
		wellcomeMessage.setText("Wellcome");
		wellcomeMessage.setFont(new Font("Serif", Font.BOLD, 40));
		wellcomeMessage.setHorizontalAlignment(JLabel.CENTER);
		wellcomeMessage.setVerticalAlignment(JLabel.CENTER);
		
		this.add(wellcomeMessage);
	}
	
}
