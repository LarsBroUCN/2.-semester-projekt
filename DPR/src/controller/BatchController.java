package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import db.BatchDB;
import db.BatchDBIF;
import db.DataAccessException;
import model.Batch;
import model.Notification;
import model.Status;

public class BatchController {
	private  BatchDBIF batchDB = new BatchDB();

	private ArrayList<Batch> res;
	Batch batch = null;
	
	

	
	public BatchController() throws DataAccessException, SQLException {
		this.batchDB = new BatchDB();
		res = new ArrayList<>();
	}

	private BatchDB bdb;
	

	
	



	public List<Batch> generateExpiredList() throws Exception {
		List<Batch> res = new ArrayList<>();
		LocalDate date = java.time.LocalDate.now(); // get time

		for(Batch batch : getPDList()) { // get batch 
			if(batch.getExpirationDate().isAfter(date)) { // if batch expired
				if(batch.hasNotification()) { //if batch has notification
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
		List<Batch> res = new ArrayList<>(); //local arraylist
		

		batchDB.findAllNotNotification(); //get batches with no notifications 
			if(!batch.hasNotification()) { //checks if there is any notifications
		 
		LocalDate today = LocalDate.now(); //get the time
		LocalDate date = batch.getExpirationDate().minusDays(batch.getWarningPeriod());  
			if(today.isAfter(date) ) { //check if its time to create a notification
	
			Notification n = new Notification(null, 0, Status.PENDING); //create a notification with pending status
			  batch.setNotification(n);
						  	

			  	res.add(batch);	//adds to local Arraylist			  	
					  batchDB.updateBatch(batch); //opdate the database 
			
        }
		
				}else {
					throw new Exception("Batch ID: " + batch.getBatchID() + " Ingen notifikation");
				}
		
   
		res.addAll(findAllByStatus(Status.PENDING)); // get batches with state pending
		return res; // returns the list
	}

	

	
	
	
	
	
	private List<Batch> findAllByStatus(Status state) throws DataAccessException {
		return batchDB.findAllByStatus(state);
	}
	
	public List<Batch> getPDList() throws DataAccessException{
		List<Batch> epd = new ArrayList<>();
		epd.addAll(findAllByStatus(Status.PENDING));
		epd.addAll(findAllByStatus(Status.DISCOUNT));
		return epd;
	}


	public List<Batch> generateDiscountList() throws DataAccessException {
		return (findAllByStatus(Status.DISCOUNT)); // get batches with state discount
	}
	
	
	
/*
	public  List<Batch> findAll(){
		return batchDB.findAll();		
>>>>>>> 245c00a5ce4c013df5304fd3afdbbc2b549c7e44
	}
	*/
	
	
}
	









