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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Admin_SeatInfo_Page extends JFrame {

	private JPanel contentPane;
	private JLabel titleLable;
	private JButton backButton;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JLabel nameLabel;
	private JLabel pnLabel;
	private JLabel startTimeLabel;
	private JLabel endTimeLabel;
	private JTextField nameTextField;
	private JTextField pnTextField;
	private JTextField startTextField;
	private JTextField endTextField;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_10;
	private JButton btn_11;
	private JButton btn_12;
	private JButton btn_13;
	private JButton btn_14;
	private JButton btn_15;
	private JButton btn_16;
	
	ArrayList<UserInfo> user_list = FileManager.instance.userManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_SeatInfo_Page frame = new Admin_SeatInfo_Page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//get user end time using FileManager
	String endTime(UserInfo user) {
		String endTime = "";
		if (!user.getPreTime().equals("0")) {
			Date date = null;
			try {
				date = FileManager.instance.format.parse(user.getPreTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.HOUR, user.getMaxTime());
			endTime = FileManager.instance.format.format(cal.getTime());
		}
		return endTime;
	}

	/**
	 * Create the frame.
	 */
	public Admin_SeatInfo_Page() {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLable = new JLabel("Seat Information");
		titleLable.setBounds(12, 10, 560, 25);
		titleLable.setHorizontalAlignment(SwingConstants.CENTER);
		titleLable.setForeground(Color.WHITE);
		titleLable.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		contentPane.add(titleLable);
		
		backButton = new JButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if back button is clicked, go back to admin page
				Admin_Page adminPage = new Admin_Page();
		        adminPage.setVisible(true);
		        setVisible(false);
				
			}
		});
		backButton.setText("Back");
		backButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		backButton.setBackground(Color.WHITE);
		backButton.setBounds(454, 501, 118, 50);
		contentPane.add(backButton);
		
		//for each button, get seat's information using getter methods of User Info
		btn_1 = new JButton("1");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_1.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_1.setBounds(172, 215, 50, 50);
		contentPane.add(btn_1);
		
		btn_2 = new JButton("2");
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_2.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_2.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_2.setBounds(234, 215, 50, 50);
		contentPane.add(btn_2);
		
		btn_3 = new JButton("3");
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_3.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_3.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_3.setBounds(296, 215, 50, 50);
		contentPane.add(btn_3);
		
		btn_4 = new JButton("4");
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_4.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_4.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_4.setBounds(358, 215, 50, 50);
		contentPane.add(btn_4);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		nameLabel.setForeground(new Color(255, 255, 255));
		nameLabel.setBounds(75, 45, 93, 15);
		contentPane.add(nameLabel);
		
		pnLabel = new JLabel("Phone Number:");
		pnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pnLabel.setForeground(Color.WHITE);
		pnLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pnLabel.setBounds(75, 70, 93, 15);
		contentPane.add(pnLabel);
		
		startTimeLabel = new JLabel("Start Time:");
		startTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		startTimeLabel.setForeground(Color.WHITE);
		startTimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		startTimeLabel.setBounds(75, 95, 93, 15);
		contentPane.add(startTimeLabel);
		
		endTimeLabel = new JLabel("End Time:");
		endTimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		endTimeLabel.setForeground(Color.WHITE);
		endTimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		endTimeLabel.setBounds(75, 120, 93, 15);
		contentPane.add(endTimeLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		nameTextField.setEnabled(false);
		nameTextField.setEditable(false);
		nameTextField.setBounds(180, 41, 228, 21);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		pnTextField = new JTextField();
		pnTextField.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pnTextField.setEnabled(false);
		pnTextField.setEditable(false);
		pnTextField.setColumns(10);
		pnTextField.setBounds(180, 67, 228, 21);
		contentPane.add(pnTextField);
		
		startTextField = new JTextField();
		startTextField.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		startTextField.setEnabled(false);
		startTextField.setEditable(false);
		startTextField.setColumns(10);
		startTextField.setBounds(180, 91, 228, 21);
		contentPane.add(startTextField);
		
		endTextField = new JTextField();
		endTextField.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		endTextField.setEnabled(false);
		endTextField.setEditable(false);
		endTextField.setColumns(10);
		endTextField.setBounds(180, 116, 228, 21);
		contentPane.add(endTextField);
		
		btn_5 = new JButton("5");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_5.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_5.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_5.setBounds(172, 275, 50, 50);
		contentPane.add(btn_5);
		
		btn_6 = new JButton("6");
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_6.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_6.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_6.setBounds(234, 275, 50, 50);
		contentPane.add(btn_6);
		
		btn_7 = new JButton("7");
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_7.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_7.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_7.setBounds(296, 275, 50, 50);
		contentPane.add(btn_7);
		
		btn_8 = new JButton("8");
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_8.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_8.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_8.setBounds(358, 275, 50, 50);
		contentPane.add(btn_8);
		
		btn_9 = new JButton("9");
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_9.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_9.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_9.setBounds(172, 335, 50, 50);
		contentPane.add(btn_9);
		
		btn_10 = new JButton("10");
		btn_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_10.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_10.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_10.setBounds(234, 335, 50, 50);
		contentPane.add(btn_10);
		
		btn_11 = new JButton("11");
		btn_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_11.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_11.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_11.setBounds(296, 335, 50, 50);
		contentPane.add(btn_11);
		
		btn_12 = new JButton("12");
		btn_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_12.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_12.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_12.setBounds(358, 335, 50, 50);
		contentPane.add(btn_12);
		
		btn_13 = new JButton("13");
		btn_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_13.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_13.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_13.setBounds(172, 395, 50, 50);
		contentPane.add(btn_13);
		
		btn_14 = new JButton("14");
		btn_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_14.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_14.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_14.setBounds(234, 395, 50, 50);
		contentPane.add(btn_14);
		
		btn_15 = new JButton("15");
		btn_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_15.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_15.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_15.setBounds(296, 395, 50, 50);
		contentPane.add(btn_15);
		
		btn_16 = new JButton("16");
		btn_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean found = false;
				int temp = Integer.parseInt(btn_16.getText());
				
				for (int j = 0; j < user_list.size(); j++) {
					if (user_list.get(j).getSeatNum() == temp-1) {
						found = true;
						UserInfo user = user_list.get(j);
						nameTextField.setText(user.getName());
						pnTextField.setText(user.getMobile());
						startTextField.setText(user.getPreTime());
						endTextField.setText(endTime(user));
					}
				}
				
				if (!found) {
					nameTextField.setText("Empty Seat");
					pnTextField.setText("Empty Seat");
					endTextField.setText("Empty Seat");
					startTextField.setText("Empty Seat");
				}
				
			}
		});
		btn_16.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_16.setBounds(358, 395, 50, 50);
		contentPane.add(btn_16);
	}

}
