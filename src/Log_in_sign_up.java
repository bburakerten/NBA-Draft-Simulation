import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class Log_in_sign_up extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private final Action action = new SwingAction();
	private JTextField name;
	private JTextField surname;
	private JTextField password;
	private JTextField age;
	private JTextField email;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_in_sign_up frame = new Log_in_sign_up();
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
	public Log_in_sign_up() {
		setTitle("login signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Sign up");

		
		Label label = new Label("username");
		label.setBackground(new Color(238, 238, 238));
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label.setBounds(44, 30, 204, 16);
		contentPane.add(label);
		btnNewButton.setBounds(246, 125, 117, 29);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setBounds(44, 52, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(44, 151, 130, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		Label label_1 = new Label("name");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_1.setBackground(UIManager.getColor("Button.background"));
		label_1.setBounds(44, 84, 204, 16);
		contentPane.add(label_1);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(44, 106, 130, 26);
		contentPane.add(surname);
		
		Label label_1_1 = new Label("surname");
		label_1_1.setForeground(Color.BLACK);
		label_1_1.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_1_1.setBackground(UIManager.getColor("Button.background"));
		label_1_1.setBounds(44, 138, 204, 16);
		contentPane.add(label_1_1);
		
		Label label_1_1_1 = new Label("username");
		label_1_1_1.setForeground(Color.BLACK);
		label_1_1_1.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_1_1_1.setBackground(UIManager.getColor("Button.background"));
		label_1_1_1.setBounds(44, 161, 204, 16);
		contentPane.add(label_1_1_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(44, 211, 130, 26);
		contentPane.add(password);
		
		Label label_1_1_2 = new Label("email");
		label_1_1_2.setForeground(Color.BLACK);
		label_1_1_2.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_1_1_2.setBackground(UIManager.getColor("Button.background"));
		label_1_1_2.setBounds(44, 297, 204, 16);
		contentPane.add(label_1_1_2);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(44, 265, 130, 26);
		contentPane.add(age);
		
		Label label_1_2 = new Label("age");
		label_1_2.setForeground(Color.BLACK);
		label_1_2.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_1_2.setBackground(UIManager.getColor("Button.background"));
		label_1_2.setBounds(44, 243, 204, 16);
		contentPane.add(label_1_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(44, 313, 130, 26);
		contentPane.add(email);
		
		Label label_2 = new Label("password");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Al Bayan", Font.BOLD, 14));
		label_2.setBackground(UIManager.getColor("Button.background"));
		label_2.setBounds(44, 189, 204, 16);
		contentPane.add(label_2);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showwindow();
			}

			private void showwindow() {
				// TODO Auto-generated method stub
				JFrame frame = new JFrame ("WINDOW 1");
				frame. setBounds (100,100,100, 100);
				frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame. getContentPane(). setLayout (null);
				frame. setVisible(true);
		}

			
		});
	}
}
