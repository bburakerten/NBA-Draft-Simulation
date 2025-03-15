package Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class idPassword {
	
	
	/* This class contains lists of some unique informations such as email and username. 
Also HashMap, loginInfo, is here which is a map to validate esixting username and password  

*/
	public static HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	idPassword(){
		loginInfo.put("burak", "berten");
		loginInfo.put("emel", "eerten");
		loginInfo.put("aysenur", "aerten");
	}
	
	HashMap getLoginInfo() {
		return loginInfo;
	}
	
	public static List<String> email = new ArrayList<>();
	public static List<String> username = new ArrayList<>();
	
		
}
