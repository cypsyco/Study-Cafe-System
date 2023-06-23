package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seat_Page extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton updateButton;
	private JButton logoutButton;
	private String name;
	private static String dummy;
	private JLabel titleLable;
	private JLabel pnLabel;
	private JLabel lblNewLabel_3;
	private JButton seat1;
	private JButton seat5;
	private JButton seat2;
	private JButton seat6;
	private JButton seat3;
	private JButton seat7;
	private JButton seat15;
	private JButton seat4;
	private JButton seat8;
	private JButton seat9;
	private JButton seat13;
	private JButton seat10;
	private JButton seat11;
	private JButton seat12;
	private JButton seat14;
	private JButton seat16;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat_Page frame = new Seat_Page(dummy, dummy);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 * @param log 
	 */
	public Seat_Page(String name, String phoneNumber) {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		updateButton = new JButton("Update Info");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if user clicks Update Info button, set the page to update page
				Update_Page updatePage = new Update_Page(phoneNumber);
				updatePage.setVisible(true);
				
			}
		});
		updateButton.setForeground(new Color(255, 255, 255));
		updateButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		updateButton.setBackground(new Color(0, 128, 0));
		updateButton.setBounds(320, 28, 120, 40);
		contentPane.add(updateButton);
		
		logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if user clicks log out button, set the page to main page
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
		
		titleLable = new JLabel("Welcome Back!!! " + name);
		titleLable.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		titleLable.setForeground(new Color(255, 255, 255));
		titleLable.setHorizontalAlignment(SwingConstants.LEFT);
		titleLable.setBounds(12, 10, 296, 40);
		contentPane.add(titleLable);
		
		pnLabel = new JLabel("Phone Number: " + phoneNumber);
		pnLabel.setForeground(new Color(255, 255, 255));
		pnLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pnLabel.setBounds(12, 60, 296, 15);
		contentPane.add(pnLabel);
		
		lblNewLabel_3 = new JLabel("Seat Availability : " + seatUseState());
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNewLabel_3.setBounds(364, 139, 208, 25);
		contentPane.add(lblNewLabel_3);
		
		//implement action listener for each seats
		seat1 = new JButton("1");
		seat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//get isSeatUse information using FileManager by using index
				//index is seat number - 1 (temp - 1)
				int temp = Integer.parseInt(seat1.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				}
			});
		seat1.setForeground(new Color(255, 255, 255));
		seat1.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat1.setBackground(new Color(192, 192, 192));
		seat1.setBounds(214, 239, 40, 40);
		contentPane.add(seat1);
		
		seat5 = new JButton("5");
		seat5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat5.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat5.setForeground(Color.WHITE);
		seat5.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat5.setBackground(Color.LIGHT_GRAY);
		seat5.setBounds(295, 239, 40, 40);
		contentPane.add(seat5);
		
		seat2 = new JButton("2");
		seat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat2.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat2.setForeground(Color.WHITE);
		seat2.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat2.setBackground(Color.LIGHT_GRAY);
		seat2.setBounds(214, 289, 40, 40);
		contentPane.add(seat2);
		
		seat6 = new JButton("6");
		seat6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat6.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat6.setForeground(Color.WHITE);
		seat6.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat6.setBackground(Color.LIGHT_GRAY);
		seat6.setBounds(295, 289, 40, 40);
		contentPane.add(seat6);
		
		seat3 = new JButton("3");
		seat3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat3.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat3.setForeground(Color.WHITE);
		seat3.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat3.setBackground(Color.LIGHT_GRAY);
		seat3.setBounds(214, 339, 40, 40);
		contentPane.add(seat3);
		
		seat7 = new JButton("7");
		seat7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat7.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat7.setForeground(Color.WHITE);
		seat7.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat7.setBackground(Color.LIGHT_GRAY);
		seat7.setBounds(295, 339, 40, 40);
		contentPane.add(seat7);
		
		seat15 = new JButton("15");
		seat15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat15.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat15.setForeground(Color.WHITE);
		seat15.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat15.setBackground(Color.LIGHT_GRAY);
		seat15.setBounds(475, 339, 40, 40);
		contentPane.add(seat15);
		
		seat4 = new JButton("4");
		seat4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat4.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat4.setForeground(Color.WHITE);
		seat4.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat4.setBackground(Color.LIGHT_GRAY);
		seat4.setBounds(214, 389, 40, 40);
		contentPane.add(seat4);
		
		seat8 = new JButton("8");
		seat8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat8.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat8.setForeground(Color.WHITE);
		seat8.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat8.setBackground(Color.LIGHT_GRAY);
		seat8.setBounds(295, 389, 40, 40);
		contentPane.add(seat8);
		
		seat9 = new JButton("9");
		seat9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat9.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat9.setForeground(Color.WHITE);
		seat9.setFont(new Font("Bahnschrift", Font.BOLD, 10));
		seat9.setBackground(Color.LIGHT_GRAY);
		seat9.setBounds(390, 239, 40, 40);
		contentPane.add(seat9);
		
		seat13 = new JButton("13");
		seat13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat13.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat13.setForeground(Color.WHITE);
		seat13.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat13.setBackground(Color.LIGHT_GRAY);
		seat13.setBounds(475, 239, 40, 40);
		contentPane.add(seat13);
		
		seat10 = new JButton("10");
		seat10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat10.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat10.setForeground(Color.WHITE);
		seat10.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat10.setBackground(Color.LIGHT_GRAY);
		seat10.setBounds(390, 289, 40, 40);
		contentPane.add(seat10);
		
		seat11 = new JButton("11");
		seat11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat11.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat11.setForeground(Color.WHITE);
		seat11.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat11.setBackground(Color.LIGHT_GRAY);
		seat11.setBounds(390, 339, 40, 40);
		contentPane.add(seat11);
		
		seat12 = new JButton("12");
		seat12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat12.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat12.setForeground(Color.WHITE);
		seat12.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat12.setBackground(Color.LIGHT_GRAY);
		seat12.setBounds(390, 389, 40, 40);
		contentPane.add(seat12);
		
		seat14 = new JButton("14");
		seat14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat14.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat14.setForeground(Color.WHITE);
		seat14.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat14.setBackground(Color.LIGHT_GRAY);
		seat14.setBounds(475, 289, 40, 40);
		contentPane.add(seat14);
		
		seat16 = new JButton("16");
		seat16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int temp = Integer.parseInt(seat16.getText());
				if (FileManager.instance.seatManager.get(temp - 1).isSeatUse()) {
					JOptionPane.showMessageDialog(null, "This seat is in use.", "Message", JOptionPane.INFORMATION_MESSAGE);
					}
				else {
					Select_Page selectPage = new Select_Page(name, phoneNumber, temp - 1);
			        selectPage.setVisible(true);
			        setVisible(false);
			        }
				
			}
		});
		seat16.setForeground(Color.WHITE);
		seat16.setFont(new Font("Bahnschrift", Font.BOLD, 7));
		seat16.setBackground(Color.LIGHT_GRAY);
		seat16.setBounds(475, 389, 40, 40);
		contentPane.add(seat16);
		
		//if seat is in use, make the color of the seat button black
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat1.getText()) - 1).isSeatUse()) {
			seat1.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat2.getText()) - 1).isSeatUse()) {
			seat2.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat3.getText()) - 1).isSeatUse()) {
			seat3.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat4.getText()) - 1).isSeatUse()) {
			seat4.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat5.getText()) - 1).isSeatUse()) {
			seat5.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat6.getText()) - 1).isSeatUse()) {
			seat6.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat7.getText()) - 1).isSeatUse()) {
			seat7.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat8.getText()) - 1).isSeatUse()) {
			seat8.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat9.getText()) - 1).isSeatUse()) {
			seat9.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat10.getText()) - 1).isSeatUse()) {
			seat10.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat11.getText()) - 1).isSeatUse()) {
			seat11.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat12.getText()) - 1).isSeatUse()) {
			seat12.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat13.getText()) - 1).isSeatUse()) {
			seat13.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat14.getText()) - 1).isSeatUse()) {
			seat14.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat15.getText()) - 1).isSeatUse()) {
			seat15.setBackground(Color.black);
		}
		
		if (FileManager.instance.seatManager.get(Integer.parseInt(seat16.getText()) - 1).isSeatUse()) {
			seat16.setBackground(Color.black);
		}
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Seat_Page.class.getResource("/image/seat_image.png")));
		lblNewLabel.setBounds(0, 95, 584, 466);
		contentPane.add(lblNewLabel);
	}
	
	String seatUseState() {
		String state = "";
		int check = 0;
		for (int i = 0; i < FileManager.instance.seatManager.size(); i++) {
			if (!FileManager.instance.seatManager.get(i).isSeatUse()) {
				check += 1;
			}
		}
		state = check + "/" + FileManager.instance.seatManager.size();
		return state;
	}
}
