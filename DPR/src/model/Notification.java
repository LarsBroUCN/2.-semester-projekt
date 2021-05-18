package model;

public class Notification {
	private int notificationID;
	private String note;
	private double discount;
	private Status status;
	
	public Notification(int notificationID, String note, double discount, Status status) {
		super();
		this.notificationID = notificationID;
		this.note = note;
		this.discount = discount;
		this.status = status;
	}

	public int getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(int notificationID) {
		this.notificationID = notificationID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
