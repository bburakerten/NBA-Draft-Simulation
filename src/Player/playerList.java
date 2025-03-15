package Player;

import java.util.ArrayList;
import java.util.HashMap;

public class playerList {
	
	/*
	 * seperate lists for diferent positions and all players start
	 */

	public static HashMap<String,String> playerList = new HashMap<String,String>();
	
	public static ArrayList<playerInfo> CplayerList = new ArrayList<playerInfo>();
	
	public static ArrayList<playerInfo> PFplayerList = new ArrayList<playerInfo>();

	public static ArrayList<playerInfo> PGplayerList = new ArrayList<playerInfo>();

	public static ArrayList<playerInfo> SFplayerList = new ArrayList<playerInfo>();
	
	public static ArrayList<playerInfo> SGplayerList = new ArrayList<playerInfo>();
	
	public static ArrayList<String> idList = new ArrayList<String>();

	/*
	 * seperate lists for diferent positions and all players end
	 */

	
	/*
	 * getters of the lists start
	 */
	 public static ArrayList<playerInfo> getCplayerList() {
	        return CplayerList;
	    }
	 public static ArrayList<String> getIdList() {
	        return idList;
	    }
	 public static ArrayList<playerInfo> getPFplayerList() {
	        return PFplayerList;
	    }
	 public static ArrayList<playerInfo> getPGplayerList() {
	        return PGplayerList;
	    }
	 public static ArrayList<playerInfo> getSFplayerList() {
	        return SFplayerList;
	    }
	 public static ArrayList<playerInfo> getSGplayerList() {
	        return SGplayerList;
	    }

		/*
		 * getters of the lists end
		 */

	
}
