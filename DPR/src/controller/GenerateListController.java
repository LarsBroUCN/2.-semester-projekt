package controller;

import java.util.ArrayList;
import java.util.List;

import model.Batch;
import model.Notification;
import model.Status;

public class GenerateListController {

	private ArrayList<Batch> batchList = new ArrayList<Batch>();
	private ArrayList<Notification> notificationList = new ArrayList<Notification>();
	
	public void generateList(Status status) {
		ArrayList<Batch> expiredList = new ArrayList<Batch> (ExpiredListController.generateExpiredList());
		ArrayList<Batch> pendingList = new ArrayList<Batch> (PendingListController.generatePendingList());
		ArrayList<Batch> discountList = new ArrayList<Batch> (DiscountListController.generateDiscountList());
		
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
