/************** Pledge of Honor ******************************************
I hereby certify that I have completed this programming project on my own
without any help from anyone else. The effort in the project thus belongs
completely to me. I did not search for a solution, or I did not consult any
program written by others or did not copy any program from other sources. I
read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Burak Erten, 83459>
*************************************************************************/
package Source;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Player.playerInfo;
import Team.Team;
import Users.User;
import Users.allUsers;

public class Main {
	
	public static void main (String[] args) {
		
		idPassword idPassword = new idPassword();
		
		loginPage loginPage = new loginPage(idPassword.getLoginInfo());
		
		registerPage registerpage = new registerPage();
		File file = new File("users.txt");
		File file2 = new File("Matches.txt");
		File file3 = new File("TeamPlayerss.txt");


		
		
//Default Users 
		
		User user_1 = new User("berten", "burak.2206", "burhan", "Erten", 22, "burhan.erten@hotmail.com", "/Users/burakerten/Desktop/NBA TEAMs/yourtteam.jpg");
		user_1.writeToUserFile();
		allUsers.allUsers.add(user_1);
		User user_2 = new User("eerten", "eemel.95", "emel", "Erten", 40, "eemel.erten@hotmail.com", "/Users/burakerten/Desktop/NBA TEAMs/yourtteam.jpg");
		user_2.writeToUserFile();
		allUsers.allUsers.add(user_2);

		User user_3 = new User("aerten", "aysenur.1412", "aysenur", "Erten", 24, "aysenur.erten@hotmail.com", "/Users/burakerten/Desktop/NBA TEAMs/yourtteam.jpg");
		user_3.writeToUserFile();
		allUsers.allUsers.add(user_3);

		User user = new User(null, null, null, null, 0, null, "/Users/burakerten/Desktop/NBA TEAMs/yourtteam.jpg");

// Default users
		
		/*
		 * Reads the CSV file gets the neccesary informations' columns and stores them in the desired location then adds each player to the 
		 * corresponding lists according to their positions 
		 */
		String filecsv = "PlayerInfo.csv";
		BufferedReader reader = null;
		String line = " ";
		try
		{
			reader = new BufferedReader(new FileReader(filecsv));
			while((line = reader.readLine()) != null) {
				String[] col = line.split(",");
				if(col[2].equals("C")) {
					if(!Player.playerList.CplayerList.contains(col[1])) {
						Player.playerC newPlayer = new Player.playerC( col[0], col[1], Double.parseDouble(col[23]), Double.parseDouble(col[24]), Double.parseDouble(col[25]), Double.parseDouble(col[26]), Double.parseDouble(col[29]));
						if(!Player.playerList.idList.contains(newPlayer.getID())) {
							Player.playerList.idList.add(col[0]);
							Player.playerList.CplayerList.add(newPlayer);
					}					System.out. println(col[0] + " " + col[1] + " " + col[2] + " " + col[23] + " " + col[24] + " " + col[25] + " " + col[26] + " "+ col[28] + " "+ col[29]);
				}
				}
				if(col[2].equals("PF")) {
					if(!Player.playerList.PFplayerList.contains(col[1])) {
						Player.playerPF newPlayer = new Player.playerPF( col[0], col[1], Double.parseDouble(col[23]), Double.parseDouble(col[24]), Double.parseDouble(col[25]), Double.parseDouble(col[26]), Double.parseDouble(col[29]));
						if(!Player.playerList.idList.contains(newPlayer.getID())) {
							Player.playerList.idList.add(col[0]);
							Player.playerList.PFplayerList.add(newPlayer);					}
					System.out. println(col[0] + " " + col[1] + " " + col[2] + " " + col[23] + " " + col[24] + " " + col[25] + " " + col[26] + " "+ col[28] + " "+ col[29]);
				}
				}
				if(col[2].equals("PG")) {
					if(!Player.playerList.PGplayerList.contains(col[1])) {
						Player.playerPG newPlayer = new Player.playerPG( col[0], col[1], Double.parseDouble(col[23]), Double.parseDouble(col[24]), Double.parseDouble(col[25]), Double.parseDouble(col[26]), Double.parseDouble(col[29]));
						if(!Player.playerList.idList.contains(newPlayer.getID())) {
							Player.playerList.idList.add(col[0]);
							Player.playerList.PGplayerList.add(newPlayer);					}
					System.out. println(col[0] + " " + col[1] + " " + col[2] + " " + col[23] + " " + col[24] + " " + col[25] + " " + col[26] + " "+ col[28] + " "+ col[29]);
				}
				}
				if(col[2].equals("SF")) {
					if(!Player.playerList.SFplayerList.contains(col[1])) {
						Player.playerSF newPlayer = new Player.playerSF( col[0], col[1], Double.parseDouble(col[23]), Double.parseDouble(col[24]), Double.parseDouble(col[25]), Double.parseDouble(col[26]), Double.parseDouble(col[29]));
						if(!Player.playerList.idList.contains(newPlayer.getID())) {
							Player.playerList.idList.add(col[0]);
							Player.playerList.SFplayerList.add(newPlayer);
						}
					}
					System.out. println(col[0] + " " + col[1] + " " + col[2] + " " + col[23] + " " + col[24] + " " + col[25] + " " + col[26] + " "+ col[28] + " "+ col[29]);
				}
				if(col[2].equals("SG")) {
					Player.playerSG newPlayer = new Player.playerSG( col[0], col[1], Double.parseDouble(col[23]), Double.parseDouble(col[24]), Double.parseDouble(col[25]), Double.parseDouble(col[26]), Double.parseDouble(col[29]));
					if(!Player.playerList.idList.contains(newPlayer.getID())) {
						Player.playerList.idList.add(col[0]);
						Player.playerList.SGplayerList.add(newPlayer);
					}
					System.out. println(col[0] + " " + col[1] + " " + col[2] + " " + col[23] + " " + col[24] + " " + col[25] + " " + col[26] + " "+ col[28] + " "+ col[29]);
				}
				
			}
			
			
			System.out.println(Player.playerList.CplayerList);
			System.out.println(Player.playerList.CplayerList.size());
			System.out.println(Player.playerList.PFplayerList);
			System.out.println(Player.playerList.PFplayerList.size());
			System.out.println(Player.playerList.PGplayerList);
			System.out.println(Player.playerList.PGplayerList.size());
			System.out.println(Player.playerList.SFplayerList);
			System.out.println(Player.playerList.SFplayerList.size());
			System.out.println(Player.playerList.SGplayerList);
			System.out.println(Player.playerList.SGplayerList.size());


		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public ArrayList<Player.playerInfo> players = new ArrayList<Player.playerInfo>();
	



	
	
}
