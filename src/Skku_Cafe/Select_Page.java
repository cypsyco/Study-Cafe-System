package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;

public class Select_Page extends JFrame {

	private JPanel contentPane;
	private static String dummy;
	private static int intdummy;
	private JLabel hoursLabel;
	private JLabel confirmLabel;
	private JLabel lblNewLabel;
	private JRadioButton hour_2;
	private JRadioButton hour_4;
	private JRadioButton hour_6;
	private JRadioButton hour_8;
	private JRadioButton hour_10;
	private JRadioButton hour_12;
	private JLabel totalPrice_LB;
	private JLabel seatNum_LB;
	private JLabel useTime_LB;
	private JButton nextButton;
	private String useTime;
	private int price;
	private JLabel guideLabel;
	private JButton logoutButton;
	private JButton viewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Page frame = new Select_Page(dummy, dummy, intdummy);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int priceReturn(String text) {
		price = Integer.parseInt(text) * 1000;
		return price;
	}

	/**
	 * Create the frame.
	 * @param i 
	 * @param moblie 
	 * @param name 
	 */
	public Select_Page(String name, String phoneNumber, int seatNum) {
		setTitle("SKKU study cafe");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		hoursLabel = new JLabel("[1] Select Hours");
		hoursLabel.setForeground(Color.BLACK);
		hoursLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		hoursLabel.setBounds(12, 130, 260, 30);
		contentPane.add(hoursLabel);
		
		confirmLabel = new JLabel("[2] Confirm");
		confirmLabel.setForeground(Color.BLACK);
		confirmLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		confirmLabel.setBounds(12, 336, 150, 30);
		contentPane.add(confirmLabel);
		
		//for each radio button, get use time as button text value
		//calculate use time and price using the value
		hour_2 = new JRadioButton("2");
		hour_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_2.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_2.setBackground(new Color(255, 255, 255));
		hour_2.setBounds(8, 166, 80, 23);
		contentPane.add(hour_2);
		
		hour_4 = new JRadioButton("4");
		hour_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_4.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_4.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_4.setBackground(Color.WHITE);
		hour_4.setBounds(8, 191, 80, 23);
		contentPane.add(hour_4);
		
		hour_6 = new JRadioButton("6");
		hour_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_6.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_6.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_6.setBackground(Color.WHITE);
		hour_6.setBounds(8, 216, 80, 23);
		contentPane.add(hour_6);
		
		hour_8 = new JRadioButton("8");
		hour_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_8.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_8.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_8.setBackground(Color.WHITE);
		hour_8.setBounds(8, 241, 80, 23);
		contentPane.add(hour_8);
		
		hour_10 = new JRadioButton("10");
		hour_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_10.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_10.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_10.setBackground(Color.WHITE);
		hour_10.setBounds(8, 266, 80, 23);
		contentPane.add(hour_10);
		
		hour_12 = new JRadioButton("12");
		hour_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int seat = seatNum + 1;
				
				useTime = hour_12.getText();
				seatNum_LB.setText("Seat Number: " + seat);
				useTime_LB.setText("Use Time: " + useTime);
				totalPrice_LB.setText("Payment: " + priceReturn(useTime) + "won");
				confirmLabel.setVisible(true);
				seatNum_LB.setVisible(true);
				useTime_LB.setVisible(true);
				totalPrice_LB.setVisible(true);
				nextButton.setVisible(true);
				
			}
		});
		hour_12.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		hour_12.setBackground(Color.WHITE);
		hour_12.setBounds(8, 291, 80, 23);
		contentPane.add(hour_12);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(hour_2);
		buttonGroup.add(hour_4);
		buttonGroup.add(hour_6);
		buttonGroup.add(hour_8);
		buttonGroup.add(hour_10);
		buttonGroup.add(hour_12);
		
		totalPrice_LB = new JLabel("");
		totalPrice_LB.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		totalPrice_LB.setBounds(12, 426, 150, 15);
		contentPane.add(totalPrice_LB);
		
		seatNum_LB = new JLabel("");
		seatNum_LB.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		seatNum_LB.setBounds(12, 376, 150, 15);
		contentPane.add(seatNum_LB);
		
		useTime_LB = new JLabel("");
		useTime_LB.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		useTime_LB.setBounds(12, 401, 150, 15);
		contentPane.add(useTime_LB);
		
		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//open payment page, passing use time and price information with user information
				Payment_Page paymentPage = new Payment_Page(name, phoneNumber, seatNum, useTime, price);
		        paymentPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		nextButton.setForeground(Color.WHITE);
		nextButton.setBackground(new Color(0, 128, 0));
		nextButton.setBounds(12, 451, 97, 46);
		contentPane.add(nextButton);
		
		guideLabel = new JLabel("Select Hours, " + name);
		guideLabel.setHorizontalAlignment(SwingConstants.LEFT);
		guideLabel.setForeground(Color.WHITE);
		guideLabel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		guideLabel.setBounds(12, 28, 296, 40);
		contentPane.add(guideLabel);
		
		logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main_Page mainPage = new Main_Page();
		        mainPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		logoutButton.setBackground(new Color(0, 128, 0));
		logoutButton.setBounds(452, 28, 120, 40);
		contentPane.add(logoutButton);
		
		viewButton = new JButton("View Seat");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Seat_Page seatPage = new Seat_Page(name, phoneNumber);
		        seatPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		viewButton.setForeground(Color.WHITE);
		viewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		viewButton.setBackground(new Color(0, 128, 0));
		viewButton.setBounds(320, 28, 120, 40);
		contentPane.add(viewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Select_Page.class.getResource("/image/character_background.png")));
		lblNewLabel.setBounds(0, 95, 584, 466);
		contentPane.add(lblNewLabel);
		
		confirmLabel.setVisible(false);
		seatNum_LB.setVisible(false);
		useTime_LB.setVisible(false);
		totalPrice_LB.setVisible(false);
		nextButton.setVisible(false);
	}
}
