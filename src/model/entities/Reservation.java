package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exeptions.DomainExeption;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainExeption(" Check-out date be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getChecOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDate(Date checkIn, Date checkout) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainExeption(" Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExeption(" Check-out date be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkout;

	}

	@Override
	public String toString() {
		return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ",check-out: " + sdf.format(checkOut) + ", "
				+ duration() + " nights";

	}

}
