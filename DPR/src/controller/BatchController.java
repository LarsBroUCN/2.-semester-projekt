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
	
	Batch batch = null;
	
	
	
	public BatchController() throws DataAccessException, SQLException {
		this.batchDB = new BatchDB();
	}

	public ArrayList<Batch> generateExpiredList() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public ArrayList<Batch> generateDiscountList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

	public ArrayList<Batch> generatePendingList() throws DataAccessException {
		// TODO Auto-generated method stub
		List<Batch> res = new ArrayList<>();
		LocalDate today = LocalDate.now();
		findAll(); 
		if(!batch.hasNotification()) { //if batch has no notification
			
		
			LocalDate date = batch.getExpirationDate().minusDays(batch.getWarningPeriod());  
			if(today.isAfter(date) ) {
				
				Notification n = new Notification("Note", 0, Status.valueOf("pending"));
				batch.setNotification(n);
				
				
				findByStatus();
				
				
				//hvis dato har nået warningperiod oprettes en notifikation med status pending
				//create en notifikation
			}
			//hent batches med status pending
        }
		
		return null;
	}
	
	
	
	
	private Batch findByStatus(int id) {
		
		
		return batchDB.findByStatus(id);
		
	}

	public  List<Batch> findAll(){
		return batchDB.findAll();		
	}
	
	

}
