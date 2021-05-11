package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.AbstractRowProcessor;

import db.BatchDB;
import db.BatchDBIF;
import db.DataAccessException;
import model.Batch;
import model.Notification;
import model.Status;

public class BatchController {
	private  BatchDBIF batchDB = new BatchDB();
	
	public BatchController() throws DataAccessException, SQLException {
		this.batchDB = new BatchDB();
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

	public ArrayList<Batch> generatePendingList() throws DataAccessException {
		// TODO Auto-generated method stub
		List<Batch> res = new ArrayList<>();
		LocalDate today = LocalDate.now();
		findAll(); 
		if(!batch.hasNotification()) { //if batch has no notification
			
		
			LocalDate date = batch.getExpirationDate().minusDays(batch.getWarningPeriod());  
			if(today.isAfter(date) ) {
				
				Notification n = new Notification("Note", 0, Status.PENDING);
				batch.setNotification(n);
				
				
				findAllByStatus();
				
				
				//hvis dato har n�et warningperiod oprettes en notifikation med status pending
				//create en notifikation
			}
			//hent batches med status pending
        }
		
		return null;
	}
	

	public List<Batch> generateDiscountList() throws DataAccessException {
		return (findAllByStatus(Status.DISCOUNT)); // get batches with state discount
	}
	
	
	private List<Batch> findAllByStatus(Status state) throws DataAccessException {
		return batchDB.findAllByStatus(state);
	}
/*
	public  List<Batch> findAll(){
		return batchDB.findAll();		
	}
	*/
	public List<Batch> getPDList() throws DataAccessException{
		List<Batch> epd = new ArrayList<>();
		epd.addAll(findAllByStatus(Status.PENDING));
		epd.addAll(findAllByStatus(Status.DISCOUNT));
		return epd;
	}
	
}
	

