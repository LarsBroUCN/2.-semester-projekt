package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import db.BatchDB;
import model.Batch;

public class BatchController {

	public static  ArrayList<Batch> generateExpiredList() {
		Batch batch = null;// get batch 
		LocalDate date = java.time.LocalDate.now(); // get time
		if(batch.getExpirationDate().isAfter(date)) { // if batch expired
			if(batch.hasNotification()) { //if batch has no notification
				// batch.getNotification().setStatus(EXPIRED); // set state to expired 
				// set state to expired in database
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
