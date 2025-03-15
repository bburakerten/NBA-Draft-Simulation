package Source;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Player.playerInfo;

import javax.swing.JLabel;
import javax.swing.JButton;

public class myTeamPlayerInfo extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btnNewButton = new JButton("Back");


	/*
	 * opens the selected player's information page displays player's name and some information about the player and also a back button
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player.playerInfo testPlayer = null;

					myTeamPlayerInfo frame = new myTeamPlayerInfo(testPlayer);
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
	public myTeamPlayerInfo(Player.playerInfo playerinfo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(playerinfo.getPlayerName());
		lblNewLabel.setBounds(183, 20, 164, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Position");
		lblNewLabel_1.setBounds(70, 53, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PTS Weight");
		lblNewLabel_2.setBounds(55, 83, 76, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("TRB Weight");
		lblNewLabel_2_1.setBounds(55, 111, 76, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("AST Weight");
		lblNewLabel_2_2.setBounds(55, 139, 76, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("BLK Weight");
		lblNewLabel_2_3.setBounds(55, 167, 76, 16);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("STL Weight");
		lblNewLabel_2_4.setBounds(55, 195, 76, 16);
		contentPane.add(lblNewLabel_2_4);
		
		/*
		 * here gets some information from user class
		 */
		JLabel lblNewLabel_3 = new JLabel(playerinfo.getPosition());
		lblNewLabel_3.setBounds(284, 53, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel(String.valueOf(playerinfo.getweight1()));
		lblNewLabel_3_1.setBounds(284, 83, 61, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel(String.valueOf(playerinfo.getweight2()));
		lblNewLabel_3_2.setBounds(284, 111, 61, 16);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel(String.valueOf(playerinfo.getweight3()));
		lblNewLabel_3_3.setBounds(284, 139, 61, 16);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel(String.valueOf(playerinfo.getweight4()));
		lblNewLabel_3_4.setBounds(284, 167, 61, 16);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel(String.valueOf(playerinfo.getweight5()));
		lblNewLabel_3_5.setBounds(284, 195, 61, 16);
		contentPane.add(lblNewLabel_3_5);
		
		btnNewButton.setBounds(150, 226, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(this);

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnNewButton) {
			this.dispose();
		}

}
}

