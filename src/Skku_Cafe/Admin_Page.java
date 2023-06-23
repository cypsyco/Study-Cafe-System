package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Page extends JFrame {

	private JPanel contentPane;
	private JLabel titleLabel;
	private JButton userInfoButton;
	private JButton seatInfoButton;
	private JButton offButton;
	private JButton mainButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Page frame = new Admin_Page();
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
	public Admin_Page() {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("ADMIN PAGE");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(12, 40, 560, 35);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 30));
		contentPane.add(titleLabel);
		
		userInfoButton = new JButton("User Information");
		userInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if user information button is clicked, open admin user information page
				Admin_UserInfo_Page userInfoPage = new Admin_UserInfo_Page();
				userInfoPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		userInfoButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		userInfoButton.setBackground(new Color(255, 255, 255));
		userInfoButton.setBounds(100, 154, 170, 150);
		contentPane.add(userInfoButton);
		
		seatInfoButton = new JButton("Seat Information");
		seatInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if seat information button is clicked, open admin seat information page
				Admin_SeatInfo_Page seatInfoPage = new Admin_SeatInfo_Page();
				seatInfoPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		seatInfoButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		seatInfoButton.setBackground(Color.WHITE);
		seatInfoButton.setBounds(330, 154, 170, 150);
		contentPane.add(seatInfoButton);
		
		offButton = new JButton("System Off");
		offButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//exit if system off button is clicked
				System.exit(0);
				
			}
		});
		offButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		offButton.setBackground(Color.WHITE);
		offButton.setBounds(100, 314, 170, 150);
		contentPane.add(offButton);
		
		mainButton = new JButton("Main Page");
		mainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//go to main page if main page button is clicked
				Main_Page mainPage = new Main_Page();
		        mainPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		mainButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		mainButton.setBackground(Color.WHITE);
		mainButton.setBounds(330, 314, 170, 150);
		contentPane.add(mainButton);
	}

}
