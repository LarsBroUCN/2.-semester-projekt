package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import db.BatchDB;
import db.DataAccessException;
import model.Batch;

public class BatchController {

	private BatchDB bdb;
	
	
	public BatchController() throws SQLException, DataAccessException {
		this.bdb = new BatchDB();
	}

	public ArrayList<Batch> generateExpiredList() throws DataAccessException {
		
		for(Batch batch : bdb.findAllByStatus(null)) {
			
		}
		Batch batch = null;// get batch 
		LocalDate date = java.time.LocalDate.now(); // get time
		if(batch.getExpirationDate().isAfter(date)) { // if batch expired
			if(batch.hasNotification()) { //if batch has notification
				
				// batch.getNotification().setStatus(EXPIRED); // set state to expired 
				// set state to expired in database
				
			} else {
				// TODO ERROR missing Notification
			}
		}
		getBatchWithState(); // get batches with state expired
		return null;
	}

	public static ArrayList<Batch> generatePendingList() {
		// TODO Auto-generated method stub
		//check batch om den har en notifikation --> og hvis den ikke har en 
		//check datoen på batch
		//hvis dato har nået warningperiod oprettes en notifikation med status pending
		//hent batches med status pending
		return null;
	}

	public static ArrayList<Batch> generateDiscountList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Batch getBatchWithState() {
		return null;
	}

}
