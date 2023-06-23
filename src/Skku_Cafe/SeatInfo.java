package Skku_Cafe;

public class SeatInfo {
	private int seatNum = 0;
	private boolean seatUse = false; //Whether the seat is in use

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public boolean isSeatUse() {
		return seatUse;
	}

	public void setSeatUse(boolean seatUse) {
		this.seatUse = seatUse;
	}

}
