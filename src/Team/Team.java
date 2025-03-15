package Team;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;


public class Team {

	private String teamName;
    private String teamlogo;
    private ArrayList<Player.playerInfo> players;
    private int teamWin;
    private int teamLose;
    private int teamTie;
    private int teamMatch;
    
    public Team(String teamName, int teamWin, int teamLose, int teamTie, int teamMatch, String teamlogo) {
        this.teamName = teamName;
        this.teamlogo = teamlogo;
        this.players = new ArrayList<>();
        this.teamWin = teamWin;
        this.teamLose = teamLose;
        this.teamTie = teamTie;
        this.teamMatch = teamMatch;
       

    
    }
    
    
    
    public String getlogo() {
    	return teamlogo;
    }
    public String getTeamName() {
        return teamName;
    }
    public int getTeamTie() {
    	return teamTie;
    }
    public int getTeamMatch() {
    	return teamMatch;
    }
    public void setTeamMatch(int teamMatch) {
        this.teamMatch = teamMatch;
    }

    public void setTeam(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamWin() {
        return teamWin;
    }

    public void setTeamWin(int teamWin) {
        this.teamWin = teamWin;
    }
    public void setTeamTie(int teamTie) {
        this.teamTie = teamTie;
    }
    
    public int getTeamLose() {
        return teamLose;
    }

    public void setTeamLose(int teamLose) {
        this.teamLose = teamLose;
    }

    public ArrayList<Player.playerInfo> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player.playerInfo> players) {
        this.players = players;
    }

    // Method to add a player to the team
    public void addPlayer(Player.playerInfo player) {
        players.add(player);
    }


    
    
}
