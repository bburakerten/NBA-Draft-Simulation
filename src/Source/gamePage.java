package Source;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;
import java.util.TimerTask;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Team.Team;

import javax.swing.JButton;
import javax.swing.JLabel;

public class gamePage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	Random random = new Random();
	
	JButton viewButton = new JButton("View Team");
	JButton playoffButton = new JButton("Play Off");
	JButton startGame = new JButton("Start Game");
	JButton pauseButton = new JButton("Pause");



	



	public static ArrayList<Team> teamgathering(){

		  Team team16 = draftPage.getteam_16();
		ArrayList<Team> shuffledTeams = draftPage.getshuffledTeams();
		shuffledTeams.add(team16);


	    
	    return shuffledTeams;
	}
	static ArrayList<Team> shuffledTeams = teamgathering();


	Timer nameTimer;
    private boolean isPaused = false;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePage frame = new gamePage();
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
	public gamePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		viewButton.setBounds(777, 12, 117, 29);
		viewButton.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("team");
		lblNewLabel.setBounds(61, 67, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblWin = new JLabel("Win");
		lblWin.setBounds(256, 67, 61, 16);
		contentPane.add(lblWin);
		
		JLabel lblLose = new JLabel("Lose");
		lblLose.setBounds(423, 67, 61, 16);
		contentPane.add(lblLose);
		
		JLabel lblTie = new JLabel("Tie");
		lblTie.setBounds(582, 67, 61, 16);
		contentPane.add(lblTie);
		
		playoffButton.setBounds(777, 54, 117, 29);
		playoffButton.addActionListener(this);
		
		startGame.setBounds(22, 12, 117, 29);
		startGame.addActionListener(this);
		contentPane.add(startGame);
		

	    
		/*
		 * team labels created with for loop to make code more clean
		 */
		JLabel[] teamNameLabels = new JLabel[16];
		for(int y = 0; y < 16; y++) {
			teamNameLabels[y] = new JLabel(shuffledTeams.get(y).getTeamName()); 
			teamNameLabels[y].setBounds(44, (95 + (y*30)), 150, 16);
			contentPane.add(teamNameLabels[y]);
		} 
			}



	
	
	
	
	/*
	 * viewButton() is used to display user's team when it is pressed simulation stops and new panel open ups 
	 * like a pop up pause button is replaces by a resume button (button's name change)
	 */
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== viewButton) {
			myTeamPlayers myteam = new myTeamPlayers();
			myteam.setVisible(true);
			isPaused = true;
			pauseButton.setText("Resume");
            nameTimer.stop();
            System.out.println("Paused");
            contentPane.revalidate();
            contentPane.repaint();
			
		}
		
		/*
		 * after startgame button pressed, simulation starts playing everytime a game is played ui updates itself after each team plays 32 games 
		 * simulation stops. during the simulation there is a pause resume button which is used to start and stop simulation without losing any information
		 * 
		 */
		
		if(e.getSource()== startGame) {
			JLabel[] teamWinLabels = new JLabel[16];
			 JLabel[] teamLoseLabels = new JLabel[16];
			 JLabel[] teamTieLabels = new JLabel[16];
				contentPane.add(viewButton);
				contentPane.remove(startGame);

			 
			 for(int l = 0; l < 16; l++) {
 				String teamWinText = String.valueOf(shuffledTeams.get(l).getTeamWin());
 			    teamWinLabels[l] = new JLabel(teamWinText);
 			    teamWinLabels[l].setBounds(241, (95 + (l * 30)), 61, 16);
 			    contentPane.add(teamWinLabels[l]);
 			}   
 			for(int m = 0; m < 16; m++) {
 				String teamLoseText = String.valueOf(shuffledTeams.get(m).getTeamLose());
 			    teamLoseLabels[m] = new JLabel(teamLoseText);
 			    teamLoseLabels[m].setBounds(441, (95 + (m * 30)), 61, 16);
 			    contentPane.add(teamLoseLabels[m]);
 			}   
 			for(int n = 0; n < 16; n++) {
 				String teamTieText = String.valueOf(shuffledTeams.get(n).getTeamTie());
 			    teamTieLabels[n] = new JLabel(teamTieText);
 			    teamTieLabels[n].setBounds(641, (95 + (n * 30)), 61, 16);
 			    contentPane.add(teamTieLabels[n]);
 			}


 			pauseButton.setBounds(377, 12, 117, 29);
 			contentPane.add(pauseButton);
 	        pauseButton.addActionListener(new ActionListener() {
 	        	
 	        	private void Pause() {
		            isPaused = !isPaused;
		            
		            if (isPaused) {
		            	pauseButton.setText("Resume");
		                nameTimer.stop();
		                System.out.println("Paused");
                        contentPane.revalidate();
                        contentPane.repaint();
		        }
		            if(!isPaused) {
		            	pauseButton.setText("Pause");

		            	nameTimer.start();
		                System.out.println("Resumed");
                        contentPane.revalidate();
                        contentPane.repaint();
		            }
		    	}
 	            @Override
 	            public void actionPerformed(ActionEvent e) {
 	                Pause();
 	            }
 	        });
 	        
 	       
			 nameTimer = new Timer(100, new ActionListener() {
				    int o = 0;

				    /*
				     * IN this part code chooses two different team each time if chosen teams haven't played 32 matches yet these chosen teams play match and 
				     * their playedmatches and win-lose-tie numbers change, home team's score is multiplied by 1.05
				     * 
				     */
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	if(!isPaused) {
				        if (o < 256) {
				        	int i = random.nextInt(16);
				                int randomInRange = 0;
				                randomInRange = random.nextInt((16));

				                if (randomInRange != i && shuffledTeams.get(randomInRange).getTeamMatch() < 32 && shuffledTeams.get(i).getTeamMatch() < 32) {
				                    int randomInRange2 = random.nextInt(2);
				                    shuffledTeams.get(randomInRange).setTeamMatch(shuffledTeams.get(randomInRange).getTeamMatch() + 1);
				                    shuffledTeams.get(i).setTeamMatch(shuffledTeams.get(i).getTeamMatch() + 1);

				                    int total1 = 0;
				                    double total1_1 = 0;
				                    for (int j = 0; j < 5; j++) {
				                        total1 += shuffledTeams.get(randomInRange).getPlayers().get(j).getpoint();
				                    }
				                    int total2 = 0;
				                    double total2_2 = 0;
				                    for (int k = 0; k < 5; k++) {
				                        total2 += shuffledTeams.get(i).getPlayers().get(k).getpoint();
				                    }
				                    if (randomInRange2 > 0) {
				                        total1_1 = total1 * 1.05;
				                        total2_2 = total2 * 1.00;
				                    }
				                    if (randomInRange2 == 0) {
				                        total2_2 = total2 * 1.05;
				                        total1_1 = total1 * 1.00;

				                    }

				                    if (total1_1 > total2_2) {
				                    	contentPane.remove(teamWinLabels[randomInRange]);
				                    	contentPane.remove(teamLoseLabels[i]);

				                        shuffledTeams.get(randomInRange).setTeamWin(shuffledTeams.get(randomInRange).getTeamWin() + 1);
				                        
				                        shuffledTeams.get(i).setTeamLose(shuffledTeams.get(i).getTeamLose() + 1);
				            				String teamWinText = String.valueOf(shuffledTeams.get(randomInRange).getTeamWin());
				            			    teamWinLabels[randomInRange] = new JLabel(teamWinText);
				            			    teamWinLabels[randomInRange].setBounds(241, (95 + (randomInRange * 30)), 61, 16);
				            			    contentPane.add(teamWinLabels[randomInRange]);
				            	             try {
							                        FileWriter writer = new FileWriter("Matches.txt", true);
							                        writer.write(shuffledTeams.get(randomInRange).getTeamName() + ", " + total1_1 + ", " + shuffledTeams.get(i).getTeamName() + ", " + total2_2 + " Winner: " + shuffledTeams.get(randomInRange).getTeamName() + "\n");
							                        writer.close();
							                    } catch (IOException e1) {
							                        System.out.println("Error writing to file");
							                        e1.printStackTrace();
							                    }
				            			    
				            			    String teamLoseText = String.valueOf(shuffledTeams.get(i).getTeamLose());
				            			    teamLoseLabels[i] = new JLabel(teamLoseText);
				            			    teamLoseLabels[i].setBounds(441, (95 + (i * 30)), 61, 16);
				            			    contentPane.add(teamLoseLabels[i]);
				            			 
				                        contentPane.revalidate();
				                        contentPane.repaint();
				                    }
				                    if (total1_1 < total2_2) {
				                    	contentPane.remove(teamWinLabels[i]);
				                    	contentPane.remove(teamLoseLabels[randomInRange]);
				                        shuffledTeams.get(i).setTeamWin(shuffledTeams.get(i).getTeamWin() + 1);
				                        shuffledTeams.get(randomInRange).setTeamLose(shuffledTeams.get(randomInRange).getTeamLose() + 1);
				                        try {
					                        FileWriter writer = new FileWriter("Matches.txt", true);
					                        writer.write(shuffledTeams.get(randomInRange).getTeamName() + ", " + total1_1 + ", " + shuffledTeams.get(i).getTeamName() + ", " + total2_2 + " Winner: " + shuffledTeams.get(i).getTeamName() + "\n");
					                        writer.close();
					                    } catch (IOException e1) {
					                        System.out.println("Error writing to file");
					                        e1.printStackTrace();
					                    }


				            				String teamWinText = String.valueOf(shuffledTeams.get(i).getTeamWin());
				            			    teamWinLabels[i] = new JLabel(teamWinText);
				            			    teamWinLabels[i].setBounds(241, (95 + (i * 30)), 61, 16);
				            			    contentPane.add(teamWinLabels[i]);
				            			
				            			
				            				String teamLoseText = String.valueOf(shuffledTeams.get(randomInRange).getTeamLose());
				            			    teamLoseLabels[randomInRange] = new JLabel(teamLoseText);
				            			    teamLoseLabels[randomInRange].setBounds(441, (95 + (randomInRange * 30)), 61, 16);
				            			    contentPane.add(teamLoseLabels[randomInRange]);
				            			

				                        contentPane.revalidate();
				                        contentPane.repaint();
				                    }
				                    if (total1_1 == total2_2) {
				                    	contentPane.remove(teamTieLabels[i]);
				                    	contentPane.remove(teamTieLabels[randomInRange]);
				                        shuffledTeams.get(i).setTeamTie(shuffledTeams.get(i).getTeamTie() + 1);
				                        shuffledTeams.get(randomInRange).setTeamTie(shuffledTeams.get(randomInRange).getTeamTie() + 1);

				            			
				            				String teamTieText = String.valueOf(shuffledTeams.get(i).getTeamTie());
				            			    teamTieLabels[i] = new JLabel(teamTieText);
				            			    teamTieLabels[i].setBounds(641, (95 + (i * 30)), 61, 16);
				            			    contentPane.add(teamTieLabels[i]);
				            			    String teamTieText1 = String.valueOf(shuffledTeams.get(randomInRange).getTeamTie());
				            			    teamTieLabels[randomInRange] = new JLabel(teamTieText1);
				            			    teamTieLabels[randomInRange].setBounds(641, (95 + (randomInRange * 30)), 61, 16);
				            			    contentPane.add(teamTieLabels[randomInRange]);
				            			

				                        contentPane.revalidate();
				                        contentPane.repaint();
				                    }
			                        o++;
			                        
				                }
				                    

				                
				                contentPane.revalidate();
		                        contentPane.repaint();
				            
				            contentPane.revalidate();
	                        contentPane.repaint();
				            
				        }
				    	
				        if (o == 240) {
				    		contentPane.add(playoffButton);
				        }
	
				        if (o == 256) {
				            nameTimer.stop();
				        }
				    	}
				    }
				     
				});
			 
			 nameTimer.setInitialDelay(0); 
			 nameTimer.setRepeats(true);
			 nameTimer.start();
			 
			
		    	
			 }
			
				
				
					
			 System.out.println(shuffledTeams.get(0).getPlayers().get(0).getpoint());
				System.out.println(shuffledTeams.get(0).getPlayers().get(0).getpoint());
	
		
				
			/*
			 * playoffbutton opens the playoff screen
			 */		    
		if(e.getSource()== playoffButton) {
			this.dispose();
			playoffPage ppage = new playoffPage();
			ppage.setVisible(true);
		
		}
				
	}
	/*
	 * gets the top 8 teams with highest win
	 */
	public static ArrayList<Team> getTopteams(){
	
	Collections.sort(shuffledTeams, Comparator.comparingInt(Team::getTeamWin).reversed());

	// Get the first 8 teams
	List<Team> top8Teams = shuffledTeams.subList(0, 8);

	ArrayList<Team> top8TeamsArrayList = new ArrayList<>(top8Teams);
	
	return top8TeamsArrayList;
}


}

	
