package Source;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Team.Team;

import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class playoffPage extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Timer playoffTimer;
	Timer playoffTimer2;
	Timer playoffTimer3;
    private boolean isPaused = false;


	
	Random random = new Random();

	JButton startButton = new JButton("Start Play Off");
	JButton pauseButton = new JButton("Pause");
	JLabel Champion = new JLabel("Champion");

	
	ArrayList<Team> playoffTeams = gamePage.getTopteams();
	ArrayList<Team> finalFourTeams = new ArrayList<Team>();
	ArrayList<Team> finalTeams = new ArrayList<Team>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playoffPage frame = new playoffPage();
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
	public playoffPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		startButton.addActionListener(this);
		startButton.setBounds(301, 150, 130, 29);
		contentPane.add(startButton);
		
		Champion.setBounds(440, 160, 150, 16);
	

		/*
		 * Pause button and its function 
		 */
			pauseButton.setBounds(377, 6, 117, 29);
	        pauseButton.addActionListener(new ActionListener() {
	        	
	        	private void Pause() {
	            isPaused = !isPaused;
	            
	            if (isPaused) {
	            	pauseButton.setText("Resume");
	                playoffTimer.stop();
	                playoffTimer2.stop();
	                playoffTimer3.stop();
	                System.out.println("Paused");
                    contentPane.revalidate();
                    contentPane.repaint();
	        }
	            if(!isPaused) {
	            	pauseButton.setText("Pause");

	            	playoffTimer.start();
	                playoffTimer2.start();
	                playoffTimer3.start();
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
	        

			/*
			 * Pause button and its function end
			 */



			/*
			 * random number excluder to not choose the same number again 
			 */
	}
	private static int getRandomNumber(int randomvalue, List<Integer> excludedValues) {
        Random random = new Random();
        int randomNumber;

        do {
            randomNumber = random.nextInt(randomvalue);
        } 
        while (excludedValues.contains(randomNumber));

        return randomNumber;
	}
	/*
	 * random number excluder to not choose the same number again end
	 */
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== startButton) {
			/*
			 * lists the first four matches and runs the game
			 */
			contentPane.remove(startButton);
			contentPane.add(pauseButton);

			playoffTimer = new Timer(500, new ActionListener() {

		        List<Integer> excludedValues = new ArrayList<>();

			    int i = 0;
			    public void actionPerformed(ActionEvent e) {

			    	
			    if( i<4) {
			    	
			    	
			    int randomTeam1  = getRandomNumber( 8, excludedValues);
			    excludedValues.add(randomTeam1);
			    int randomTeam2  = getRandomNumber( 8, excludedValues);
			    excludedValues.add(randomTeam2);

			    JLabel lblNewLabel = new JLabel(playoffTeams.get(randomTeam1).getTeamName());
				lblNewLabel.setBounds(30, (i*76)+53, 150, 16);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel(playoffTeams.get(randomTeam2).getTeamName());
				lblNewLabel_1.setBounds(30, ((i)*76)+83, 150, 16);
				contentPane.add(lblNewLabel_1);

			    
			    int randomInRange2 = random.nextInt(2);
                int total1 = 0;
                double total1_1 = 0;
                for (int j = 0; j < 5; j++) {
                    total1 += playoffTeams.get(randomTeam1).getPlayers().get(j).getpoint();
                }
                int total2 = 0;
                double total2_2 = 0;
                for (int k = 0; k < 5; k++) {
                    total2 += playoffTeams.get(randomTeam2).getPlayers().get(k).getpoint();
                }
                if (randomInRange2 > 0) {
                    total1_1 = total1 * 1.05;
                    total2_2 = total2 * 1.0;
                }
                if (randomInRange2 == 0) {
                    total2_2 = total2 * 1.05;
                    total1_1 = total1 * 1.00;
                }

                if (total1_1 > total2_2) {
                	finalFourTeams.add(playoffTeams.get(randomTeam1));
            		JLabel lblNewLabel_1_2 = new JLabel(finalFourTeams.get(i).getTeamName());
            		lblNewLabel_1_2.setBounds(180, 66 + (i*80), 150, 16);
            		contentPane.add(lblNewLabel_1_2);
            		   contentPane.revalidate();
                       contentPane.repaint();
                       try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(playoffTeams.get(randomTeam1).getTeamName() + ", " + total1_1 + ", " + playoffTeams.get(randomTeam2).getTeamName() + ", " + total2_2 + " Winner: " + playoffTeams.get(randomTeam1).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                }
        			 
           
                if (total1_1 < total2_2) {
                	finalFourTeams.add(playoffTeams.get(randomTeam2));
                	JLabel lblNewLabel_1_3 = new JLabel(finalFourTeams.get(i).getTeamName());
            		lblNewLabel_1_3.setBounds(180, 66 + (i*80), 150, 16);
            		contentPane.add(lblNewLabel_1_3);
            		   contentPane.revalidate();
                       contentPane.repaint();
                       try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(playoffTeams.get(randomTeam1).getTeamName() + ", " + total1_1 + ", " + playoffTeams.get(randomTeam2).getTeamName() + ", " + total2_2 + " Winner: " + playoffTeams.get(randomTeam2).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                }
                if (total1_1 == total2_2) {
                	if (randomInRange2 > 0) {
                		finalFourTeams.add(playoffTeams.get(randomTeam1));
                    	JLabel lblNewLabel_1_3 = new JLabel(finalFourTeams.get(i).getTeamName());
                		lblNewLabel_1_3.setBounds(180, 66 + (i*80), 150, 16);
                		contentPane.add(lblNewLabel_1_3);
                		   contentPane.revalidate();
                           contentPane.repaint();
                        contentPane.revalidate();
                        contentPane.repaint();
                        try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(playoffTeams.get(randomTeam1).getTeamName() + ", " + total1_1 + ", " + playoffTeams.get(randomTeam2).getTeamName() + ", " + total2_2 + " Winner: " + playoffTeams.get(randomTeam1).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                	}
                	if (randomInRange2 == 0) {
                		finalFourTeams.add(playoffTeams.get(randomTeam2));
                    	JLabel lblNewLabel_1_3 = new JLabel(finalFourTeams.get(i).getTeamName());
                		lblNewLabel_1_3.setBounds(180, 66 + (i*80), 150, 16);
                		contentPane.add(lblNewLabel_1_3);
                		   contentPane.revalidate();
                           contentPane.repaint();
                        contentPane.revalidate();
                        contentPane.repaint();
                        try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(playoffTeams.get(randomTeam1).getTeamName() + ", " + total1_1 + ", " + playoffTeams.get(randomTeam2).getTeamName() + ", " + total2_2 + " Winner: " + playoffTeams.get(randomTeam2).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                	}
                
                	
                }

			    i++;

}
			    if (i == 4) {
		            playoffTimer.stop();

			    }
			    
			    }
		});
			playoffTimer.setInitialDelay(0); // No initial delay
			playoffTimer.setRepeats(true);
			playoffTimer.start();
			
			/*
			 * lists the first four matches and runs the game end
			 */
			
			
			
			
			/*
			 * lists the semi final matches and runs the game
			 */
			playoffTimer2 = new Timer(500, new ActionListener() {

			    int m = 0;
			    int l = 1;
			    int i = 0;
			    public void actionPerformed(ActionEvent e) {
			    	
			    if( m <= 2 && l <= 3) {
			    int randomInRange2 = random.nextInt(2);
                int total1 = 0;
                double total1_1 = 0;
                for (int j = 0; j < 5; j++) {
                    total1 += finalFourTeams.get(m).getPlayers().get(j).getpoint();
                }
                int total2 = 0;
                double total2_2 = 0;
                for (int k = 0; k < 5; k++) {
                    total2 += finalFourTeams.get(l).getPlayers().get(k).getpoint();
                }
                if (randomInRange2 > 0) {
                    total1_1 = total1 * 1.05;
                    total2_2 = total2 * 1.0;
                }
                if (randomInRange2 == 0) {
                    total2_2 = total2 * 1.05;
                    total1_1 = total1 * 1.00;
                }

                if (total1_1 > total2_2) {
                	finalTeams.add(finalFourTeams.get(m));
            		JLabel finalteam = new JLabel(finalTeams.get(i).getTeamName());
            		finalteam.setBounds(280, 100 + (i*160), 150, 16);
            		contentPane.add(finalteam);
            		   contentPane.revalidate();
                       contentPane.repaint();
                       try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(finalFourTeams.get(m).getTeamName() + ", " + total1_1 + ", " + finalFourTeams.get(l).getTeamName() + ", " + total2_2 + " Winner: " + finalFourTeams.get(m).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                }
        			 
           
                if (total1_1 < total2_2) {
                	finalTeams.add(finalFourTeams.get(l));
                	JLabel lblNewLabel_1_3 = new JLabel(finalTeams.get(i).getTeamName());
            		lblNewLabel_1_3.setBounds(280, 100 + (i*160), 150, 16);
            		contentPane.add(lblNewLabel_1_3);
            		   contentPane.revalidate();
                       contentPane.repaint();
                       try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(finalFourTeams.get(m).getTeamName() + ", " + total1_1 + ", " + finalFourTeams.get(l).getTeamName() + ", " + total2_2 + " Winner: " + finalFourTeams.get(l).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                }
                if (total1_1 == total2_2) {
                	if (randomInRange2 > 0) {
                		finalTeams.add(finalFourTeams.get(m));
                    	JLabel finalteam = new JLabel(finalTeams.get(i).getTeamName());
                		finalteam.setBounds(280, 100 + (i*160), 150, 16);
                		contentPane.add(finalteam);
                		   contentPane.revalidate();
                           contentPane.repaint();
                        contentPane.revalidate();
                        contentPane.repaint();
                        try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(finalFourTeams.get(m).getTeamName() + ", " + total1_1 + ", " + finalFourTeams.get(l).getTeamName() + ", " + total2_2 + " Winner: " + finalFourTeams.get(m).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                	}
                	if (randomInRange2 == 0) {
                		finalTeams.add(finalFourTeams.get(l));
                    	JLabel lblNewLabel_1_3 = new JLabel(finalTeams.get(i).getTeamName());
                		lblNewLabel_1_3.setBounds(280, 100 + (i*160), 150, 16);
                		contentPane.add(lblNewLabel_1_3);
                		   contentPane.revalidate();
                           contentPane.repaint();
                        contentPane.revalidate();
                        contentPane.repaint();
                        try {
	                        FileWriter writer = new FileWriter("Matches.txt", true);
	                        writer.write(finalFourTeams.get(m).getTeamName() + ", " + total1_1 + ", " + finalFourTeams.get(l).getTeamName() + ", " + total2_2 + " Winner: " + finalFourTeams.get(l).getTeamName() + "\n");
	                        writer.close();
	                    } catch (IOException e1) {
	                        System.out.println("Error writing to file");
	                        e1.printStackTrace();
	                    }
                	}
                
                	
                }
                m = m + 2;
			    l = l + 2;
			    i++;

}
			    if (m > 2) {
		            playoffTimer2.stop();

			    }
			    
			    }
		});
			playoffTimer2.setInitialDelay(2500); // No initial delay
			playoffTimer2.setRepeats(true);
			playoffTimer2.start();
			
			/*
			 * lists the semi final matches and runs the game end
			 */
			
			
			/*
			 * lists the  final match and runs the game 
			 */
			playoffTimer3 = new Timer(500, new ActionListener() {

			    int m = 0;
			    int l = 1;
			    	
			    public void actionPerformed(ActionEvent e) {
				    if(m <1) {

			    int randomInRange2 = random.nextInt(2);
                int total1 = 0;
                double total1_1 = 0;
                for (int j = 0; j < 5; j++) {
                    total1 += finalFourTeams.get(m).getPlayers().get(j).getpoint();
                }
                int total2 = 0;
                double total2_2 = 0;
                for (int k = 0; k < 5; k++) {
                    total2 += finalFourTeams.get(l).getPlayers().get(k).getpoint();
                }
                if (randomInRange2 > 0) {
                    total1_1 = total1 * 1.05;
                    total2_2 = total2 * 1.0;
                }
                if (randomInRange2 == 0) {
                    total2_2 = total2 * 1.05;
                    total1_1 = total1 * 1.00;
                }

                if (total1_1 > total2_2) {
            		JLabel winner = new JLabel(finalTeams.get(m).getTeamName());
            		winner.setBounds(440, 178, 150, 16);
            		contentPane.add(winner);
            		contentPane.add(Champion);
            		   contentPane.revalidate();
                       contentPane.repaint();
                }
        			 
           
                if (total1_1 < total2_2) {
                	JLabel winner = new JLabel(finalTeams.get(l).getTeamName());
            		winner.setBounds(440, 178, 150, 16);
            		contentPane.add(winner);
            		contentPane.add(Champion);
            		   contentPane.revalidate();
                       contentPane.repaint();
                }
                if (total1_1 == total2_2) {
                	if (randomInRange2 > 0) {
                    	JLabel winner = new JLabel(finalTeams.get(l).getTeamName());
                		winner.setBounds(440, 178, 150, 16);
                		contentPane.add(winner);
                		contentPane.add(Champion);
                        contentPane.revalidate();
                        contentPane.repaint();
                	}
                	if (randomInRange2 == 0) {
                    	JLabel winner = new JLabel(finalTeams.get(m).getTeamName());
                		winner.setBounds(440, 178, 150, 16);
                		contentPane.add(winner);
                		contentPane.add(Champion);
                        contentPane.revalidate();
                        contentPane.repaint();

                	}
                
                	
                }
                m = m + 1;



}
			    if (m == 1) {
		            playoffTimer3.stop();

			    }
			    
			    }
		});
			playoffTimer3.setInitialDelay(4000); // No initial delay
			playoffTimer3.setRepeats(true);
			playoffTimer3.start();
	}
}	/*
	 * lists the  final match and runs the game end
	 */
}
