package Source;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Users.User;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.regex.Matcher;


import javax.swing.JComboBox;

public class registerPage extends JFrame implements ActionListener {

	JFrame frame = new JFrame();
	public JPanel contentPane;
	public JTextField usernameField;
	public JTextField nameField;
	public JTextField surnameField;
	public JTextField passwordField;
	public JTextField age;
	public JTextField email;
	JButton Register = new JButton("Register");
	JLabel messageLabel = new JLabel();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerPage frame = new registerPage();
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
	public registerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Register.setBounds(225, 200,100,25); 
		Register.addActionListener(this);
		contentPane.add(Register);

		
		usernameField = new JTextField();
		usernameField.setBounds(6, 37, 130, 26);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(6, 90, 130, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setBounds(6, 138, 130, 26);
		contentPane.add(surnameField);
		surnameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(219, 37, 130, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		messageLabel.setBounds(49, 170, 1200, 70);
		messageLabel.setFont(new Font(null,Font.ITALIC,10));
		contentPane.add(messageLabel);
		
		age = new JTextField();
		age.setBounds(219, 90, 130, 26);
		contentPane.add(age);
		age.setColumns(10);
		
		email = new JTextField();
		email.setBounds(219, 138, 130, 26);
		contentPane.add(email);
		email.setColumns(10);
		

		
		JLabel usernameField = new JLabel("username");
		usernameField.setBounds(6, 21, 61, 16);
		contentPane.add(usernameField);
		
		JLabel nameField = new JLabel("name");
		nameField.setBounds(6, 75, 61, 16);
		contentPane.add(nameField);
		
		JLabel lblNewLabel_2 = new JLabel("surname");
		lblNewLabel_2.setBounds(6, 123, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel password = new JLabel("password");
		password.setBounds(219, 21, 61, 16);
		contentPane.add(password);
		
		JLabel lblNewLabel_4 = new JLabel("age");
		lblNewLabel_4.setBounds(219, 75, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("e-mail");
		lblNewLabel_5.setBounds(219, 123, 61, 16);
		contentPane.add(lblNewLabel_5);
		

		
	}
	
	public boolean passwordcheck(String password) {
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=.,]).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
        
		
	}
	
	/*
	 * Name validator
	 */
	public boolean namecheck(String name) {
		
		String regex = "^[a-zA-Z]{3,}$";
        return name.matches(regex);
	}
	/*
	 * SurName validator
	 */
	public boolean surnamecheck(String surname) {
		
	
		String regex = "^[a-zA-Z]{3,}$";
        return surname.matches(regex);
	}
	/*
	 * UserName validator
	 */
	public boolean usernamecheck(String username) {
		
		String regex = "^[a-zA-Z0-9]+$";
		return username.matches(regex);
	}
	/*
	 * age validator
	 */
	public static boolean agecheck(String age) {
       
		int agee = Integer.parseInt(age);
		return agee >= 12;
    }
	/*
	 * mail validator
	 */
	public static boolean mailcheck(String email) {
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
	
	    Pattern pattern = Pattern.compile(regex);
	
	    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
	}
	
	/*
	 * validates all information provided and checks whether mail or username exist or not
	 */
	
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()== Register) {
				if(!idPassword.email.contains(email.getText()) && !idPassword.username.contains(usernameField.getText())) {
					if(passwordcheck(passwordField.getText()) && namecheck(nameField.getText()) && surnamecheck(surnameField.getText()) && usernamecheck(usernameField.getText()) && agecheck(age.getText()) && mailcheck(email.getText())){
						messageLabel.setForeground(Color.green); 
						messageLabel.setText("yey");
						String username = usernameField.getText();
				        String password = passwordField.getText();
				        String name = nameField.getText();
				        String surname = surnameField.getText();
				        int userAge = Integer.parseInt(age.getText());
				        String userEmail = email.getText();
	
				        // Create User object with the provided information
				        User newone = new User(username, password, name, surname, userAge, userEmail, "/Users/burakerten/Desktop/NBA TEAMs/yourtteam.jpg");
				        newone.writeToUserFile();
				        Users.allUsers.allUsers.add(newone);
			 
						messageLabel.setForeground(Color.red); 
						messageLabel.setText(username);
						
						
						
						this.dispose();
						loginPage loginpage = new loginPage(idPassword.loginInfo);
						}
					else {
						messageLabel.setForeground(Color.red); 
						messageLabel.setText("there is/are improper input(s)");
						}
				}
				else {
					messageLabel.setForeground(Color.red); 
					messageLabel.setText("there is/are improper input(s)");
					}
		}
			
		}
		/*
		 * validates all information provided and checks whether mail or username exist or not end
		 */

}
