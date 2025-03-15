package Source;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class mainPage extends JFrame implements ActionListener {

	
	JFrame frame = new JFrame();
	JButton settingsButton = new JButton("Settings");
	JButton startGameButton = new JButton("Start Game");
	
	/*
	 * Main Page just settings and startgame buttons are displayed settings go back to infoPage and startgame opens draft page	
	 */
        
	mainPage(){
		settingsButton.setBounds(153, 256, 100, 25);
		settingsButton.addActionListener(this);
		startGameButton.setBounds(153, 94, 100, 25);
		startGameButton.addActionListener(this);
		frame.getContentPane().setLayout(null);
		
		
		frame.getContentPane().add(settingsButton);
		frame.getContentPane().add(startGameButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setVisible(true);
		 
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== settingsButton) {
			infoPage infopage = new infoPage(infoPage.getCurrent());
			infopage.setVisible(true);
			frame.dispose();


		

					
			}
			
		if(e.getSource()==startGameButton) {
			frame.dispose();
			draftPage draftpage = new draftPage();
			draftpage.setVisible(true);
		}
	}

}
