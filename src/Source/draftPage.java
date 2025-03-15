package Source;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Team.Team;

import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;

public class draftPage extends JFrame implements ActionListener{
	
	
	JFrame frame = new JFrame();



/* User's team and other teams created in this class 
 * 
 */

	
	public static Team team_1 = new Team("Boston Celtics", 0, 0, 0, 0, "/Source/bostonc.jpg");
	public static Team team_2 = new Team("Brooklyn Nets", 0, 0, 0, 0, "/Source/brooklynn.jpg");
	public static Team team_3 = new Team("New York Knicks", 0, 0, 0, 0, "/Source/newyorkk.jpg");
	public static Team team_4 = new Team("Philadelphia 76ers", 0, 0, 0, 0, "/Source/76ers.jpg");
	public static Team team_5 = new Team("Toronto Raptors", 0, 0, 0, 0, "/Source/torontor.jpg");
	public static Team team_6 = new Team("Chicago Bulls", 0, 0, 0, 0, "/Source/chicagob.jpg");
	public static Team team_7 = new Team("Cleveland Cavaliers", 0, 0, 0, 0, "/Source/clevelandc.jpg");
	public static Team team_8 = new Team("Detroit Pistons", 0, 0, 0, 0, "/Source/detroitp.jpg");
	public static Team team_9 = new Team("Indiana Pacers", 0, 0, 0, 0, "/Source/indianap.jpg");
	public static Team team_10 = new Team("Milwaukee Bucks", 0, 0, 0, 0, "/Source/mbucks.jpg");
	public static Team team_11 = new Team("Atlanta Hawks", 0, 0, 0, 0, "/Source/atlantah.jpg");
	public static Team team_12 = new Team("Charlotte Hornets", 0, 0, 0, 0, "/Source/chornets.jpg");
	public static Team team_13 = new Team("Miami Heat", 0, 0, 0, 0, "/Source/miamih.jpg");
	public static Team team_14 = new Team("Orlando Magic", 0, 0, 0, 0, "/Source/orlandom.jpg");
	public static Team team_15 = new Team("Washington Wizards", 0, 0, 0, 0, "/Source/washingtonw.jpg");
	public static Team team_16 = new Team("Your Team", 0, 0, 0, 0, infoPage.currentUser.getUserlogo());
	
	
	
	/*Getter for User's team to use it in different classes easily
	 * 
	 */
	public static Team getteam_16() {
		return team_16;
	}

	
	Random random = new Random();
	
	
	/*
	 * combining all position lists start
	 */
    public ArrayList<Player.playerInfo> nameList() {
    	ArrayList<Player.playerInfo> namelist = new ArrayList<Player.playerInfo>();
    	for (Player.playerInfo player : Player.playerList.getCplayerList()) {
		
    		namelist.add(player);
    	}
    	for (Player.playerInfo player1 : Player.playerList.getPFplayerList()) {
    		
    		namelist.add(player1);
    	}
    	for (Player.playerInfo player2 : Player.playerList.getPGplayerList()) {
    		
    		namelist.add(player2);
    	}
    	for (Player.playerInfo player3 : Player.playerList.getSFplayerList()) {
    		
    		namelist.add(player3);
    	}
    	for (Player.playerInfo player4 : Player.playerList.getSGplayerList()) {
    		
    		namelist.add(player4);
    	}
    	return namelist;
    	}
    ArrayList<Player.playerInfo> nnameList = nameList();
	
	/*
	 * combining all position lists end
	 */
    
    
    /*
     * Team Shuffler Every time teams' position change in draft page and Game Page except User's team start
     */
	public static ArrayList<Team> teamShuffler(){
		Team[] teamArray = { team_1, team_2, team_3, team_4, team_5, team_6, team_7, team_8, team_9, team_10,team_11, team_12, team_13, team_14, team_15 };

		ArrayList<Team> teamList = new ArrayList<>(Arrays.asList(teamArray));

		Collections.shuffle(teamList);

	    
	    return teamList;
	}
	static ArrayList<Team> shuffledTeams = teamShuffler();
	
	public static ArrayList<Team> getshuffledTeams(){
		return shuffledTeams;
	}
    /*
     * Team Shuffler Every time teams' position change in draft page and Game Page except User's team end
     */
	
	/*
	 * Created List of player names for combobox in draft page
	 */
    public String[] justNameList() {
    	ArrayList<String> jnameList = new ArrayList<String>();
    	for(int i = 0; i< nnameList.size(); i++) {
    		jnameList.add(nnameList.get(i).getPlayerName());
    	}
    	return jnameList.toArray(new String[0]);
    }
    
    
    
    String[] justnameList = justNameList();

    
	private static final long serialVersionUID = 1L;
		
	/*
	 * Jlabels and other Js' for Gui
	 */
		JLabel yourTeamLabel = new JLabel(team_16.getTeamName());
		JLabel teamLabel1 = new JLabel(shuffledTeams.get(0).getTeamName());
		JLabel teamLabel2 = new JLabel(shuffledTeams.get(1).getTeamName());
		JLabel teamLabel3 = new JLabel(shuffledTeams.get(2).getTeamName());
		JLabel teamLabel4 = new JLabel(shuffledTeams.get(3).getTeamName());
		JLabel teamLabel5 = new JLabel(shuffledTeams.get(4).getTeamName());
		JLabel teamLabel6 = new JLabel(shuffledTeams.get(5).getTeamName());
		JLabel teamLabel7 = new JLabel(shuffledTeams.get(6).getTeamName());
		JLabel teamLabel8 = new JLabel(shuffledTeams.get(7).getTeamName());
		JLabel teamLabel9 = new JLabel(shuffledTeams.get(8).getTeamName());
		JLabel teamLabel10 = new JLabel(shuffledTeams.get(9).getTeamName());
		JLabel teamLabel11 = new JLabel(shuffledTeams.get(10).getTeamName());
		JLabel teamLabel12 = new JLabel(shuffledTeams.get(11).getTeamName());
		JLabel teamLabel13 = new JLabel(shuffledTeams.get(12).getTeamName());
		JLabel teamLabel14 = new JLabel(shuffledTeams.get(13).getTeamName());
		JLabel teamLabel15 = new JLabel(shuffledTeams.get(14).getTeamName());
		JLabel teamlogo = new JLabel("");
		JLabel teamlogo1 = new JLabel("");
		JLabel teamlogo2 = new JLabel("");
		JLabel teamlogo3 = new JLabel("");
		JLabel teamlogo4 = new JLabel("");
		JLabel teamlogo5 = new JLabel("");
		JLabel teamlogo6 = new JLabel("");
		JLabel teamlogo7 = new JLabel("");
		JLabel teamlogo8 = new JLabel("");
		JLabel teamlogo9 = new JLabel("");
		JLabel teamlogo10 = new JLabel("");
		JLabel teamlogo11 = new JLabel("");
		JLabel teamlogo12 = new JLabel("");
		JLabel teamlogo13 = new JLabel("");
		JLabel teamlogo14 = new JLabel("");
		JLabel teamlogoyourteam = new JLabel("");
		JLabel messageLabel = new JLabel();


		JButton selectButton1 = new JButton("Select");
		JButton selectButton2 = new JButton("Select");
		JButton selectButton3 = new JButton("Select");
		JButton selectButton4 = new JButton("Select");
		JButton selectButton5 = new JButton("Select");
		JButton continueButton = new JButton("Continue");
		JComboBox<String> comboBox = new JComboBox<>(justnameList);
		JComboBox<String> comboBox2 = new JComboBox<>(justNameList());
		JComboBox<String> comboBox3 = new JComboBox<>(justNameList());
		JComboBox<String> comboBox4 = new JComboBox<>(justNameList());
		JComboBox<String> comboBox5 = new JComboBox<>(justNameList());

		JLabel yourteamp1 = new JLabel();
		JLabel yourteamp2 = new JLabel();
		JLabel yourteamp3 = new JLabel();
		JLabel yourteamp4 = new JLabel();
		JLabel yourteamp5 = new JLabel();
		
		/*
		 * Timers created for delays
		 */
		Timer nameTimer;
		Timer nameTimer2;
		Timer nameTimer3;
		Timer nameTimer4;
		Timer nameTimer5;



		/*
		 * createTeamPlayerLabels1_2() this method chooses 30 different players for the teams other than user's team in this
		 * method only PF and C position players are added to the computer controlled teams. first part of the method lists 
		 * the teams in first column form 0 to 15 and second part of the method lists the players in second column with reverse order.
		 */
		public JLabel[] createTeamPlayerLabels1_2(){
	        JLabel[] teamPlayerLabels = new JLabel[30];
			for (int j = 0; j < 1; j++) {
				for(int i = 0; i < 15; i++) {
					int randomInRange = random.nextInt(Player.playerList.getPFplayerList().size() - 0) + 0;
		            Player.playerInfo selectedPlayer = Player.playerList.getPFplayerList().get(randomInRange);
		            teamPlayerLabels[(j*15) + i] = new JLabel(selectedPlayer.getPlayerName()); 
		            shuffledTeams.get(i).addPlayer(selectedPlayer);

		            Player.playerList.getPFplayerList().remove(randomInRange);
		            nnameList.remove(selectedPlayer);

				}   
	        }
			for (int k = 1; k < 2; k++) {
				for(int i = 0; i < 15; i++) {
					int randomInRange = random.nextInt(Player.playerList.getCplayerList().size() - 0) + 0;
		            Player.playerInfo selectedPlayer = Player.playerList.getCplayerList().get(randomInRange);
		            teamPlayerLabels[(k*15) + i] = new JLabel(selectedPlayer.getPlayerName()); 
		            shuffledTeams.get(i).addPlayer(selectedPlayer);

		            Player.playerList.getCplayerList().remove(randomInRange);
		            nnameList.remove(selectedPlayer);

				}   
	        }
	        return teamPlayerLabels;		
		}
		/*
		 * createTeamPlayerLabels2_2() same as the previous method just for the third and 
		 * fourth columns and method chooses players from PG and SF
		 */
		public JLabel[] createTeamPlayerLabels2_2(){
	        JLabel[] teamPlayerLabels = new JLabel[30];
			for (int j = 0; j < 1; j++) {
				for(int i = 0; i < 15; i++) {
					int randomInRange = random.nextInt(Player.playerList.getPGplayerList().size() - 0) + 0;
		            Player.playerInfo selectedPlayer = Player.playerList.getPGplayerList().get(randomInRange);
		            teamPlayerLabels[(j*15) + i] = new JLabel(selectedPlayer.getPlayerName()); 
		            shuffledTeams.get(i).addPlayer(selectedPlayer);

		            Player.playerList.getPGplayerList().remove(randomInRange);
		            nnameList.remove(selectedPlayer);

				}   
	        }
			for (int k = 1; k < 2; k++) {
				for(int i = 0; i < 15; i++) {
					int randomInRange = random.nextInt(Player.playerList.getSFplayerList().size() - 0) + 0;
		            Player.playerInfo selectedPlayer = Player.playerList.getSFplayerList().get(randomInRange);
		            teamPlayerLabels[(k*15) + i] = new JLabel(selectedPlayer.getPlayerName()); 
		            shuffledTeams.get(i).addPlayer(selectedPlayer);

		            Player.playerList.getSFplayerList().remove(randomInRange);
		            nnameList.remove(selectedPlayer);

				}   
	        }
	        return teamPlayerLabels;		
		}
		/*
		 * createTeamPlayerLabels2_3() same as the previous methods only difference is the number of labels since this method is only
		 * for fifth column
		 */
		public JLabel[] createTeamPlayerLabels2_3(){
	        JLabel[] teamPlayerLabels = new JLabel[15];
	        for (int j = 0; j < 1; j++) {
				for(int i = 0; i < 15; i++) {
					int randomInRange = random.nextInt(Player.playerList.getSGplayerList().size() - 0) + 0;
		            Player.playerInfo selectedPlayer = Player.playerList.getSGplayerList().get(randomInRange);
		            teamPlayerLabels[(j*15) + i] = new JLabel(selectedPlayer.getPlayerName()); 
		            shuffledTeams.get(i).addPlayer(selectedPlayer);

		            Player.playerList.getSGplayerList().remove(randomInRange);
		            nnameList.remove(selectedPlayer);

				}   
	        }
	        return teamPlayerLabels;		
		}
		
		
		//JLabel[] tteamPlayerLabels = createTeamPlayerLabels();

		private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					draftPage frame = new draftPage();
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
	public draftPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 1500, 1500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		yourTeamLabel.setBounds(80, 120, 81, 16);
		contentPane.add(yourTeamLabel);
		
		teamLabel1.setBounds(79, 187, 153, 16);
		contentPane.add(teamLabel1);
		
		teamLabel2.setBounds(79, 227, 188, 16);
		contentPane.add(teamLabel2);
		
		teamLabel3.setBounds(79, 267, 198, 16);
		contentPane.add(teamLabel3);
		
		teamLabel4.setBounds(79, 307, 153, 16);
		contentPane.add(teamLabel4);
		
		teamLabel5.setBounds(79, 347, 153, 16);
		contentPane.add(teamLabel5);
		
		teamLabel6.setBounds(79, 387, 153, 16);
		contentPane.add(teamLabel6);
		
		teamLabel7.setBounds(79, 427, 153, 16);
		contentPane.add(teamLabel7);
		
		teamLabel8.setBounds(79, 467, 153, 16);
		contentPane.add(teamLabel8);
		
		teamLabel9.setBounds(79, 507, 153, 16);
		contentPane.add(teamLabel9);
		
		teamLabel10.setBounds(79, 547, 153, 16);
		contentPane.add(teamLabel10);
		
		teamLabel11.setBounds(79, 587, 153, 16);
		contentPane.add(teamLabel11);
		
		teamLabel12.setBounds(79, 627, 153, 16);
		contentPane.add(teamLabel12);
		
		teamLabel13.setBounds(79, 667, 153, 16);
		contentPane.add(teamLabel13);
		
		teamLabel14.setBounds(79, 707, 153, 16);
		contentPane.add(teamLabel14);
		
		teamLabel15.setBounds(79, 747, 153, 16);
		contentPane.add(teamLabel15);
		messageLabel.setBounds(626, 16, 711, 70);
		messageLabel.setForeground(Color.red); 

		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		contentPane.add(messageLabel);

		messageLabel.setText("Your turn");

		

		selectButton1.setBounds(30, 64, 117, 29);
		selectButton1.addActionListener(this);
		contentPane.add(selectButton1);
		
		selectButton2.setBounds(150, 54, 117, 29);
		selectButton2.addActionListener(this);
		
		selectButton3.setBounds(270, 54, 117, 29);
		selectButton3.addActionListener(this);

		
		selectButton4.setBounds(390, 54, 117, 29);
		selectButton4.addActionListener(this);
		
		selectButton5.setBounds(510, 54, 117, 29);
		selectButton5.addActionListener(this);
		
		continueButton.setBounds(610, 54, 117, 29);
		continueButton.addActionListener(this);
		
		/*
		 * Comboboxes for user to select players
		 * every time is user's turn to select a player they update themselves
		 */
        String[] justnameList1 = justNameList();
        comboBox = new JComboBox<>(justnameList1);
        comboBox.setBounds(30, 16, 117, 27);
        contentPane.add(comboBox);

        String[] justnameList2 = justNameList();
        comboBox2 = new JComboBox<>(justnameList2);
        comboBox2.setBounds(150, 16, 117, 27);
        contentPane.add(comboBox2);
        
        String[] justnameList3 = justNameList();
        comboBox3 = new JComboBox<>(justnameList3);
        comboBox3.setBounds(270, 16, 117, 27);
        contentPane.add(comboBox3);
        
        String[] justnameList4 = justNameList();
        comboBox4 = new JComboBox<>(justnameList4);
        comboBox4.setBounds(390, 16, 117, 27);
        contentPane.add(comboBox4);
        
        String[] justnameList5 = justNameList();
        comboBox5 = new JComboBox<>(justnameList5);
        comboBox5.setBounds(510, 16, 117, 27);
        contentPane.add(comboBox5);
        /*
		 * Comboboxes for user to select players end
		 * 
		 */
        /*
         * User's team players' labels
         */
		yourteamp1.setBounds(246, 120, 100, 16);
		yourteamp1.setFont(new Font("Dialog", Font.ITALIC, 15));
		contentPane.add(yourteamp1);
		
		yourteamp2.setBounds(400, 120, 100, 16);
		yourteamp2.setFont(new Font("Dialog", Font.ITALIC, 15));
		contentPane.add(yourteamp2);
		
		yourteamp3.setBounds(560, 120, 100, 16);
		yourteamp3.setFont(new Font("Dialog", Font.ITALIC, 15));
		contentPane.add(yourteamp3);
		
		yourteamp4.setBounds(720, 120, 100, 16);
		yourteamp4.setFont(new Font("Dialog", Font.ITALIC, 15));
		contentPane.add(yourteamp4);
		
		yourteamp5.setBounds(880, 120, 100, 16);
		yourteamp5.setFont(new Font("Dialog", Font.ITALIC, 15));
		contentPane.add(yourteamp5);
		
	       /*
         * User's team players' labels end
         */
		
		/*
		 * team logos
		 */
		
		teamlogoyourteam.setIcon(new ImageIcon(team_16.getlogo()));
		contentPane.add(teamlogoyourteam);
		teamlogoyourteam.setSize(30, 31);
		teamlogoyourteam.setLocation(37, 110);
        setLocationRelativeTo(null);

		
		
		teamlogo.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(0).getlogo())));
		contentPane.add(teamlogo);
		teamlogo.setSize(30, 31);
		teamlogo.setLocation(37, 180);
        setLocationRelativeTo(null);

		
		teamlogo1.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(1).getlogo())));
		contentPane.add(teamlogo1);
		teamlogo1.setSize(30, 31);
		teamlogo1.setLocation(37, 220);
        setLocationRelativeTo(null);

		
		teamlogo2.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(2).getlogo())));
		contentPane.add(teamlogo2);
		teamlogo2.setSize(30, 31);
		teamlogo2.setLocation(37, 260);
        setLocationRelativeTo(null);

		
		teamlogo3.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(3).getlogo())));
		contentPane.add(teamlogo3);
		teamlogo3.setSize(30, 31);
		teamlogo3.setLocation(37, 300);
        setLocationRelativeTo(null);

		
		teamlogo4.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(4).getlogo())));
		contentPane.add(teamlogo4);
		teamlogo4.setSize(30, 31);
		teamlogo4.setLocation(37, 340);
        setLocationRelativeTo(null);

		
		teamlogo5.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(5).getlogo())));
		contentPane.add(teamlogo5);
		teamlogo5.setSize(30, 31);
		teamlogo5.setLocation(37, 380);
        setLocationRelativeTo(null);

		
		teamlogo6.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(6).getlogo())));
		contentPane.add(teamlogo6);
		teamlogo6.setSize(30, 31);
		teamlogo6.setLocation(37, 420);
        setLocationRelativeTo(null);

		
		teamlogo7.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(7).getlogo())));
		contentPane.add(teamlogo7);
		teamlogo7.setSize(30, 31);
		teamlogo7.setLocation(37, 460);
        setLocationRelativeTo(null);

		
		teamlogo8.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(8).getlogo())));
		contentPane.add(teamlogo8);
		teamlogo8.setSize(30, 31);
		teamlogo8.setLocation(37, 500);
        setLocationRelativeTo(null);

		
		teamlogo9.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(9).getlogo())));
		contentPane.add(teamlogo9);
		teamlogo9.setSize(30, 31);
		teamlogo9.setLocation(37, 540);
        setLocationRelativeTo(null);

		
		teamlogo10.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(10).getlogo())));
		contentPane.add(teamlogo10);
		teamlogo10.setSize(30, 31);
		teamlogo10.setLocation(37, 580);
        setLocationRelativeTo(null);

		
		teamlogo11.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(11).getlogo())));
		contentPane.add(teamlogo11);
		teamlogo11.setSize(30, 31);
		teamlogo11.setLocation(37, 620);
        setLocationRelativeTo(null);

		
		teamlogo12.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(12).getlogo())));
		contentPane.add(teamlogo12);
		teamlogo12.setSize(30, 31);
		teamlogo12.setLocation(37, 660);
        setLocationRelativeTo(null);

		
		teamlogo13.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(13).getlogo())));
		contentPane.add(teamlogo13);
		teamlogo13.setSize(30, 31);
		teamlogo13.setLocation(37, 700);
        setLocationRelativeTo(null);

		
		teamlogo14.setIcon(new ImageIcon(draftPage.class.getResource(shuffledTeams.get(14).getlogo())));
		contentPane.add(teamlogo14);
		teamlogo14.setSize(30, 31);
		teamlogo14.setLocation(37, 740);
        setLocationRelativeTo(null);

		
        /*
		 * team logos end
		 */


	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*
		 * After user press the SelectButton1 which can be pressed after user selects its first player button allows code to 
		 * choose players for other teams and add them to the ui with some delay between each ui update after all labels are printed to the ui
		 * timer stops combobox2 get update and ui let user to select its second player 
		 */
		if(e.getSource()== selectButton1) {
			contentPane.remove(messageLabel);
			System.out.println(comboBox.getSelectedIndex());
			int selectedIndex = comboBox.getSelectedIndex();
			team_16.addPlayer(nnameList.get(selectedIndex));
			yourteamp1.setForeground(Color.red); 
			yourteamp1.setText(comboBox.getItemAt(selectedIndex));
			nnameList.remove(selectedIndex);
            contentPane.remove(selectButton1);
			JLabel[] tteamPlayerLabels = createTeamPlayerLabels1_2();
			
	          nameTimer4 = new Timer(200, new ActionListener() {
	                int i = 0;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (i < 15) {
	                        tteamPlayerLabels[i].setBounds(246, 187 + (40 * i), 100, 16);
	                        contentPane.add(tteamPlayerLabels[i]);
	                        contentPane.revalidate();
	                        contentPane.repaint();
	                        i++;

	                        if (i == 15) {
	                            nameTimer4.stop();
	                        }
	                    }
	                }
	            });

	            nameTimer4.setInitialDelay(0); 
	            nameTimer4.setRepeats(true);
	            nameTimer4.start();

	            nameTimer5 = new Timer(200, new ActionListener() {
	                int i = 14;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (i >= 0) {
	                        tteamPlayerLabels[i+15].setBounds(400, 187 + (40 * (i)), 100, 16);
	                        contentPane.add(tteamPlayerLabels[i+15]);
	                        contentPane.revalidate();
	                        contentPane.repaint();
	                        i--;

	                        if (i < 0) {
	                        	String[] updatedJustNameList4 = justNameList();
	                	        comboBox2.setModel(new DefaultComboBoxModel<>(updatedJustNameList4));
	                	        comboBox2.setSelectedIndex(0);
	                			contentPane.add(selectButton2);
	                            nameTimer5.stop();
	                    		messageLabel.setText("Your turn");
		                		contentPane.add(messageLabel);
	                        }
	                    }
	                }
	            });

	            nameTimer5.setInitialDelay(3500);
	            nameTimer5.setRepeats(true);
	            nameTimer5.start();
	           
				
				
				contentPane.revalidate();
				contentPane.repaint();    

				

		
		    	/*
		    	 * Selectbutton2 locks the player that user selected immediately activates the selectbutton3 since it is user's turn again
		    	 */


		}
		if(e.getSource()== selectButton2) {
			contentPane.remove(messageLabel);
			System.out.println(comboBox2.getSelectedIndex());
			int selectedIndex1 = comboBox2.getSelectedIndex();
			if(!team_16.getPlayers().get(0).getPosition().equals(nnameList.get(comboBox2.getSelectedIndex()).getPosition())) {
				team_16.addPlayer(nnameList.get(comboBox2.getSelectedIndex()));
				yourteamp2.setForeground(Color.red); 
				yourteamp2.setText(comboBox2.getItemAt(selectedIndex1));
				nnameList.remove(selectedIndex1);
	            contentPane.remove(selectButton2);
	            contentPane.remove(messageLabel);
	            String[] updatedJustNameList3 = justNameList();
		        comboBox3.setModel(new DefaultComboBoxModel<>(updatedJustNameList3));
		        comboBox3.setSelectedIndex(0);
				messageLabel.setText("Your turn");
        		contentPane.add(messageLabel);
				contentPane.add(selectButton3);
	    		
	    		contentPane.revalidate();
			    contentPane.repaint();
			}
			else {
				contentPane.add(messageLabel);
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("You already selected " + team_16.getPlayers().get(0).getPosition()+ " position player");
				
			}
			

            

		}
		
    	/*
    	 * Selectbutton3 let code to print the third and the forth columns in draft page after it is completed combobox3 get update, selected player is deleted
    	 * and stops with adding forth button for user
    	 */
		
		if(e.getSource()== selectButton3) {
			contentPane.remove(messageLabel);
			System.out.println(comboBox3.getSelectedIndex());
			int selectedIndex = comboBox3.getSelectedIndex();
			if(!team_16.getPlayers().get(0).getPosition().equals(nnameList.get(comboBox3.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(1).getPosition().equals(nnameList.get(comboBox3.getSelectedIndex()).getPosition())) {
				team_16.addPlayer(nnameList.get(selectedIndex));
				yourteamp3.setForeground(Color.red); 
				yourteamp3.setText(comboBox3.getItemAt(selectedIndex));
				nnameList.remove(selectedIndex);
				
				JLabel[] tteamPlayerLabels = createTeamPlayerLabels2_2();
	            contentPane.remove(selectButton3);
	            contentPane.remove(messageLabel);
	            nameTimer2 = new Timer(200, new ActionListener() {
	                int i = 0;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (i < 15) {
	                        tteamPlayerLabels[i].setBounds(560, 187 + (40 * i), 100, 16);
	                        contentPane.add(tteamPlayerLabels[i]);
	                        contentPane.revalidate();
	                        contentPane.repaint();
	                        i++;

	                        if (i == 15) {
	                            // Add continueButton after the last label
	                            nameTimer2.stop();
	                        }
	                    }
	                }
	            });

	            nameTimer2.setInitialDelay(0); // No initial delay
	            nameTimer2.setRepeats(true);
	            nameTimer2.start();

	            // Second part of your code
	            nameTimer3 = new Timer(200, new ActionListener() {
	                int i = 14;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (i >= 0) {
	                        tteamPlayerLabels[i+15].setBounds(720, 187 + (40 * (i)), 100, 16);
	                        contentPane.add(tteamPlayerLabels[i+15]);
	                        contentPane.revalidate();
	                        contentPane.repaint();
	                        i--;

	                        if (i < 0) {
	                            // Add continueButton after the last label
	                        	String[] updatedJustNameList4 = justNameList();
	                	        comboBox4.setModel(new DefaultComboBoxModel<>(updatedJustNameList4));
	                	        comboBox4.setSelectedIndex(0);
	                			contentPane.add(selectButton4);
	                            nameTimer3.stop();
	                    		messageLabel.setText("Your turn");
		                		contentPane.add(messageLabel);
	                        }
	                    }
	                }
	            });

	            nameTimer3.setInitialDelay(3500); // No initial delay
	            nameTimer3.setRepeats(true);
	            nameTimer3.start();
	           
				
				
				contentPane.revalidate();
				contentPane.repaint();    

				
			}
			else {
				contentPane.add(messageLabel);
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("You already selected " + team_16.getPlayers().get(0).getPosition()+ " and " + team_16.getPlayers().get(1).getPosition()+ " position players");
				
			}

			
	    	/*
	    	 * Selectbutton4 locks the player that user selected immediately activates the selectbutton5 since it is user's turn again
	    	 */
		}
		if(e.getSource()== selectButton4) {
			contentPane.remove(messageLabel);
			System.out.println(comboBox4.getSelectedIndex());
			int selectedIndex1 = comboBox4.getSelectedIndex();
			if(!team_16.getPlayers().get(0).getPosition().equals(nnameList.get(comboBox4.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(1).getPosition().equals(nnameList.get(comboBox4.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(2).getPosition().equals(nnameList.get(comboBox4.getSelectedIndex()).getPosition())) {
				team_16.addPlayer(nnameList.get(comboBox4.getSelectedIndex()));
				yourteamp4.setForeground(Color.red); 
				yourteamp4.setText(comboBox4.getItemAt(selectedIndex1));
				nnameList.remove(selectedIndex1);
	            contentPane.remove(selectButton4);
	            contentPane.remove(messageLabel);

	            String[] updatedJustNameList5 = justNameList();
		        comboBox5.setModel(new DefaultComboBoxModel<>(updatedJustNameList5));
		        comboBox5.setSelectedIndex(0);
				messageLabel.setText("Your turn");
				contentPane.add(messageLabel);
				contentPane.add(selectButton5);
	    		
	    		contentPane.revalidate();
			    contentPane.repaint();
			}
			
			else {
				contentPane.add(messageLabel);
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("You already selected " + team_16.getPlayers().get(0).getPosition()+ ", " + team_16.getPlayers().get(1).getPosition()+ " and " + team_16.getPlayers().get(2).getPosition()+ " position players");
				
			}
			

		}
		
		/*
		 * locks the player  user selected in combobox5 if the selected player's position chosen before button prints a proper message 
		 */
		if(e.getSource()== selectButton5) {
			contentPane.remove(messageLabel);
			System.out.println(comboBox5.getSelectedIndex());
			int selectedIndex = comboBox5.getSelectedIndex();
			if(!team_16.getPlayers().get(0).getPosition().equals(nnameList.get(comboBox5.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(1).getPosition().equals(nnameList.get(comboBox5.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(2).getPosition().equals(nnameList.get(comboBox5.getSelectedIndex()).getPosition()) && !team_16.getPlayers().get(3).getPosition().equals(nnameList.get(comboBox5.getSelectedIndex()).getPosition())) {
				team_16.addPlayer(nnameList.get(selectedIndex));
				yourteamp5.setForeground(Color.red); 
				yourteamp5.setText(comboBox5.getItemAt(selectedIndex));
				nnameList.remove(selectedIndex);
				
				JLabel[] tteamPlayerLabels = createTeamPlayerLabels2_3();
	            contentPane.remove(selectButton5);
	            contentPane.remove(messageLabel);
	            nameTimer = new Timer(200, new ActionListener() {
	                int i = 0;

	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    if (i < 15) {
	                        tteamPlayerLabels[i].setBounds(880, 187 + (40 * i), 100, 16);
	                        contentPane.add(tteamPlayerLabels[i]);
	                        contentPane.revalidate();
	                        contentPane.repaint();
	                        i++;

	                        if (i == 15) {
	                            // Add continueButton after the last label
	                            contentPane.add(continueButton);
	                            nameTimer.stop();
	                        }
	                        
	                    }
	                }
	            });
	            nameTimer.setInitialDelay(0); // No initial delay
	            nameTimer.setRepeats(true);
	            nameTimer.start();
	            

	            	for(int z = 0; z < shuffledTeams.size(); z++) {
	                        try {
	            			FileWriter writer = new FileWriter("TeamPlayerss.txt", true);
	                        writer.write(shuffledTeams.get(z).getTeamName() + ": " + shuffledTeams.get(z).getPlayers().get(0).getPlayerName() + shuffledTeams.get(z).getPlayers().get(0).getPosition()+", " + shuffledTeams.get(z).getPlayers().get(1).getPlayerName() + shuffledTeams.get(z).getPlayers().get(1).getPosition()+", " + shuffledTeams.get(z).getPlayers().get(2).getPlayerName() + shuffledTeams.get(z).getPlayers().get(2).getPosition()+ ", " + shuffledTeams.get(z).getPlayers().get(3).getPlayerName() + shuffledTeams.get(z).getPlayers().get(3).getPosition()+ ", " + shuffledTeams.get(z).getPlayers().get(4).getPlayerName() + shuffledTeams.get(z).getPlayers().get(4).getPosition() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    
	            		}
	            	}
	            	
			}
			else {
				contentPane.add(messageLabel);
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("You already selected " + team_16.getPlayers().get(0).getPosition()+ ", " + team_16.getPlayers().get(1).getPosition()+ ", " + team_16.getPlayers().get(2).getPosition()+ " and " + team_16.getPlayers().get(3).getPosition()+ " position players");
				
			}
			
			
			
			
			
			}
		if(e.getSource()== continueButton) {
    		
			this.dispose();

			gamePage gamepage = new gamePage();
			gamepage.setVisible(true);
		}

			
		
		
}
}

