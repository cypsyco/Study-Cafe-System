package Skku_Cafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class FileManager {

	File file = null; //check whether the file exists
	FileWriter fout = null; //write
	FileReader reader = null; //read
	BufferedReader br = null; //read by line

	final String USER_PATH = "userdata.txt"; //user information file path
	final String SEAT_PATH = "seatdata.txt"; //seat information file path

	String userData;
	String seatData;
	boolean isLoad = false; //check whether the file load was successful

	static int LOG = -1;

	ArrayList<UserInfo> userManager = null;
	ArrayList<SeatInfo> seatManager = null;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();

	public static FileManager instance = new FileManager();

	public static FileManager getInstance() {
		return instance;
	}
	
	//define ArryList for using information during runtime
	private FileManager() {
		userManager = new ArrayList<>();
		seatManager = new ArrayList<>();
	}

	//add new user
	public void addUser(UserInfo user) {
		userManager.add(user);
		addData(user);
		saveUserData();
	}

	void updateUser(int index, UserInfo user) {
		userManager.set(index, user);
		addData();
		saveUserData();
	}

	//log in method, check user data
	String login(String mobile, String pw) {
		String check_id = "";
		for (int i = 0; i < userManager.size(); i++) {
			if (mobile.equals(userManager.get(i).getMobile()) && pw.equals(userManager.get(i).getPw())) {
				check_id = userManager.get(i).getName();
				LOG = i;
				break;
			}
		}
		return check_id;
	}

	//check out if user is using any seat
	boolean checkOut(String mobile) {
		//check userManager information, and use get method for getting user seat information
		for (int i = 0; i < userManager.size(); i++) {
			if (mobile.equals(userManager.get(i).getMobile())) {
				if (!userManager.get(i).seatUse) {
					JOptionPane.showMessageDialog(null, "You are not using any seat.", "Message", JOptionPane.WARNING_MESSAGE);
					break;
				}
				for (int j = 0; j < seatManager.size(); j++) {
					if (seatManager.get(j).getSeatNum() == userManager.get(i).getSeatNum()) {
						seatManager.get(j).setSeatUse(false);
						saveSeatData();
						break;
					}
				}
				userManager.get(i).setSeatNum(-1);
				userManager.get(i).seatUse = false;
				if (userManager.get(i).getMaxTime() > 0) {
					Date pre = null;
					Date now = new Date();
					try {
						pre = FileManager.instance.format.parse(userManager.get(i).getPreTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}

					long diffHour = (now.getTime() - pre.getTime()) / (60 * 60 * 1000);
					if (diffHour > 0) {
						userManager.get(i).setMaxTime(userManager.get(i).getMaxTime() - (int) diffHour);
					}
					userManager.get(i).setMaxTime(0);
					userManager.get(i).setPreTime("0");
				}
				updateUser(i, userManager.get(i));
				return true;
			}
		}
		return false;
	}

	//check in by value of phone number, use time, and seat number
	void checkIn(String mobile, String useTime, int seatNum) {
		LOG = -1;
		for (int i = 0; i < userManager.size(); i++) {
			if (mobile.equals(userManager.get(i).getMobile())) {
				userManager.get(i).setSeatNum(seatNum);
				userManager.get(i).setMaxTime(Integer.parseInt(useTime));
				userManager.get(i).setPreTime(format.format(System.currentTimeMillis()));
				userManager.get(i).seatUse = true;
				updateUser(i, userManager.get(i));
				LOG = i;
				break;
			}
		}
		
		//if user do not properly approach the page starting from main page
		if (LOG == -1) {
			JOptionPane.showMessageDialog(null, "Unauthorized access.", "Message", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}

		for (int i = 0; i < seatManager.size(); i++) {
			if (seatNum == seatManager.get(i).getSeatNum()) {
				seatManager.get(i).setSeatUse(true);
				saveSeatData();
			}
		}
		JOptionPane.showMessageDialog(null, "Your receipt has been printed.", "Message", JOptionPane.PLAIN_MESSAGE);
		Main_Page mainPage = new Main_Page();
        mainPage.setVisible(true);
	}

	//showing new user is saved
	private void addData() {
		userData = "";
		for (UserInfo user : userManager) {
			userData += user.getName() + "/";
			userData += user.getMobile() + "/";
			userData += user.getPw() + "/";
			userData += user.getSeatNum() + "/";
			userData += user.getMaxTime() + "/";
			userData += user.getPreTime() + "/";
			userData += user.seatUse + "\n";
		}
		System.out.println(" == save == \n" + userData);
	}

	//adding new user in userManager array
	private void addData(UserInfo user) {
		//save added user information
		int lastIndex = userManager.size() - 1;
		UserInfo temp = userManager.get(lastIndex);
		userData += temp.getName() + "/";
		userData += temp.getMobile() + "/";
		userData += temp.getPw() + "/";
		userData += temp.getSeatNum() + "/";
		userData += temp.getMaxTime() + "/";
		userData += temp.getPreTime() + "/";
		userData += temp.seatUse + "\n";
		System.out.println(" == save == \n" + userData);
	}

	//update userdata.txt file for saving information
	private void saveUserData() {
		try {
			fout = new FileWriter(USER_PATH);
			fout.write(userData);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fout = null;
	}

	//load user information to array
	public void loadUser(String userText) {
		String userinfo[] = userText.split("/");
		UserInfo temp = new UserInfo();
		temp.setName(userinfo[0]);
		temp.setMobile(userinfo[1]);
		temp.setPw(userinfo[2]);
		temp.setSeatNum(Integer.parseInt(userinfo[3]));
		temp.setMaxTime(Integer.parseInt(userinfo[4]));
		temp.setPreTime(userinfo[5]);
		temp.seatUse = Boolean.valueOf(userinfo[6]);
		userManager.add(temp);
	}

	//show loaded user information from userdata.txt file
	void loadData() {
		file = new File(USER_PATH);
		isLoad = false;
		userData = "";
		if (!file.exists())
			return;
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			while (true) {
				String userText = br.readLine();
				if (userText == null)
					break;
				userData += userText + "\n";
				loadUser(userText);
				isLoad = true;
			}
			reader.close();
			br.close();
			if (isLoad) {
				System.out.println("== load == \n" + userData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		file = null;
		reader = null;
		br = null;
	}

	//save seat file
	public void saveSeatData() {
		String info = "";
		for (int i = 0; i < seatManager.size(); i++) {
			info += seatManager.get(i).getSeatNum();
			info += "/";
			info += seatManager.get(i).isSeatUse();
			if (i != seatManager.size() - 1) {
				info += "\n";
			}
		}
		try {
			fout = new FileWriter(SEAT_PATH);
			fout.write(info);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fout = null;
	}

	//load seat information to array
	public void loadSeat(String seatText) {
		String seatinfo[] = seatText.split("/");
		SeatInfo temp = new SeatInfo();
		temp.setSeatNum(Integer.parseInt(seatinfo[0]));
		temp.setSeatUse(Boolean.valueOf(seatinfo[1]));
		seatManager.add(temp);
	}

	//show loaded seat information from seatdata.txt file
	void loadSeatData() {
		file = new File(SEAT_PATH);
		isLoad = false;
		seatData = "";
		if (!file.exists()) {
			for (int i = 0; i < 28; i++) {
				SeatInfo temp = new SeatInfo();
				temp.setSeatNum(i + 1);
				temp.setSeatUse(false);
				seatManager.add(temp);
			}
			saveSeatData();
			return;
		}
		try {
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			while (true) {
				String seatText = br.readLine();
				if (seatText == null)
					break;
				seatData += seatText + "\n";
				loadSeat(seatText);
				isLoad = true;
			}
			reader.close();
			br.close();
			if (isLoad) {
				System.out.println("== load == \n" + seatData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		file = null;
		reader = null;
		br = null;
	}

}
