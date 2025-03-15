package Source;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Team.Team;

public class myTeamPlayers extends JFrame implements ActionListener {
	
    Team team16 = draftPage.getteam_16();
    
	JButton closeButton = new JButton("Close Screen");



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel myPlayers1 = new JLabel(team16.getPlayers().get(0).getPlayerName());
	JLabel myPlayers2 = new JLabel(team16.getPlayers().get(1).getPlayerName());
	JLabel myPlayers3 = new JLabel(team16.getPlayers().get(2).getPlayerName());
	JLabel myPlayers4 = new JLabel(team16.getPlayers().get(3).getPlayerName());
	JLabel myPlayers5 = new JLabel(team16.getPlayers().get(4).getPlayerName());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myTeamPlayers frame = new myTeamPlayers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public myTeamPlayers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		myPlayers1.setBounds(186, 33, 152, 16);
		contentPane.add(myPlayers1);
		myPlayers1.addMouseListener(new MouseAdapter() {
		    
		    public void mouseClicked(MouseEvent e) {
		        myTeamPlayerInfo infopage = new myTeamPlayerInfo(team16.getPlayers().get(0));
		        infopage.setVisible(true);
		    }});
		
		
		
		
		
		
		
		/*
		 * each time user clicks on a player name label an information page opens up to show some information about that selected player.
		 * It is worked with mouseevent
		 */
		myPlayers2.setBounds(114, 73, 148, 16);
		contentPane.add(myPlayers2);
		myPlayers2.addMouseListener(new MouseAdapter() {
		    
		    public void mouseClicked(MouseEvent e) {
		        myTeamPlayerInfo infopage = new myTeamPlayerInfo(team16.getPlayers().get(1));
		        infopage.setVisible(true);
		    }});
		
		myPlayers3.setBounds(257, 73, 195, 16);
		contentPane.add(myPlayers3);
		myPlayers3.addMouseListener(new MouseAdapter() {
		    
		    public void mouseClicked(MouseEvent e) {
		        myTeamPlayerInfo infopage = new myTeamPlayerInfo(team16.getPlayers().get(2));
		        infopage.setVisible(true);
		    }});
		
		myPlayers4.setBounds(114, 143, 140, 16);
		contentPane.add(myPlayers4);
		myPlayers4.addMouseListener(new MouseAdapter() {
		    
		    public void mouseClicked(MouseEvent e) {
		        myTeamPlayerInfo infopage = new myTeamPlayerInfo(team16.getPlayers().get(3));
		        infopage.setVisible(true);
		    }});
		
		myPlayers5.setBounds(257, 143, 157, 16);
		contentPane.add(myPlayers5);
		myPlayers5.addMouseListener(new MouseAdapter() {
		    
		    public void mouseClicked(MouseEvent e) {
		        myTeamPlayerInfo infopage = new myTeamPlayerInfo(team16.getPlayers().get(4));
		        infopage.setVisible(true);
		    }});
		
		closeButton.setBounds(149, 203, 117, 29);
		closeButton.addActionListener(this);
		contentPane.add(closeButton);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== closeButton) {
			this.dispose();
		}

}
}
