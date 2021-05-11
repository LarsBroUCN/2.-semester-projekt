package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;
import model.Notification;
import model.Status;

public class GenerateListController {

	private ExpiredListController elc;
	private PendingListController plc;
	private DiscountListController dlc;
	
	public GenerateListController() throws SQLException, DataAccessException {
		elc = new ExpiredListController();
		plc = new PendingListController();
		dlc = new DiscountListController();
	}
	
	private ArrayList<Batch> batchList = new ArrayList<Batch>();
	private ArrayList<Notification> notificationList = new ArrayList<Notification>();
	
	public void generateList(Status status) throws DataAccessException {
		ArrayList<Batch> expiredList = new ArrayList<Batch> (elc.generateExpiredList());
		ArrayList<Batch> pendingList = new ArrayList<Batch> (plc.generatePendingList());
		ArrayList<Batch> discountList = new ArrayList<Batch> (dlc.generateDiscountList());
		
		//join batchLists
		addToBatchList(expiredList);
		addToBatchList(pendingList);
		addToBatchList(discountList);
		
		createNotificationListFromBatchList(batchList); //Find notifications from batchList and transfer to notificationList
	}
	
	private void createNotificationListFromBatchList(ArrayList<Batch> batches){
		for(Batch batch : batches) {
			notificationList.add(batch.getNotification());
		}
	}
	
	private void addToBatchList(ArrayList<Batch> batches) {
		for(Batch batch : batches) {
			batchList.add(batch);
		}
	}
	
	private ArrayList<Notification> getNotifikationCopyList(){
		ArrayList<Notification> notificationListcopy = new ArrayList<Notification>(notificationList); // create copy of list notificationList
		
		return notificationListcopy; //return copy of list
	}
	
}
