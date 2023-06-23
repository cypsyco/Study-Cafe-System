package Skku_Cafe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Payment_Page extends JFrame {

	private JPanel contentPane;
	private static String dummy;
	private static int intdummy;
	private JLabel lblNewLabel;
	private JLabel guideLabel;
	private JButton viewButton;
	private JButton logoutButton;
	private JLabel summaryLabel;
	private JLabel seatLabel;
	private JLabel useTimeLabel;
	private JLabel priceLabel;
	private JLabel startTimeLabel;
	private JLabel paymentLabel;
	private JButton cashButton;
	private JButton cardButton;
	private JLabel inputMoneyLabel;
	private JTextField inputTextField;
	private JButton btn_1000;
	private JButton btn_5000;
	private JButton btn_10000;
	private int inputMoney;
	private JButton cancelButton;
	private JButton payButton;
	private JLabel remainLabel;
	private JLabel timeLabel;
	
	private SwingWorker worker; //define worker as global variable, so that it can be used everywhere.
	int time; //time variable indicates remaining time for payment
	private boolean stopThread = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment_Page frame = new Payment_Page(dummy, dummy, intdummy, dummy, intdummy);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//purchase method determines the purchase comparing input money and price
	public boolean purchase(int price) {
		boolean result = false;
		int charge = inputMoney - price;
		if (charge < 0) {
			return result;
		} else {
			result = true;
		}
		return result;
	}
	
	//start method is for calculating remaining time for payment
	private void start() {
		worker = new SwingWorker<Boolean, Integer>() {

			@Override
			protected Boolean doInBackground() throws Exception {
				
				//user have to complete payment in 10 seconds
				for (int i = 9; i >= 0 ; i--) {
					
					//if stopThread is true, stop counting values
					//stopThread is set true after payment
					if (stopThread)
					{
						break;
					}
					
					Thread.sleep(1000);
					time = i;
					
					//publish time value for GUI
					publish(time);
				}
				
				//if stopThread is true, return false
				if (stopThread) {
					return false;
				}
				else
				{
					return true;
				}
				
			}
			
			@Override
			protected void process(List<Integer> chunks) {
				
				Integer time = chunks.get(chunks.size() - 1); //time value
				timeLabel.setText(Integer.toString(time)); //show time value for each calculation on the label
				
			}
			
			@Override
			protected void done() {
				
				try {
				    Boolean status = get();
				    if (status) {
				    	
				    	//go to main page if there was payment time out
						Main_Page mainPage = new Main_Page();
				        mainPage.setVisible(true);
				        setVisible(false);
				    	
				    }
				    
				    else {
				    	
				    	//quit payment page if payment was complete
				    	setVisible(false);
				    	
				    }
				    
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		worker.execute(); //execute worker	
	}
	
	/**
	 * Create the frame.
	 * @param price 
	 * @param useTime 
	 * @param seatNum 
	 * @param mobile 
	 * @param name 
	 */
	public Payment_Page(String name, String phoneNumber, int seatNum, String useTime, int price) {
		setTitle("SKKU study cafe");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				//start method is performed automatically after window is opened
				start();
				
			}
		});
		
		int seat = seatNum + 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		guideLabel = new JLabel("Select Hours, <dynamic>");
		guideLabel.setHorizontalAlignment(SwingConstants.LEFT);
		guideLabel.setForeground(Color.WHITE);
		guideLabel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		guideLabel.setBounds(12, 28, 296, 40);
		contentPane.add(guideLabel);
		
		viewButton = new JButton("View Seat");
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//go to seat page if view seat button is clicked
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
		
		logoutButton = new JButton("Log Out");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//go to main page if log out button is clicked
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
		
		summaryLabel = new JLabel("Summary of your payment");
		summaryLabel.setForeground(Color.BLACK);
		summaryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		summaryLabel.setBounds(12, 130, 286, 30);
		contentPane.add(summaryLabel);
		
		seatLabel = new JLabel("· Selected seat: " + seat);
		seatLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		seatLabel.setBounds(12, 170, 286, 15);
		contentPane.add(seatLabel);
		
		useTimeLabel = new JLabel("· Use Time: " + useTime);
		useTimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		useTimeLabel.setBounds(12, 195, 286, 15);
		contentPane.add(useTimeLabel);
		
		priceLabel = new JLabel("· Payment Amount: " + price + " won");
		priceLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		priceLabel.setBounds(12, 220, 286, 15);
		contentPane.add(priceLabel);
		
		startTimeLabel = new JLabel("· Start Time: " + FileManager.instance.format.format(System.currentTimeMillis()));
		startTimeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		startTimeLabel.setBounds(12, 245, 286, 15);
		contentPane.add(startTimeLabel);
		
		paymentLabel = new JLabel("Payment method");
		paymentLabel.setForeground(Color.BLACK);
		paymentLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		paymentLabel.setBounds(12, 297, 286, 30);
		contentPane.add(paymentLabel);
		
		cashButton = new JButton("Cash Payment");
		cashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//after cash payment button is clicked, buttons for cash payment becomes visible
				inputMoneyLabel.setVisible(true);
				inputTextField.setVisible(true);
				btn_1000.setVisible(true);
				btn_5000.setVisible(true);
				btn_10000.setVisible(true);
				cancelButton.setVisible(true);
				payButton.setVisible(true);
				
			}
		});
		cashButton.setForeground(Color.WHITE);
		cashButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		cashButton.setBackground(new Color(192, 192, 192));
		cashButton.setBounds(12, 337, 120, 40);
		contentPane.add(cashButton);
		
		cardButton = new JButton("Card Payment");
		cardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//card payment is being prepared in SKKU study cafe system
				JOptionPane.showMessageDialog(null, "Card payment is being prepared.", "Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		cardButton.setForeground(Color.WHITE);
		cardButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		cardButton.setBackground(new Color(192, 192, 192));
		cardButton.setBounds(178, 337, 120, 40);
		contentPane.add(cardButton);
		
		inputMoneyLabel = new JLabel("· Input Money: ");
		inputMoneyLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		inputMoneyLabel.setBounds(12, 413, 97, 15);
		contentPane.add(inputMoneyLabel);
		
		inputTextField = new JTextField();
		inputTextField.setText("0");
		inputTextField.setEnabled(false);
		inputTextField.setEditable(false);
		inputTextField.setBounds(107, 409, 191, 21);
		contentPane.add(inputTextField);
		inputTextField.setColumns(10);
		
		//if money button is clicked, add money value to inputMoney
		btn_1000 = new JButton("1000");
		btn_1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputMoney += 1000;
				inputTextField.setText(Integer.toString(inputMoney));
			}
		});
		btn_1000.setForeground(Color.WHITE);
		btn_1000.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_1000.setBackground(new Color(100, 149, 237));
		btn_1000.setBounds(12, 438, 97, 30);
		contentPane.add(btn_1000);
		
		btn_5000 = new JButton("5000");
		btn_5000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inputMoney += 5000;
				inputTextField.setText(Integer.toString(inputMoney));
				
			}
		});
		btn_5000.setForeground(Color.WHITE);
		btn_5000.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_5000.setBackground(new Color(222, 184, 135));
		btn_5000.setBounds(117, 438, 97, 30);
		contentPane.add(btn_5000);
		
		btn_10000 = new JButton("10000");
		btn_10000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inputMoney += 10000;
				inputTextField.setText(Integer.toString(inputMoney));
				
			}
		});
		btn_10000.setForeground(Color.WHITE);
		btn_10000.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btn_10000.setBackground(new Color(154, 205, 50));
		btn_10000.setBounds(222, 438, 97, 30);
		contentPane.add(btn_10000);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//show dialog "Payment canceled" if cancel button is clicked
				inputMoney = 0;
				inputTextField.setText(Integer.toString(inputMoney));
				JOptionPane.showMessageDialog(null, "Payment canceled", "Message", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(12, 489, 120, 40);
		contentPane.add(cancelButton);
		
		payButton = new JButton("Pay Now");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if pay now button is clicked, purchase can be checked with purchase method
				if (purchase(price)) {
					//stopThread set true, because payment ended
					stopThread = true;
					JOptionPane.showMessageDialog(null, "Payment Successful!", "Message", JOptionPane.PLAIN_MESSAGE);
					//confirm seat assignment using checkIn method in FileManager
					FileManager.instance.checkIn(phoneNumber, useTime, seatNum);
				} else {
					JOptionPane.showMessageDialog(null, "Not Enough Money!", "Message", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
			}
		});
		payButton.setForeground(Color.WHITE);
		payButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		payButton.setBackground(Color.LIGHT_GRAY);
		payButton.setBounds(178, 489, 120, 40);
		contentPane.add(payButton);
		
		remainLabel = new JLabel("Time Remaining:");
		remainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		remainLabel.setBounds(397, 138, 133, 15);
		contentPane.add(remainLabel);
		
		timeLabel = new JLabel("10");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		timeLabel.setBounds(397, 157, 133, 53);
		contentPane.add(timeLabel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Payment_Page.class.getResource("/image/character_background.png")));
		lblNewLabel.setBounds(0, 95, 584, 466);
		contentPane.add(lblNewLabel);
		
		inputMoneyLabel.setVisible(false);
		inputTextField.setVisible(false);
		btn_1000.setVisible(false);
		btn_5000.setVisible(false);
		btn_10000.setVisible(false);
		cancelButton.setVisible(false);
		payButton.setVisible(false);
		
	}
}
