package Skku_Cafe;

//UserInfo inherits PersonInfo with more specific user information
public class UserInfo extends PersonInfo{
	private String pw; //password
	private int seatNum; //seat number
	private int maxTime; //total use time available
	private String preTime; //start using time
	boolean seatUse = false; //whether uses seats

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public String getPreTime() {
		return preTime;
	}

	public void setPreTime(String preTime) {
		this.preTime = preTime;
	}

}