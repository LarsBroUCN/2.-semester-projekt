package model;

import java.time.LocalDate;

public class Batch {

	private int batchID;
	private LocalDate arrivalDate;
	private int warningPeriod;
	private LocalDate expirationDate;
	private Product product;
	private Notification notification;

	public Batch(int batchID, LocalDate arrivalDate, int warningPeriod, LocalDate expirationDate, Product product,
			Notification notification) {
		super();
		this.batchID = batchID;
		this.arrivalDate = arrivalDate;
		this.warningPeriod = warningPeriod;
		this.expirationDate = expirationDate;
		this.product = product;
		this.notification = notification;
	}

	public boolean hasNotification() {
		if (notification != null) {
			return true;
		} else {
			return false;
		}
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getWarningPeriod() {
		return warningPeriod;
	}

	public void setWarningPeriod(int warningPeriod) {
		this.warningPeriod = warningPeriod;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

}
