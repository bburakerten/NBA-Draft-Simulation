package Source;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Users.allUsers;


public class loginPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Register");
	JTextField usernameField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel usernameLabel = new JLabel("username:");
	JLabel passwordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	public static String username;
	
	public static String getUsername() {
		return username;
	}
	
  

	
	
	public HashMap<String,String> loginInfo = new HashMap<String,String>();

	
	
	loginPage(HashMap<String,String> logininfoNormal){
		
		loginInfo = logininfoNormal;
 
		
        
		usernameLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(120, 250, 250, 30);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		usernameField. setBounds (125, 100,200,25); 
		userPasswordField. setBounds (125, 150, 200, 25);

		loginButton.setBounds (125, 200,100,25); 
		loginButton.addActionListener(this);
		
		registerButton.setBounds (225, 200,100,25); 
		registerButton.addActionListener(this);
		
		frame.add(messageLabel);
		frame.add(loginButton);
		frame.add(registerButton);
		frame.add(usernameLabel);
		frame.add(passwordLabel);
		frame.add(usernameField);
		frame.add(userPasswordField);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==loginButton) {
			String username = usernameField.getText();
			

			String password = String.valueOf(userPasswordField.getPassword());
			if(loginInfo.containsKey(username)) {
				if(loginInfo.get(username).equals(password)) {
				
				infoPage infopage = new infoPage(username);
				infopage.setVisible(true);
				frame.dispose();

			}
				else {
					messageLabel.setForeground(Color.red); 
					messageLabel.setText("Wrong password");
				}
			}
			else {
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("Username not found");
			}
		}
		if(e.getSource()==registerButton) {
			frame.dispose();
			registerPage registerpage = new registerPage();
			registerpage.setVisible(true);
		}
	}
}
		