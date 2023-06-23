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

public class Update_Page extends JFrame {

	private JPanel contentPane;
	private static String dummy;
	private JLabel titleLabel;
	private JLabel pwLable;
	private JLabel confirmLabel;
	private JTextField pwTextField;
	private JTextField cofirmTextField;
	private JButton cancelButton;
	private JButton submitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Page frame = new Update_Page(dummy);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param phoneNumber 
	 */
	public Update_Page(String phoneNumber) {
		setTitle("SKKU study cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titleLabel = new JLabel("CHANGE PASSWORD");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		titleLabel.setBounds(12, 10, 410, 46);
		contentPane.add(titleLabel);
		
		pwLable = new JLabel("NEW PASSWORD:");
		pwLable.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLable.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		pwLable.setBounds(61, 66, 108, 46);
		contentPane.add(pwLable);
		
		confirmLabel = new JLabel("ENTER AGAIN:");
		confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		confirmLabel.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		confirmLabel.setBounds(61, 122, 108, 46);
		contentPane.add(confirmLabel);
		
		pwTextField = new JTextField();
		pwTextField.setBounds(181, 78, 170, 21);
		contentPane.add(pwTextField);
		pwTextField.setColumns(10);
		
		cofirmTextField = new JTextField();
		cofirmTextField.setColumns(10);
		cofirmTextField.setBounds(181, 134, 170, 21);
		contentPane.add(cofirmTextField);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//dispose if user clicks cancel button
				dispose();
				
			}
		});
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(new Color(0, 128, 0));
		cancelButton.setBounds(61, 178, 97, 46);
		contentPane.add(cancelButton);
		
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//check if there is empty field
				if (pwTextField.getText().equals("") || cofirmTextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Input every field.", "Message", JOptionPane.WARNING_MESSAGE);
					return;
				//check if passwords match
				} else if (!(pwTextField.getText().equals(cofirmTextField.getText()))) {
					JOptionPane.showMessageDialog(null, "Password does not match.", "Message", JOptionPane.WARNING_MESSAGE);
					return;
				} else {
					for (int i = 0; i < FileManager.instance.userManager.size(); i++) {
						if (phoneNumber.equals(FileManager.instance.userManager.get(i).getMobile())) {
							FileManager.instance.userManager.get(i).setPw(pwTextField.getText());
							FileManager.instance.updateUser(i, FileManager.instance.userManager.get(i));
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "Password successfully changed.", "Message", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
				
			}
		});
		submitButton.setForeground(Color.WHITE);
		submitButton.setBackground(new Color(0, 128, 0));
		submitButton.setBounds(254, 178, 97, 46);
		contentPane.add(submitButton);
	}
}
