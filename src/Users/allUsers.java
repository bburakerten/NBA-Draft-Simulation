package Users;

import java.util.ArrayList;

public class allUsers {
	
	/*
	 * stores and lists all user objects
	 */
	
	public static ArrayList<Users.User> allUsers = new ArrayList<User>();

	public allUsers() {
		this.allUsers = new ArrayList<>();
    }



	public static ArrayList<Users.User> getAllUsers() {
		return allUsers;
	}
	}
	


