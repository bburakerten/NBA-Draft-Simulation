package Users;

import java.awt.Image;
import java.util.ArrayList;

public class logInUser {
	
	private String userName;
    private String password;
    private String emailAddress;
    private String surname;
    private String realName;
    private int age;
    private ArrayList<Image> myImages = new ArrayList<Image>();

    public logInUser(String userName, String password, String realName, String surname, int age, String emailAddress) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.surname = surname;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }


    // Setter for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    // Getter for userName
    public ArrayList<Image> returnMyImages() {
        return myImages;
    }
    
    // Setter for userName
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
    

}
