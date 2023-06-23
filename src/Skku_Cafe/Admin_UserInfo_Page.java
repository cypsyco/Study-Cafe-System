package Skku_Cafe;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;

class UserInfo_Board extends JPanel implements ActionListener {
	Font font;
	Admin_UserInfo_Page user_list_board = null;
	UserInfo user;
	int num = 0;

	JLabel num_LB;
	JLabel name_LB;
	JLabel mobile_LB;
	JLabel seatNum_LB;
	JLabel maxTime_LB;

	JButton checkOut_btn;

	public UserInfo_Board(int index, UserInfo user, Admin_UserInfo_Page panel) {
		this.user = user;
		user_list_board = panel;

		setLayout(null);

		int pos = index % panel.page_user_max;
		setBounds(100, 100 + pos * 100, 350, 80);
		setBackground(Color.white);
		num = index;

		font = new Font("Bahnschrift", Font.PLAIN, 10);

		num_LB = new JLabel();
		num_LB.setBounds(10, 10, 40, 30);
		num_LB.setFont(font);
		num_LB.setText((num + 1) + "");
		add(num_LB);
		
		//use getter methods of UserInfo to get informations about the user
		
		name_LB = new JLabel();
		name_LB.setBounds(30, 10, 80, 30);
		name_LB.setBackground(Color.white);
		name_LB.setFont(font);
		name_LB.setText(user.getName());
		name_LB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(name_LB);

		mobile_LB = new JLabel();
		mobile_LB.setBounds(30, 40, 120, 30);
		mobile_LB.setBackground(Color.white);
		mobile_LB.setFont(font);
		mobile_LB.setText(user.getMobile());
		mobile_LB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(mobile_LB);

		//if user has seat, print seat number, else, print X
		seatNum_LB = new JLabel();
		seatNum_LB.setBounds(130, 10, 80, 30);
		seatNum_LB.setBackground(Color.white);
		seatNum_LB.setFont(font);
		if (user.getSeatNum() != -1) {
			int SeatNum = user.getSeatNum() + 1;
			seatNum_LB.setText("Seat : " + SeatNum);
		} else {
			seatNum_LB.setText("Seat : X");
		}
		seatNum_LB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(seatNum_LB);

		//if user has left time, print hours, else, print X
		maxTime_LB = new JLabel();
		maxTime_LB.setBounds(130, 40, 120, 30);
		maxTime_LB.setBackground(Color.white);
		maxTime_LB.setFont(font);
		if (user.getMaxTime() != 0) {
			maxTime_LB.setText("Time remaining : " + user.getMaxTime() + " hours");
		} else {
			maxTime_LB.setText("Time remaining : X");
		}
		maxTime_LB.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(maxTime_LB);

		checkOut_btn = new JButton();
		checkOut_btn.setBounds(260, 26, 80, 30);
		checkOut_btn.setBackground(Color.LIGHT_GRAY);
		checkOut_btn.setFont(font);
		checkOut_btn.setText("force check out");
		checkOut_btn.addActionListener(this);
		checkOut_btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		add(checkOut_btn);
	}

	@Override
	//action performed method for force check out button
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == checkOut_btn && user.getSeatNum() != -1) {
			int result = JOptionPane.showConfirmDialog(null, "Force check out" + user.getName() + "?", "Message", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (FileManager.instance.checkOut(user.getMobile())) {
					JOptionPane.showMessageDialog(null, "Force check out completed", "Message", JOptionPane.INFORMATION_MESSAGE);
					Admin_UserInfo_Page userInfoPage = new Admin_UserInfo_Page();
					userInfoPage.setVisible(true);
			        setVisible(false);
				}
			}
		}
	}
}


public class Admin_UserInfo_Page extends JFrame {

	private JPanel contentPane;
	//define ArrayList of UserInfo and ArrayList of UserInfo_Board
	public ArrayList<UserInfo> user_list = FileManager.instance.userManager;
	public ArrayList<UserInfo_Board> user_board_list = new ArrayList<>();

	private int page_num = 1; //current page number
	public int page_user_max = 3; //Number of members to show on one page
	private int page_btn_max = 5; //Number of paging buttons to show on one page
	int page_min = 0; //current page starting number
	int page_max = 0; //current page last number
	
	private JLabel titleLabel;
	private JButton btnBack;
	private JButton right_btn_1;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_right;
	private JButton btn_left;
	private JButton backButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_UserInfo_Page frame = new Admin_UserInfo_Page();
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
	public Admin_UserInfo_Page() {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("User Information");
		titleLabel.setBounds(12, 10, 560, 25);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		contentPane.add(titleLabel);
		
		//buttons are to select the page number
		btn_1 = new JButton();
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 1;
				userListSet();
				
			}
		});
		btn_1.setText("1");
		btn_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_1.setBackground(Color.WHITE);
		btn_1.setBounds(192, 501, 50, 50);
		contentPane.add(btn_1);
		
		btn_2 = new JButton();
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 2;
				userListSet();
				
			}
		});
		btn_2.setText("2");
		btn_2.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_2.setBackground(Color.WHITE);
		btn_2.setBounds(242, 501, 50, 50);
		contentPane.add(btn_2);
		
		btn_3 = new JButton();
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 3;
				userListSet();
				
			}
		});
		btn_3.setText("3");
		btn_3.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_3.setBackground(Color.WHITE);
		btn_3.setBounds(292, 501, 50, 50);
		contentPane.add(btn_3);
		
		btn_4 = new JButton();
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 4;
				userListSet();
				
			}
		});
		btn_4.setText("4");
		btn_4.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_4.setBackground(Color.WHITE);
		btn_4.setBounds(342, 501, 50, 50);
		contentPane.add(btn_4);
		
		//move to rightmost page
		btn_right = new JButton();
		btn_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 4;
				userListSet();
				
			}
		});
		btn_right.setText(">");
		btn_right.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_right.setBackground(Color.WHITE);
		btn_right.setBounds(392, 501, 50, 50);
		contentPane.add(btn_right);
		
		//move to leftmost page
		btn_left = new JButton();
		btn_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_num = 1;
				userListSet();
				
			}
		});
		btn_left.setText("<");
		btn_left.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btn_left.setBackground(Color.WHITE);
		btn_left.setBounds(142, 501, 50, 50);
		contentPane.add(btn_left);
		
		backButton = new JButton();
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		userListSet();
	}
	
	public void userListSet() {
		Component[] componentList = contentPane.getComponents();

		//remove all instances of component list
		for (Component c : componentList) {
			if (c instanceof UserInfo_Board) {
				this.remove(c);
			}
		}
		
		//calculate index according to page number
		int start_index = (page_num - 1) * page_user_max;
		int total = user_list.size() - start_index;
		int count = page_user_max;

		if (total < page_user_max) {
			count = total;
		}
		
		//create new user board list
		user_board_list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			UserInfo_Board userBoard = new UserInfo_Board(i + start_index, user_list.get(start_index + i), this);
			getContentPane().add(userBoard); //add userBoard to component
			user_board_list.add(userBoard);
		}

		repaint();
	}
}
