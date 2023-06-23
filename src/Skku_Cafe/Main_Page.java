package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Skku_Cafe.FileManager;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Main_Page extends JFrame {

	private JPanel contentPane;
	private JLabel skkuLabel;
	private JLabel titleLabel;
	private JLabel loginLabel;
	private JTextField pnTextField;
	private JLabel pnLabel;
	private JTextField pwTextField;
	private JLabel pwLabel;
	private JButton loginButton;
	private JButton leaveButton;
	private JButton joinButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FileManager.instance.loadData();
		FileManager.instance.loadSeatData();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Page frame = new Main_Page();
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
	public Main_Page() {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		skkuLabel = new JLabel("");
		skkuLabel.setIcon(new ImageIcon(Main_Page.class.getResource("/image/skku.png")));
		skkuLabel.setBounds(12, 10, 210, 100);
		contentPane.add(skkuLabel);
		
		titleLabel = new JLabel("SKKU STUDY CAFE");
		titleLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		titleLabel.setBounds(253, 10, 319, 100);
		contentPane.add(titleLabel);
		
		loginLabel = new JLabel("LOG IN");
		loginLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setBounds(211, 137, 142, 46);
		contentPane.add(loginLabel);
		
		pnTextField = new JTextField();
		pnTextField.setBounds(237, 193, 213, 46);
		contentPane.add(pnTextField);
		pnTextField.setColumns(10);
		
		pnLabel = new JLabel("PHONE NUMBER:");
		pnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pnLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		pnLabel.setBounds(12, 192, 190, 46);
		contentPane.add(pnLabel);
		
		pwTextField = new JTextField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(237, 267, 213, 46);
		contentPane.add(pwTextField);
		
		pwLabel = new JLabel("PASSWORD:");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		pwLabel.setBounds(12, 266, 190, 46);
		contentPane.add(pwLabel);
		
		loginButton = new JButton("LOG IN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if phone number is 0 and password is 0, it is administrator account
				//page is set to administrator page
				if (pnTextField.getText().equals("0") && pwTextField.getText().equals("0")) {
					Admin_Page adminPage = new Admin_Page();
			        adminPage.setVisible(true);
			        setVisible(false);
				} else {
					//using file manager, system checks if phone number and password is valid
					String log = FileManager.instance.login(pnTextField.getText(), pwTextField.getText());
					//if not valid, show the dialog
					if (log.equals("")) {
						JOptionPane.showMessageDialog(null, "Phone number does not exist.", "Message", JOptionPane.WARNING_MESSAGE);
					//if valid, go to seat page
					} else {
						Seat_Page seatPage = new Seat_Page(log, pnTextField.getText());
				        seatPage.setVisible(true);
				        setVisible(false);
					}
				}
				
			}
		});
		loginButton.setBackground(new Color(0, 128, 0));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBounds(125, 384, 97, 46);
		contentPane.add(loginButton);
		
		leaveButton = new JButton("LEAVE");
		leaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if leave button is clicked, it means user is trying to return the seat and check out
				String log = FileManager.instance.login(pnTextField.getText(), pwTextField.getText());
				if (log.equals("")) {
					JOptionPane.showMessageDialog(null, "Phone number does not exist.", "Message", JOptionPane.WARNING_MESSAGE);
				} else {
					if (FileManager.instance.checkOut(pnTextField.getText())) {
						JOptionPane.showMessageDialog(null, "You have successfully checked out.", "Message", JOptionPane.INFORMATION_MESSAGE);
						Main_Page mainPage = new Main_Page();
				        mainPage.setVisible(true);
				        setVisible(false);
					}
				}
				
			}
		});
		leaveButton.setForeground(Color.WHITE);
		leaveButton.setBackground(new Color(0, 128, 0));
		leaveButton.setBounds(353, 384, 97, 46);
		contentPane.add(leaveButton);
		
		joinButton = new JButton("JOIN");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if join button is clicked, join page is open
				Join_Page joinPage = new Join_Page();
		        joinPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		joinButton.setForeground(Color.WHITE);
		joinButton.setBackground(new Color(0, 128, 0));
		joinButton.setBounds(244, 384, 97, 46);
		contentPane.add(joinButton);
	}
}
