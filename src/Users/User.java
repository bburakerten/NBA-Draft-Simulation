package Users;

import java.awt.Image;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Source.idPassword;

public class User {

	private String userName;
    private String password;
    private String emailAddress;
    private String surname;
    private String realName;
    private int age;
    private String userlogo;
    private ArrayList<Image> myImages = new ArrayList<Image>();

    public User(String userName, String password, String realName, String surname, int age, String emailAddress, String userlogo) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.surname = surname;
        this.age = age;
        this.emailAddress = emailAddress;
        this.userlogo = userlogo;
    }

	
    /*
     * getters and setters
     */
    // Getter for userName
    public String getUserName() {
        return userName;
    }

    public String getUserlogo() {
    	return userlogo;
    }
    public void setUserlogo(String userlogo) {
    	this.userlogo = userlogo;
    }

    // Setter for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public ArrayList<Image> returnMyImages() {
        return myImages;
    }
    
    public void addMyImages(Image img) {
        myImages.add(img);
    }
    

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for realName
    public String getRealName() {
        return realName;
    }

    // Setter for realName
    public void setRealName(String realName) {
        this.realName = realName;
    }

    // Getter for surname
    public String getSurname() {
        return surname;
    }

    // Setter for surname
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for emailAddress
    public String getEmailAddress() {
        return emailAddress;
    }

    // Setter for emailAddress
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
    
    
    /*
     * implements user information to the usertxt file and also adds user's mail address to the email, username to the username lists. 
     */
    public void writeToUserFile() {
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(userName + ", " + password + ", " + realName + ", " + surname + ", " + emailAddress + ", " + age + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
        idPassword.loginInfo.put(userName, password);
        idPassword.email.add(emailAddress);
        idPassword.username.add(userName);
        

    }
  
	
}
