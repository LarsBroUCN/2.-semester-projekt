package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.BatchDB;
import db.BatchDBIF;
import db.DataAccessException;
import db.NotificationDB;
import db.NotificationDBIF;
import model.Batch;
import model.Notification;
import model.Status;

public class BatchController {
	private BatchDBIF batchDB;
	private NotificationDBIF notificationDB;
	private BatchDB bdb = new BatchDB();

	private ArrayList<Batch> res;
	Batch batch = null;

	public BatchController() throws DataAccessException, SQLException {
		this.batchDB = new BatchDB();
		this.notificationDB = new NotificationDB();
		res = new ArrayList<>();
	}
	

	public List<Batch> generateExpiredList() throws Exception {
		List<Batch> res = new ArrayList<>();
		LocalDate date = LocalDate.now(); // get time
		for (Batch batch : getPDList()) { // get batch			
			if (date.isAfter(batch.getExpirationDate())) { // if batch expired
				if (batch.hasNotification()) { // if batch has notification
					batch.getNotification().setStatus(Status.EXPIRED); // set state to expired
					bdb.updateBatch(batch);// save batch with updated state expired in database
				} else {
					throw new Exception("Batch ID:" + batch.getBatchID() + " Ingen notifikation");
				}
			}
		}
		res.addAll(findAllByStatus(Status.EXPIRED)); // get batches with state expired
		return res;
	}

	public List<Batch> generatePendingList() throws Exception {
		List<Batch> res = new ArrayList<>(); // local arraylist
		List<Batch> batchList = batchDB.findAllNotNotification(); // get batches with no notifications		
		for (Batch batch : batchList) {
			if (!batch.hasNotification()) { // checks if there is any notifications
				LocalDate today = LocalDate.now(); // get the time
				LocalDate date = batch.getExpirationDate().minusDays(batch.getWarningPeriod());
				if (today.isAfter(date)) { // check if its time to create a notification
					Notification n = new Notification(-1, null, 5, Status.PENDING); // create a notification with pending																				
					batch.setNotification(n);					
					notificationDB.insertNotification(n, batch.getBatchID()); //creates a new notification in DB					
				}
			} else {
				throw new Exception("Batch ID: " + batch.getBatchID() + " Ingen notifikation");
			}
		}

		res.addAll(findAllByStatus(Status.PENDING)); // get batches with state pending
		return res; // returns the list
	}

	private List<Batch> findAllByStatus(Status state) throws DataAccessException {
		return batchDB.findAllByStatus(state);
	}


	public List<Batch> getPDList() throws DataAccessException{
		List<Batch> pd = new ArrayList<>();
		pd.addAll(findAllByStatus(Status.PENDING));
		pd.addAll(findAllByStatus(Status.DISCOUNT));
		return pd;
	}
	public List<Batch> generateDiscountList() throws DataAccessException {
		return (findAllByStatus(Status.DISCOUNT)); // get batches with state discount
	}

	

}
