package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Join_Page extends JFrame {

	private JPanel contentPane;
	private JLabel titleLabel;
	private JTextField nameTextField;
	private JTextField pnTextField;
	private JTextField pwTextField;
	private JButton submitButton;
	private JButton quitButton;
	private JTextField confirmTextField;
	boolean isChecked = false;
	private JCheckBox check;
	private JLabel nameLabel;
	private JLabel pnLabel;
	private JLabel pwLabel;
	private JLabel confirmLabel;
	
	//isValidPhoneNumber method is used to check if phone number is in right format
    public static boolean isValidPhoneNumber(String input) {
        if (input.length() != 11) {
            return false; //invalid if string is not of length 11
        }

        if (!input.startsWith("010")) {
            return false; //not valid if not starts with "010"
        }

        //Make sure all remaining digits are digits
        for (int i = 3; i < 11; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false; //invalid if contains non-numeric characters
            }
        }

        return true; //valid phone number if all conditions are satisfied
    }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_Page frame = new Join_Page();
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
	public Join_Page() {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("SIGN UP");
		titleLabel.setBounds(179, 49, 211, 52);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		contentPane.add(titleLabel);
		
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setBounds(179, 145, 211, 21);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		pnTextField = new JTextField();
		pnTextField.setHorizontalAlignment(SwingConstants.CENTER);
		pnTextField.setColumns(10);
		pnTextField.setBounds(179, 207, 211, 21);
		contentPane.add(pnTextField);
		
		pwTextField = new JTextField();
		pwTextField.setHorizontalAlignment(SwingConstants.CENTER);
		pwTextField.setColumns(10);
		pwTextField.setBounds(179, 268, 211, 21);
		contentPane.add(pwTextField);
		
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//when submit button is clicked, user input values are checked one by one using exception
				
				//check if there is empty value
				try {
					
					if (nameTextField.getText().equals("") || pnTextField.getText().equals("") || pwTextField.getText().equals("") || confirmTextField.getText().equals("")) {
						throw new JoinException("JoinException");
					}
				}
				//catch exception part shows error message dialog
				catch (JoinException eror1) {
					//show problem message dialog
					JOptionPane.showMessageDialog(null, "Input every field.");
					return;
				}
				
				//check if name is contains other than English
				try {
					
					if (!nameTextField.getText().matches("[a-zA-Z]+")) {
						throw new JoinException("JoinException");
					}
					
				}
				catch (JoinException eror1) {
					//show problem message dialog
					JOptionPane.showMessageDialog(null, "Name should be in english.");
					return;
				}
				
				//check if phone number is in right format '010xxxxxxxx'
				//check by isValidPhoneNumber method
				try {
					if (!isValidPhoneNumber(pnTextField.getText())){
						throw new JoinException("JoinException");
					}
					
				}
				catch (JoinException eror1) {
					//show problem message dialog
					JOptionPane.showMessageDialog(null, "phone number should be in format '010xxxxxxxx'");
					return;
				}
				
				
				//check if password and confirm password does not match
				try {
					if (!(pwTextField.getText().equals(confirmTextField.getText()))) {
						throw new JoinException("JoinException");
					}
				}
				catch (JoinException eror2) {
					JOptionPane.showMessageDialog(null, "Password does not match.");
					return;
				}
				
				//check if check box for privacy policy agreement is not checked
				try {
					if (!isChecked) {
						throw new JoinException("JoinException");
					}
				}
				catch (JoinException eror3) {
					JOptionPane.showMessageDialog(null, "Please check the privacy policy agreement.");
					return;
				}
				
				//check if there is another user with same phone number
				try {
					for (int i = 0; i < FileManager.instance.userManager.size(); i++) {
						if (pnTextField.getText().equals(FileManager.instance.userManager.get(i).getMobile())) {
							throw new JoinException("JoinException");
						}
					}
				}
				catch (JoinException eror3) {
					JOptionPane.showMessageDialog(null, "Account with same phone number found.");
					return;
				}
				
				UserInfo user = new UserInfo();
				user.setName(nameTextField.getText());
				user.setMobile(pnTextField.getText());
				user.setPw(pwTextField.getText());
				user.setSeatNum(0);
				user.setMaxTime(0);
				user.setPreTime("0");

				FileManager.instance.addUser(user);
				JOptionPane.showMessageDialog(null, "Successfully signed up.", "Message", JOptionPane.PLAIN_MESSAGE);
				Main_Page mainPage = new Main_Page();
		        mainPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		submitButton.setForeground(Color.WHITE);
		submitButton.setBackground(new Color(0, 128, 0));
		submitButton.setBounds(179, 439, 97, 46);
		contentPane.add(submitButton);
		
		quitButton = new JButton("QUIT");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main_Page mainPage = new Main_Page();
		        mainPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		quitButton.setForeground(Color.WHITE);
		quitButton.setBackground(new Color(0, 128, 0));
		quitButton.setBounds(293, 439, 97, 46);
		contentPane.add(quitButton);
		
		confirmTextField = new JTextField();
		confirmTextField.setHorizontalAlignment(SwingConstants.CENTER);
		confirmTextField.setColumns(10);
		confirmTextField.setBounds(179, 333, 211, 21);
		contentPane.add(confirmTextField);
		
		check = new JCheckBox("Privacy Statement Agree");
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//join is available only when privacy statement box is checked
				isChecked = true;
				
			}
		});
		check.setBackground(new Color(154, 205, 50));
		check.setBounds(178, 386, 212, 23);
		contentPane.add(check);
		
		nameLabel = new JLabel("Enter Name: ");
		nameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(12, 148, 155, 15);
		contentPane.add(nameLabel);
		
		pnLabel = new JLabel("Enter Phone Number: ");
		pnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pnLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pnLabel.setBounds(12, 210, 155, 15);
		contentPane.add(pnLabel);
		
		pwLabel = new JLabel("Enter Password: ");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pwLabel.setBounds(12, 271, 155, 15);
		contentPane.add(pwLabel);
		
		confirmLabel = new JLabel("Enter Password again: ");
		confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		confirmLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		confirmLabel.setBounds(12, 336, 155, 15);
		contentPane.add(confirmLabel);
	}
}
