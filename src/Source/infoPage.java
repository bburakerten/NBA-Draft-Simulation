package Source;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class infoPage extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	private JPanel contentPane;
	JButton mailButton = new JButton("Change Mail");
	JButton passwordButton = new JButton("Change Password");
	JButton continueButton = new JButton("Continue");
	private JTextField mailField = new JTextField();
	JTextField passwordField = new JTextField();
	JLabel messageLabel = new JLabel();
	private JLabel lblNewLabel_5_1_2_3;
	private JLabel lblNewLabel_5_1_2_1;
	JLabel photoLabel = new JLabel("");
    private JButton changeButton;


	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String testUsername = "testUser";
					infoPage frame = new infoPage(testUsername);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * logged in user is set as currentuser in the whole class therefore it is easier to navigate user informations
	 */
	static Users.User currentUser;
	
	public static String getCurrent() {
		return currentUser.getUserName();
	}

	
	/**
	 * Create the frame.
	 */
	public infoPage(String username) {
		for (Users.User user : Users.allUsers.getAllUsers()) {
			
			if (user.getUserName().equals(username)) {
				
				currentUser = user;

				break;
			} else {
				
				System.out.println("No such user");
			}
			
		}
		

			photoLabel.setIcon(new ImageIcon(currentUser.getUserlogo()));
		
        changeButton = new JButton("Change Photo");
        changeButton.addActionListener(this);
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		 contentPane.add(photoLabel);
	     contentPane.add(changeButton);
	     photoLabel.setBounds(601, 21,61,56); 
		 changeButton.setBounds(573, 89,121,25); 



		mailButton.setBounds(379, 74,121,25); 
		mailButton.addActionListener(this);
		contentPane.add(mailButton);
		
		passwordButton.setBounds(379, 168,150,25); 
		passwordButton.addActionListener(this);
		contentPane.add(passwordButton);
		
		continueButton.setBounds(277, 221,100,25); 
		continueButton.addActionListener(this);
		contentPane.add(continueButton);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(28, 21, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(28, 77, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("surname");
		lblNewLabel_2.setBounds(28, 146, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setBounds(183, 77, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email");
		lblNewLabel_4.setBounds(183, 21, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("age");
		lblNewLabel_3_1.setBounds(183, 146, 61, 16);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5 = new JLabel(currentUser.getUserName());
		lblNewLabel_5.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(28, 49, 121, 16);
		contentPane.add(lblNewLabel_5);
		
		
		JLabel lblNewLabel_5_1 = new JLabel(currentUser.getSurname());
		lblNewLabel_5_1.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5_1.setBounds(28, 174, 121, 16);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel(currentUser.getRealName());
		lblNewLabel_5_1_1.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5_1_1.setBounds(28, 95, 130, 16);
		contentPane.add(lblNewLabel_5_1_1);
		
		lblNewLabel_5_1_2_3 = new JLabel(currentUser.getEmailAddress());
		lblNewLabel_5_1_2_3.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5_1_2_3.setBounds(183, 49, 200, 16);
		contentPane.add(lblNewLabel_5_1_2_3);

		lblNewLabel_5_1_2_1 = new JLabel(currentUser.getPassword());
		lblNewLabel_5_1_2_1.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5_1_2_1.setBounds(183, 98, 138, 16);
		contentPane.add(lblNewLabel_5_1_2_1);
		
		JLabel lblNewLabel_5_1_2_2 = new JLabel(String.valueOf(currentUser.getAge()));
		lblNewLabel_5_1_2_2.setFont(new Font("Al Nile", Font.ITALIC, 12));
		lblNewLabel_5_1_2_2.setBounds(183, 171, 61, 16);
		contentPane.add(lblNewLabel_5_1_2_2);
		
		mailField.setBounds(381, 41, 130, 26);
		contentPane.add(mailField);
		mailField.setColumns(10);
		
		messageLabel.setBounds(389, 205, 284, 26);
		messageLabel.setFont(new Font(null,Font.ITALIC,12));
		contentPane.add(messageLabel);

		
		passwordField.setBounds(381, 141, 130, 26);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Change Mail");
		lblNewLabel_6.setBounds(385, 21, 115, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Change Password");
		lblNewLabel_6_1.setBounds(385, 124, 115, 16);
		contentPane.add(lblNewLabel_6_1);
		
		
		
		}
	/*checks the user's new mail if user wants to change its mail
	 * 
	 */
	public static boolean mailcheck(String email) {
		String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
	
	    Pattern pattern = Pattern.compile(regex);
	
	    Matcher matcher = pattern.matcher(email);
		    return matcher.matches();
	}
	
	/*checks the user's new password if user wants to change its password
	 * 
	 */
	public boolean passwordcheck(String password) {
		String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&+=.,]).{8,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
        
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == changeButton) {
            // Open a file chooser to select a new photo
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this);

            // If a file is selected, update the photoLabel
            if (result == JFileChooser.APPROVE_OPTION) {
                String selectedImagePath = fileChooser.getSelectedFile().getAbsolutePath();
                ImageIcon newPhoto = new ImageIcon(selectedImagePath);
                currentUser.setUserlogo(selectedImagePath);
                photoLabel.setIcon(newPhoto);
            }
        }
		// TODO Auto-generated method stub
		/*
		 * if mailcheck method validates the mail mail changes else proper message displayed
		 */
		if(e.getSource()== mailButton) {
			if(mailcheck(mailField.getText())) {
				if(!idPassword.email.contains(mailField.getText())) {
		        contentPane.remove(lblNewLabel_5_1_2_3);
				currentUser.setEmailAddress(mailField.getText());
				lblNewLabel_5_1_2_3 = new JLabel(currentUser.getEmailAddress());
				lblNewLabel_5_1_2_3.setFont(new Font("Al Nile", Font.ITALIC, 12));
				lblNewLabel_5_1_2_3.setBounds(183, 49, 61, 16);
				contentPane.add(lblNewLabel_5_1_2_3);
				Users.allUsers.allUsers.add(currentUser);
				contentPane.revalidate();
			    contentPane.repaint();
				}
				else {
					messageLabel.setForeground(Color.red); 
					messageLabel.setText("this email address is already active");
				}
				
			}
			else {
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("write a valid mail address");
			}
		}
		if(e.getSource()== passwordButton) {
			if(passwordcheck(passwordField.getText())) {
				contentPane.remove(lblNewLabel_5_1_2_1);
				currentUser.setPassword(passwordField.getText());;
				lblNewLabel_5_1_2_1 = new JLabel(currentUser.getPassword());
				lblNewLabel_5_1_2_1.setFont(new Font("Al Nile", Font.ITALIC, 12));
				lblNewLabel_5_1_2_1.setBounds(183, 92, 61, 16);
				contentPane.add(lblNewLabel_5_1_2_1);
				contentPane.revalidate();
			    contentPane.repaint();
			}
			else {
				messageLabel.setForeground(Color.red); 
				messageLabel.setText("write a valid password");
			}
		}
		/*opens mainpage
		 * 
		 */
		if(e.getSource()== continueButton) {
			this.dispose();
			mainPage menu = new mainPage();
			menu.setVisible(true);
		
			}
		}
	}		

